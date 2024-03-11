package com.example.Chatbotik.notification

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings

class NotificationPermissionDialog(private val context: Context) {

    fun show() {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Allow SwiftTalk to send you notifications?")
            .setMessage("SwiftTalk would like to send you notifications. Please allow this permission.")
            .setPositiveButton("Allow") { dialog, _ ->
                openNotificationSettings()
                dialog.dismiss()

            }
            .setNegativeButton("Don't allow") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }

    private fun openNotificationSettings() {
        val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
        context.startActivity(intent)
    }
}
