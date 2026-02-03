package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoryBackground extends AppCompatActivity {

    private TextView myTextView;
    private String fullText = "This text is being typed.";
    private int index = 0;
    private long delay = 100;
    private Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_storybackground);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.storybackground),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );

        myTextView = findViewById(R.id.tv_storybackground);
        myTextView.setText("");
        typeText();
    }

    private void typeText() {
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index <= fullText.length()) {
                    myTextView.setText(fullText.substring(0, index++));
                    h.postDelayed(this, delay);
                }
            }
        }, delay);
    }
    public void storybackground(View view) {
        Intent i = new Intent(StoryBackground.this, Page1.class);
        startActivity(i);
    }
}
