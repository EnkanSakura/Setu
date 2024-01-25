package top.enkansakura.util

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.contact.Group
import net.mamoe.mirai.contact.User
import top.enkansakura.Setu
import java.util.*

object Cooldown {

    private val userCooldownMap = Collections.synchronizedMap(mutableMapOf<Long, Mutex>())

    private val groupCooldownMap = Collections.synchronizedMap(mutableMapOf<Long, Mutex>())

    private fun getCooldownLock(subject: Contact?): Mutex? {
        return when (subject) {
            is User -> userCooldownMap.getOrPut(subject.id) { Mutex() }
            is Group -> groupCooldownMap.getOrPut(subject.id) { Mutex() }
            else -> null
        }
    }

    fun getCooldownStatus(subject: Contact?): Boolean {
        return getCooldownLock(subject)?.isLocked ?: false
    }

    suspend fun cooldown(subject: Contact?, time: Int) = Setu.launch {
        getCooldownLock(subject)?.withLock {
            delay(time * 1000L)
        }
    }

}