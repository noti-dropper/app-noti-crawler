package Notifi.com;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (!isPermissionGranted()) {
            // 5.0 부터 인텐트 명시적 선언이 안되게 됨.
            // https://bongjacy.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%9D%B8%ED%85%90%ED%8A%B8-%EC%83%9D%EC%84%B1%ED%95%A0-%EB%95%8C-%EB%B0%9C%EC%83%9D-%EC%98%A4%EB%A5%98-Service-Intent-must-be-explicit

            Log.e("=====", "Open Setting");
//            // 시스템 설정 여는 코드
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            intent.setPackage("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
//            startService(intent);

            // 서비스 시작 코드
            // https://bitsoul.tistory.com/147
            Intent service = new Intent(getApplicationContext(), NotificationListener.class);
            startService(service);



        }

    }

    private boolean isPermissionGranted() {
        // 앱 별 알림 퍼미션 확인
        Set<String> sets = NotificationManagerCompat.getEnabledListenerPackages(this);

        for(String packageName : sets){
            if(packageName == null)
                continue;
            if(packageName.equals(getPackageName())) {
                Log.e("=====", ""+true);
                return true;
            }
        }
        Log.e("=====", ""+false);
        return false;
    }


}
