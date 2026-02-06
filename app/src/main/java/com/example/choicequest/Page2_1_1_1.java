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

public class Page2_1_1_1 extends AppCompatActivity {

    TextView tv_page2_1_1_1;
    String str_characternaming = CharacterNameSaver.characterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2_1_1_1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page2_1_1_1),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
        });

        tv_page2_1_1_1 = findViewById(R.id.tv_page2_1_1_1);

        if (str_characternaming == null || str_characternaming.isEmpty()) {
            str_characternaming = "???";
        }

        tv_page2_1_1_1.setText(
                        "You step on the boat, and sail with the fisherman.\n\n" +
                        "“What’s your name, kid?” The fisherman asks, to which you reply with " + str_characternaming+
                        ".\n\nThe name’s Ralph, pleasure to meet you on this fine day." +
                        "“\nHere’s your rod, " + str_characternaming +
                        ". If you catch a fish for me, I’ll reward you with coins.” Says Ralph."
        );
    }
    public void page2_1_1_1_1(View view) {
        Intent i = new Intent(Page2_1_1_1.this, Page2_1_1_1_1.class);
        startActivity(i);
        finish();
    }
}
