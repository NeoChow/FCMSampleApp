package com.github.NeoChow.fcmsampleapp

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class MyFcmListenerService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(
            TAG,
            "Receive MSG From: " + remoteMessage.from
        )
        if (remoteMessage.data.size > 0) {
            Log.d(
                TAG,
                "Message data payload: " + remoteMessage.data
            )
        }
    }

    companion object {
        private const val TAG = "MyFirebaseMsgService"
    }
}
