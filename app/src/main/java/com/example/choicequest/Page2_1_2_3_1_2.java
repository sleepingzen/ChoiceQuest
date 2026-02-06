package com.example.choicequest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2_1_2_3_1_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2_1_2_3_1_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.page2_1_2_3_1_2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this, "Extinguished Light Ending", Toast.LENGTH_LONG).show();
    }

    public void title(View view){
        Intent i = new Intent(Page2_1_2_3_1_2.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}