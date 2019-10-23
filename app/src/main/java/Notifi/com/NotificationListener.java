package Notifi.com;

import android.app.Notification;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;



public class NotificationListener extends NotificationListenerService {
    public final static String TAG = "=====";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate():: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy():: ");
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();
        Log.e(TAG, "onListenerConnected():: ");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        // 새로운 알림이 생성되었을 때
        super.onNotificationPosted(sbn);
        Log.e(TAG, "onNotificationPosted()");

        Notification notification = sbn.getNotification();
        Bundle extras = sbn.getNotification().extras;

        String contentTitle = extras.getString(Notification.EXTRA_TITLE);
        CharSequence contentText = extras.getCharSequence(Notification.EXTRA_TEXT);
        CharSequence subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);
        CharSequence bigText = extras.getCharSequence(Notification.EXTRA_BIG_TEXT);
        CharSequence bigContentTitle = extras.getCharSequence(Notification.EXTRA_TITLE_BIG);

        Icon smallIcon = notification.getSmallIcon();
        Icon largeIcon = notification.getLargeIcon();

        Log.e(TAG, "NotiPosted::  " +
                " / id : " + sbn.getId() +
                " / bigContentTitle : " + bigContentTitle +
                " / bigText : " + bigText +
                " / contentText : " + contentText +
                " / subText : " + subText +
                " / contentTitle : " + contentTitle +
                " / icon : " + smallIcon.getResId() +
                " / packageName : " + sbn.getPackageName()
        );
    }


    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {

        // 알림이 지워졌을 때
        super.onNotificationRemoved(sbn);
        Log.e(TAG, "onNotificationRemoved():: ");

        Log.e(TAG, "NotiIRemoved:: " +
                " packageName: " + sbn.getPackageName() +
                " id: " + sbn.getId());
    }
}
