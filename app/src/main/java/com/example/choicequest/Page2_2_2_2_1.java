package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2_2_2_2_1 extends AppCompatActivity {

    private TextView myTextView;
    private String fullText;

    private int index = 0;
    private long delay = 40;

    private Handler h = new Handler();
    private boolean isTyping = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2_2_2_2_1);
        View root = findViewById(R.id.page2_2_2_2_1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page2_2_2_2_1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myTextView = findViewById(R.id.tv_page2_2_2_2_1);

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

        Toast.makeText(this, "Wandering Song Ending", Toast.LENGTH_LONG).show();
    }

    public void title(View view){
        Intent i = new Intent(Page2_2_2_2_1.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}