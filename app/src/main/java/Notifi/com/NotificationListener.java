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
        Log.e(TAG, "[snowdeer] onCreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "[snowdeer] onDestroy()");
    }

    @Override
    public void onListenerConnected() {
        super.onListenerConnected();

        Log.e(TAG, "[snowdeer] onListenerConnected()");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        Log.e(TAG, "[snowdeer] onNotificationPosted()");

        Notification notification = sbn.getNotification();
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString(Notification.EXTRA_TITLE);
        CharSequence text = extras.getCharSequence(Notification.EXTRA_TEXT);
        CharSequence subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);
        Icon smallIcon = notification.getSmallIcon();
        Icon largeIcon = notification.getLargeIcon();

        Log.e(TAG, "Posted ~ " +
                " id: " + sbn.getId() +
                " text : " + text +
                " subText: " + subText);

        //파이썬 서버에 sentence를 보내고 명사를 받아옵니다.
        // 도균님 승재님 작업중..


        //각 명사들의 value 값들을 디비에서 찾아옵니다.
        //noun_list = 명사 <- 서버에서 받아온 명사 리스트를 쟤한테 넣어주세요

        //NounTable을 생성하고 객체를 가져옵니다.
//        DBHelper DBHelperelperHelper = new NounDBHelper(this);
//        SQLiteDatabase db = DBHelper.getReadableDatabase();
//
//        int sentence_value = 0;
//        for(int i=0; i<noun_list.size; i++) {
//            //해당 명사의 value값을 가져옵니다.
//            String sql = "select value from NounTable where sentence = '" + noun_list[i] + "'" ;
//            // 쿼리실행
//            Cursor c = db.rawQuery(sql, null);
//            int value = c.getInt(1);
//
//            //각 명사의 value 값을 누적합니다.
//            sentence_value += value;
//        }
//
//        //도착한 노티와 예상 value 값을  디비에 저장합니다.
//        String sql = "insert into NotiTable (sentence, value) values ('" + sentence + "', " + sentence_value + ")";
//        db.execSQL(sql);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);
        Log.e(TAG, "[snowdeer] onNotificationRemoved()");

        Log.e(TAG, "onNotificationRemoved ~ " +
                " packageName: " + sbn.getPackageName() +
                " id: " + sbn.getId());
    }

}
