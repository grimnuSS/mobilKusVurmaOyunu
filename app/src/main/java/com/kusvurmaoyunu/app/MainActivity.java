package com.kusvurmaoyunu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean sessiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        findViewById(R.id.basla).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OyunActivity.class));
            }
        });

        TextView enYuksekSkor = findViewById(R.id.enYuksekSkor);
        SharedPreferences prefs = getSharedPreferences("oyun", MODE_PRIVATE);
        enYuksekSkor.setText("En Yüksek Skor " + prefs.getInt("yuksekskor", 0));

        sessiz = prefs.getBoolean("sessiz", false);

        ImageView seskontrol = findViewById(R.id.sesKontrol);
        if (sessiz)
            seskontrol.setImageResource(R.drawable.ses_yok);
        else
            seskontrol.setImageResource(R.drawable.ses);

        seskontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessiz = !sessiz;

                if (sessiz)
                    seskontrol.setImageResource(R.drawable.ses_yok);
                else
                    seskontrol.setImageResource(R.drawable.ses);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("sessiz", sessiz);
                editor.apply();
            }
        });
    }
}