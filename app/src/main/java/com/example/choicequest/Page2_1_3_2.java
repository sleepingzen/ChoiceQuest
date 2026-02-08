package com.example.choicequest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Page2_1_3_2 extends AppCompatActivity {

    private TextView myTextView;
    private String fullText;
    private GifImageView thunderGif1, thunderGif2, thunderGif3;
    private MediaPlayer thunderSound;

    private int index = 0;
    private long delay = 40;

    private Handler h = new Handler();
    private boolean isTyping = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2_1_3_2);
        View root = findViewById(R.id.page2_1_3_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page2_1_3_2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myTextView = findViewById(R.id.tv_page2_1_3_2);

        fullText = myTextView.getText().toString();
        myTextView.setText("");

        typeText();

        root.setOnClickListener(v -> {
            if (isTyping) {
                isTyping = false;
                h.removeCallbacksAndMessages(null);
                myTextView.setText(fullText);
            }
        });

        thunderGif1 = findViewById(R.id.thunderGif0);
        thunderGif2 = findViewById(R.id.thunderGif1);
        thunderGif3 = findViewById(R.id.thunderGif2);

        thunderGif1.setAlpha(0f);
        thunderGif2.setAlpha(0f);
        thunderGif3.setAlpha(0f);

        startFlickeringThunder(thunderGif1, 1000);
        startFlickeringThunder(thunderGif2, 4000);
        startFlickeringThunder(thunderGif3, 8000);

        // Play thunder sound once
        thunderSound = MediaPlayer.create(this, R.raw.rainthunder_sfx);
        thunderSound.start();
    }

    private void typeText() {
        index = 0;
        isTyping = true;

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < fullText.length() && isTyping) {
                    myTextView.setText(fullText.substring(0, index + 1));
                    index++;
                    h.postDelayed(this, delay);
                }
            }
        }, delay);
    }

    private void startFlickeringThunder(GifImageView gifView, long initialDelay) {
        Handler handler = new Handler(Looper.getMainLooper());

        Runnable flickerRunnable = new Runnable() {
            @Override
            public void run() {
                GifDrawable drawable = (GifDrawable) gifView.getDrawable();
                drawable.reset();
                drawable.start();

                gifView.animate()
                        .alpha(1f)
                        .setDuration(200)
                        .withEndAction(() -> {
                            handler.postDelayed(() -> {
                                gifView.animate()
                                        .alpha(0f)
                                        .setDuration(300)
                                        .withEndAction(() -> {
                                            drawable.stop();
                                            handler.postDelayed(this, 3000);
                                        })
                                        .start();
                            }, 800);
                        })
                        .start();
            }
        };

        handler.postDelayed(flickerRunnable, initialDelay);
    }

    public void page2_1_3_2_1(View view){
        Intent i = new Intent(Page2_1_3_2.this, Page2_1_3_2_1.class);
        startActivity(i);
        finish();
    }

    public void page2_1_3_2_2(View view){
        Intent i = new Intent(Page2_1_3_2.this, Page2_1_3_2_2.class);
        startActivity(i);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (thunderSound != null) {
            thunderSound.release();
            thunderSound = null;
        }
    }
}