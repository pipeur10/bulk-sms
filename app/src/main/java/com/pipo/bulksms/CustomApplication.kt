package com.pipo.bulksms

import android.app.*
import android.content.BroadcastReceiver
import android.os.Build
import com.pipo.bible.di.DaggerAppComponent
import com.pipo.bulksms.utils.PrefHelper
import dagger.android.*
import javax.inject.Inject

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:02 PM
 */
class CustomApplication: Application(), HasActivityInjector, HasServiceInjector, HasBroadcastReceiverInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var serviceDispatchingAndroidInjector: DispatchingAndroidInjector<Service>
    @Inject
    lateinit var receiverDispatchingAndroidInjector: DispatchingAndroidInjector<BroadcastReceiver>

    override fun serviceInjector(): AndroidInjector<Service> = serviceDispatchingAndroidInjector

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun broadcastReceiverInjector(): AndroidInjector<BroadcastReceiver> = receiverDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        createSyncNotificationChannel()


        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    private fun createSyncNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(PrefHelper.BULK_SMS_CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }




    companion object
}