package com.example.pocketcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DecryptActivity extends AppCompatActivity {
    private Button decryptBtn;
    private TextInputEditText msgEdt;
    private TextView decryptTV;
    private String key = "XWYTAMPEWNRPRYMC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        decryptBtn = findViewById(R.id.idBtnDecrypt);
        msgEdt = findViewById(R.id.idEditText);
        decryptTV = findViewById(R.id.idTVDecryptedData);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),"AES");
        decryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msgEdt.getText().toString().isEmpty())
                {
                    Toast.makeText(DecryptActivity.this, "Please Enter Encrypted Data", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        decryptTV.setText(decryptMsg(msgEdt.getText().toString(),secretKeySpec));
                    } catch (Exception e) {
                        Toast.makeText(DecryptActivity.this, "Can not decrypt data"+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    private String decryptMsg(String cipherText, SecretKey secretKey) throws Exception
    {
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(cipher.DECRYPT_MODE, secretKey);
        byte [] decode = Base64.decode(cipherText, Base64.NO_WRAP);
        String decryptedData = new String(cipher.doFinal(decode), StandardCharsets.UTF_8);
        return decryptedData;
    }
}