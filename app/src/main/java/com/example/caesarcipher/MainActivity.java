package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    Button encryptButton;
    EditText userStringInput;
    EditText editTextOutput;
    EditText editTextKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        encryptButtonOnClick();
    }

    void findView() {
        encryptButton = findViewById(R.id.button);
        userStringInput = findViewById(R.id.editText);
        editTextOutput = findViewById(R.id.editTextOutput);
        editTextKey = findViewById(R.id.edittextKey);
    }

     void encryptButtonOnClick() {
        encryptButton.setOnClickListener(v -> output());
    }

    void output() {
        String userString = userStringInput.getText().toString();
        String keyValue = editTextKey.getText().toString();// we got the user value in this variable 'userString'.
        int key = Integer.parseInt(keyValue);
        String outputEncryptedMessage = encrypt(userString, key);
        editTextOutput.setText(outputEncryptedMessage);


    }

    public static String encrypt(String plainText, int shiftKey)
    {
        plainText = plainText.toLowerCase();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
            int keyVal = (shiftKey + charPosition) % 26;
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText.append(replaceVal);
        }
        return cipherText.toString();
    }


    //For decryption

//    public static String decrypt(String cipherText, int shiftKey)
//    {
//        cipherText = cipherText.toLowerCase();
//        String plainText = "";
//        for (int i = 0; i < cipherText.length(); i++)
//        {
//            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
//            int keyVal = (charPosition - shiftKey) % 26;
//            if (keyVal < 0)
//            {
//                keyVal = ALPHABET.length() + keyVal;
//            }
//            char replaceVal = ALPHABET.charAt(keyVal);
//            plainText += replaceVal;
//        }
//        return plainText;
//    }
}