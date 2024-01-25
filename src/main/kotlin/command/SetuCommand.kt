package top.enkansakura.command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.permission.Permission
import net.mamoe.mirai.console.permission.PermissionService
import top.enkansakura.Setu
import top.enkansakura.config.CommandConfig

object SetuCommand : CompositeCommand(
    Setu,
    primaryName = "setu",
    secondaryNames = CommandConfig.cmdName,
    description = "setu指令"
) {

    val trusted: Permission by lazy {
        PermissionService.INSTANCE.register(
            Setu.permissionId("trusted"),
            "trusted",
            Setu.parentPermission
        )
    }

    suspend fun CommandSender.get(tags: String = "") {

    }

}