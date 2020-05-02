package com.future.media

class MediaCommand {

    companion object {

        const val NOTIFICATION_STATUS_SHOW = "NOTIFICATION_STATUS_SHOW"
        const val NOTIFICATION_STATUS_HIDE = "NOTIFICATION_STATUS_HIDE"

        private var INSTANCE: MediaCommand? = null

        @JvmStatic
        fun get(): MediaCommand = INSTANCE ?: synchronized(MediaCommand::class) {
            INSTANCE ?: MediaCommand().also { INSTANCE = it }
        }
    }

    private var notificationCommand: String = NOTIFICATION_STATUS_SHOW

    fun setNotificationCommand(command: String) {
        this.notificationCommand = command
    }

    fun isNotificationStatusShow(): Boolean = notificationCommand == NOTIFICATION_STATUS_SHOW

    fun isNotificationStatusHide(): Boolean = notificationCommand == NOTIFICATION_STATUS_HIDE
}