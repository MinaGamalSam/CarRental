package carRent.com;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class splash extends AppCompatActivity {


    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splash.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView mainTitle = (TextView) findViewById(R.id.textBloodBank);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "monoton-regular.ttf");
        mainTitle.setTypeface(custom_font);

        handler.postDelayed(runnable, 2000);
    }
}
