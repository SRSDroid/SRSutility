package com.srs.srsutility

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

object NetworkStatusHelper {

    fun isOnline(context: Context): Boolean {
        val baseContext = context.applicationContext
        var isOnline = false
        try {
            val manager =
                baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities =
                manager.getNetworkCapabilities(manager.activeNetwork)
            isOnline =
                capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) && capabilities.hasCapability(
                    NetworkCapabilities.NET_CAPABILITY_INTERNET
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isOnline
    }

}