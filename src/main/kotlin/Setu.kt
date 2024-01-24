package top.enkansakura

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object Setu : KotlinPlugin(
    JvmPluginDescription(
        id = "top.enkansakura.setu",
        name = "Setu",
        version = "1.0.0",
    ) {
        author("EnkanSakura")
        info("""lolicon setu plugin""")
    }
) {
    override fun onEnable() {
        logger.info { "Plugin loaded" }
    }
}