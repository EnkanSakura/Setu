package top.enkansakura.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Serializable
data class SetuData(
    val pid         : Int,
    val p           : Int,
    val uid         : Int,
    val title       : String,
    val author      : String,
    val r18         : Boolean,
    val width       : Int,
    val height      : Int,
    val tags        : List<String>,
    val ext         : String,
    val aiType      : Int,
    val uploadDate  : Long,
    val urls        : Map<String, String>,
) {
    private val template = """
        标题: $title (pid: ${pid})
        作者: $author (uid: ${uid})
        标签: $tags
        链接: https://pixiv.net/artworks/${pid}
    """.trimIndent()

    override fun toString(): String {
        return "SetuData" + Json.encodeToString(this)
    }

    fun toReadable(): String {
        return template
    }
}
