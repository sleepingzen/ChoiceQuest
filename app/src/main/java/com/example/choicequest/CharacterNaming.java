package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CharacterNaming extends AppCompatActivity {

    EditText et_characternaming;

    String str_characternaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_characternaming);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.characternaming), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et_characternaming = findViewById(R.id.et_characternaming);
    }
    public void storybackground(View view) {

        str_characternaming = et_characternaming.getText().toString();

        if (str_characternaming.isEmpty()) {
            Toast.makeText(this, "Please name your character.", Toast.LENGTH_SHORT).show();
            return;
        }

        CharacterNameSaver.characterName = str_characternaming;

        Intent i = new Intent(CharacterNaming.this, StoryBackground.class);
        i.putExtra("str_characternaming",str_characternaming);
        startActivity(i);
        finish();
    }
}

