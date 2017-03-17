package zdm.com.handsignature;

import android.os.Environment;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "---MainActivity";
    private SignatureView signatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signatureView = (SignatureView) findViewById(R.id.signatureView);
        findViewById(R.id.reWrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clear();//清除
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取SDcard路径
                String externalPath = Environment.getExternalStorageDirectory().getAbsolutePath();
                long timeMillis = System.currentTimeMillis();
                String path = externalPath + "/signature" + timeMillis + ".png";
                try {
                    signatureView.save(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
