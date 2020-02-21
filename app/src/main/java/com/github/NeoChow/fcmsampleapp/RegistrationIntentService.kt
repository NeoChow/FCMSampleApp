package com.github.NeoChow.fcmsampleapp

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId


class RegistrationIntentService :
    IntentService(TAG) {
    override fun onHandleIntent(intent: Intent?) {
        try {
            val token = FirebaseInstanceId.getInstance().token
            Log.i(
                TAG,
                "FCM Registration Token: $token"
            )
            // TODO: Implement this method to send any registration to your app's servers.
            sendRegistrationToServer(token)
        } catch (e: Exception) {
            Log.d(
                TAG,
                "Failed to complete token refresh",
                e
            )
        }
    }

    private fun sendRegistrationToServer(token: String?) { // TODO: send the token to SNS and create platform endpoint
    }

    companion object {
        private const val TAG = "RegIntentService"
    }
}
