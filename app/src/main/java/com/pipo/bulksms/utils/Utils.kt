package com.pipo.bulksms.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Author: Philip
 * Date: 09/04/2018 at 12:32 PM
 */
object Utils {


    val PERMISSION_GRANTED = "PERMISSION_GRANTED"
    val SHOULD_SHOW_PERMISSION_REQUEST_RATIONAL = "SHOULD_SHOW_PERMISSION_REQUEST_RATIONAL"




    fun formatDate(value: Date): String? {


        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            return sdf.format(value)

        } catch (ex: ParseException) {
            ex.printStackTrace()
        }
        return  null
    }

    fun isValidTime(value: String?): Boolean {
        if (value == null) return false
        var time: Date? = null
        try {
            val sdf = SimpleDateFormat("HH:mm", Locale.US)
            time = sdf.parse(value)
            if (value != sdf.format(time)) {
                time = null
            }
        } catch (ex: ParseException) {
            ex.printStackTrace()
        }

        return time != null
    }


    private fun hasPermissionInManifest(context: Context, permissionName: String): Boolean {
        val packageName = context.packageName
        try {
            val packageInfo = context.packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
            val declaredPermissions = packageInfo.requestedPermissions
            if (declaredPermissions != null && declaredPermissions.isNotEmpty()) {
                for (p in declaredPermissions) {
                    if (p.equals(permissionName, ignoreCase = true)) {
                        return true
                    }
                }
            }
        } catch (e: PackageManager.NameNotFoundException) {
            //
        }

        return false
    }

    fun isExplicitPhoneStatePermissionRequired(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hasPermissionInManifest(context, "android.permission.READ_PHONE_STATE") && context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
        } else false
    }

    fun checkPermission(activity: Activity, permission1: String, permission2: String, permissionCode: Int): Map<String, Boolean> {
        val map = HashMap<String, Boolean>()

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            map[PERMISSION_GRANTED] = true
            return map
        }
        if (ContextCompat.checkSelfPermission(activity, permission1) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(activity, permission2) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            permission1) || ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            permission2)) {
                //                if(message!=null && !message.trim().isEmpty()){
                //                    L.tl(message);
                //                }
                map[SHOULD_SHOW_PERMISSION_REQUEST_RATIONAL] = true


            } else {
                map[SHOULD_SHOW_PERMISSION_REQUEST_RATIONAL] = false
                ActivityCompat.requestPermissions(activity,
                        arrayOf(permission1, permission2),
                        permissionCode)
            }
            map[PERMISSION_GRANTED] = false
            return map

        } else {
            map[PERMISSION_GRANTED] = true
            return map

        }
    }

}
