package top.enkansakura.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object CommandConfig :AutoSavePluginConfig("CommandConfig") {

    @ValueDescription("指令别名")
    val cmdName: Array<String> by value(arrayOf("涩图", "setu"))

}