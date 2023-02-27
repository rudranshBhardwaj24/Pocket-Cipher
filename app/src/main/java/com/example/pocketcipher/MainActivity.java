package com.example.pocketcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout encryptLL, decryptLL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encryptLL = findViewById(R.id.idLLEncrypt);
        decryptLL = findViewById(R.id.idLLDecrypt);
        encryptLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EncryptActivity.class);
                startActivity(i);
            }
        });

        decryptLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DecryptActivity.class);
                startActivity(i);
            }
        });
    }
}