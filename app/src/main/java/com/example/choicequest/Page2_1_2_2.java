package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2_1_2_2 extends AppCompatActivity {

    TextView tv_page2_1_2_2;

    String str_characternaming = CharacterNameSaver.characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2_1_2_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page2_1_2_2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_page2_1_2_2 = findViewById(R.id.tv_page2_1_2_2);

        if (str_characternaming == null || str_characternaming.isEmpty()) {
            str_characternaming = "???";
        }

        tv_page2_1_2_2.setText("You see Sam, a former classmate." +
                "\n\nThey look surprised to see you. “Hey, "+str_characternaming+". You’ve been skipping a lot lately, huh?”" +
                "\n\nThey invite you to help them study for an upcoming exam that could decide both of your futures.");
    }

    public void page2_1_2_2_1(View view){
        Intent i = new Intent(Page2_1_2_2.this, Page2_1_2_2_1.class);
        startActivity(i);
        finish();
    }

    public void page2_1_2_2_2(View view){
        Intent i = new Intent(Page2_1_2_2.this, Page2_1_2_2_2.class);
        startActivity(i);
        finish();
    }
}