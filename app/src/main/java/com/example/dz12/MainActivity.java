package com.example.dz12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private Button buttonConfig;
    private TextView txt1,txt2,txt3,txt4;


    String correct_username = "admin@gmail.com";

    String correct_password = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextEmail = findViewById(R.id.editTextTextEmail);
        editTextPassword = findViewById(R.id.EdittextPaswword);
        buttonConfig = findViewById(R.id.button);
        txt1 =findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textview3);
        txt4 = findViewById(R.id.textview4);

        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextEmail.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Empty data provided", Toast.LENGTH_LONG).show();


                } else if (editTextEmail.getText().toString().equals(correct_username)) {
                    if (editTextPassword.getText().toString().equals(correct_password)) {
                        Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались  ", Toast.LENGTH_LONG).show();
                        editTextPassword.setVisibility(View.GONE);
                        editTextEmail.setVisibility(View.GONE);
                        buttonConfig.setVisibility(View.GONE);
                        txt1.setVisibility(View.GONE);
                        txt2.setVisibility(View.GONE);
                        txt3.setVisibility(View.GONE);
                        txt4.setVisibility(View.GONE);

                    } else
                        Toast.makeText(MainActivity.this, "Не правильный пароль ", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Не правильный логин", Toast.LENGTH_LONG).show();

                }


            }
        });


        editTextEmail.addTextChangedListener(loginTextWatcher);
        editTextPassword.addTextChangedListener(loginTextWatcher);

    }


    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String usernameInput = editTextEmail.getText().toString().trim();
            String passwordInput = editTextPassword.getText().toString().trim();


            buttonConfig.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }


    };

}