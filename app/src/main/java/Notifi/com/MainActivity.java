package Notifi.com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import java.util.Set;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // <특별한 접근 -> 알림 접근 혀용> 확인
        if (!isPermissionGranted()) {
            // 접근 혀용이 되어있지 않다면 1. 메시지 발생 / 2, 설정으로 이동시킴
            Toast.makeText(getApplicationContext(), getString(R.string.app_name)+" 앱의 알림 권한을 허용해주세요.", Toast.LENGTH_LONG).show();
            startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        }

        // 서비스 시작
        // NotificationListenerService의 경우, Rebind() 메소드 실행 전까지 서비스가 종료되지 않는 것으로 확인됨.
        Intent service = new Intent(getApplicationContext(), NotificationListener.class);
        startService(service);
    }


    private boolean isPermissionGranted() {
        // 노티수신을 확인하는 권한을 가진 앱 모든 리스트
        Set<String> sets = NotificationManagerCompat.getEnabledListenerPackages(this);
        //  Notify앱의 알림 접근 허용이 되어있는가?
        return sets != null && sets.contains(getPackageName());
    }
}
