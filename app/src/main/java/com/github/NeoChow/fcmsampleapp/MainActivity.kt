package com.github.NeoChow.fcmsampleapp

//import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.github.NeoChow.fcmsampleapp.R


//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list_item)
        setContentView(R.layout.activity_main)


        if (checkPlayServices()) {
            val intent = Intent(this, RegistrationIntentService::class.java)
            startService(intent)
        }
    }

    private fun checkPlayServices(): Boolean {
        val apiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = apiAvailability.isGooglePlayServicesAvailable(this)
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(
                    this,
                    resultCode,
                    PLAY_SERVICES_RESOLUTION_REQUEST
                )
                    .show()
            } else {
                Log.i(TAG, "This device is not supported.")
                finish()
            }
            return false
        }
        return true
    }

    companion object {
        private const val TAG = "MainActivity"
        private const val PLAY_SERVICES_RESOLUTION_REQUEST = 9000
    }
}
