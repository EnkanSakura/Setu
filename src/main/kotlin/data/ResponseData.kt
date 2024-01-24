package top.enkansakura.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class ResponseData(
    val error: String,
    val data: List<SetuData>
) {
    override fun toString(): String {
        return Json.encodeToString(this)
    }
}