package top.enkansakura.data

import kotlinx.serialization.Serializable

@Serializable
data class RequestBody(
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
)
