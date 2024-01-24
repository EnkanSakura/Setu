package top.enkansakura.util

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import kotlin.jvm.Throws


const val REQUEST_URL = "https://api.lolicon.app/setu/v2"
const val REQUEST_CONTENT = "application/json"

class HttpHandler {
    private var client = OkHttpClient()

    @Throws(IOException::class)
    suspend fun get(url: HttpUrl): String = runBlocking {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val future = async {
            client.newCall(request).execute().use {
                response -> response.body!!.string()
            }
        }
        return@runBlocking future.await()
    }
}