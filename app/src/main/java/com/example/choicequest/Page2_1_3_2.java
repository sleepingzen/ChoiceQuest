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

public class Page2_1_3_2 extends AppCompatActivity {

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
}