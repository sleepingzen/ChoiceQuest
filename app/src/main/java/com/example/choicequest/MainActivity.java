package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import android.animation.Animator;
import android.animation.ObjectAnimator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page1);

        ImageView imageView = findViewById(R.id.imageView);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageView.startAnimation(fadeIn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void page2_1(View view) {
        Intent i = new Intent(MainActivity.this, Page2_1.class);
        startActivity(i);
        finish();
    }

    public void page2_2(View view) {
        View dimOverlay = findViewById(R.id.dimOverlay);
        dimOverlay.setVisibility(View.VISIBLE);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(dimOverlay, "alpha", 0f, 1f);
        fadeIn.setDuration(3000);

        fadeIn.addListener(new Animator.AnimatorListener() {
            public void onAnimationEnd(Animator animation) {
                dimOverlay.setVisibility(View.GONE);
                Intent i = new Intent(MainActivity.this, Page2_2.class);
                startActivity(i);
                finish();
            }
            public void onAnimationStart(Animator animation) {}
            public void onAnimationCancel(Animator animation) {}
            public void onAnimationRepeat(Animator animation) {}
        });

        fadeIn.start();
    }

    public void mainActivity(View view) {
        Intent i = new Intent(MainActivity.this, CharacterNaming.class);
        startActivity(i);
    }
}