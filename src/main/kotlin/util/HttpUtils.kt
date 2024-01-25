package top.enkansakura.util

import kotlinx.serialization.json.JsonElement
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import top.enkansakura.Setu.cacheFolder
import top.enkansakura.config.Config
import java.io.File
import java.io.InputStream
import java.time.Duration


class HttpUtils {

    private var client: OkHttpClient = OkHttpClient().newBuilder().connectTimeout(Duration.ofMillis(20000)).build()

    private val ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.80 Safari/537.36 Edg/98.0.1108.43"

    private val contentType = "application/json; charset=utf-8"

    private fun sendRequest(url: String, stringBody: String?=null): ResponseBody {
        val postBody = stringBody?.toRequestBody(contentType.toMediaTypeOrNull())
        val request = if (postBody == null) Request.Builder()
                .url(url)
                .header("Content-Type", contentType)
                .header("user-agent", ua)
                .get()
                .build()
        else Request.Builder()
                .url(url)
                .header("Content-Type", contentType)
                .header("user-agent", ua)
                .post(postBody)
                .build()
        val response: Response = client.newCall(request).execute()
        if (response.code != 200) {
            throw Exception("请求错误，错误码：${response.code}，返回内容：${response.message}")
        }
        return response.body ?: throw Exception("请求错误，返回内容为空")
    }

    fun get(url: String): JsonElement {
        val body = sendRequest(url)
        return json.parseToJsonElement(body.toString())
    }

    fun post(url: String, stringBody: String): JsonElement {
        val body = sendRequest(url, stringBody)
        return json.parseToJsonElement(body.toString())
    }

    private fun downloadImage(url: String): InputStream {
        val result: ByteArray = sendRequest(url).bytes()
        if (Config.save) {
            val urlPaths = url.split("/")
            val file = cacheFolder.resolve(urlPaths[urlPaths.lastIndex])
            file.writeBytes(result)
        }
        return result.inputStream()
    }

    fun uploadImage(url: String): InputStream {
        return if (Config.save && Config.cache) {
            val urlPaths = url.split("/")
            val path = "$cacheFolder/${urlPaths[urlPaths.lastIndex]}"
            val cache = File(System.getProperty("user.dir")).resolve(path)
            if (cache.exists()) {
                cache.inputStream()
            } else {
                downloadImage(url)
            }
        } else {
            downloadImage(url)
        }
    }

}
