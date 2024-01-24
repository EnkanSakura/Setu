package top.enkansakura

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import top.enkansakura.config.Config
import java.io.File

object Setu : KotlinPlugin(
    JvmPluginDescription(
        id = "top.enkansakura.setu",
        name = "Setu",
        version = "1.0.0",
    ) {
        author("EnkanSakura")
        info("""用来从lolicon api 获取setu的插件
        """.trimMargin())
    }
) {
    override fun onEnable() {
        logger.info { "Lolicon Setu Loaded" }
    }

    internal val cacheFolder: File by lazy {
        val folder = Setu.dataFolder.resolve("cache")
        if (Config.save && !folder.exists()) {
            folder.mkdirs()
        }
        folder
    }

}