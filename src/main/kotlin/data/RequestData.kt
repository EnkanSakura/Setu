package top.enkansakura.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class RequestData(
    val r18         : Int = 0,
    val num         : Int = 1,
    val uid         : List<Int>? = null,
    val keyword     : String? = "",
    val tag         : List<List<String>>? = null,
    val size        : List<String>? = null,
    val proxy       : String = "i.pixiv.re",
    val dateAfter   : Long? = null,
    val dateBefore  : Long? = null,
    val dsc         : Boolean = true,
    val excludeAI   : Boolean = true
) {
    override fun toString(): String {
        val format = Json { encodeDefaults = true }
        return format.encodeToString(this)
    }
}
