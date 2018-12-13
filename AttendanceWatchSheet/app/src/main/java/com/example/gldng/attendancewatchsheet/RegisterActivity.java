package com.example.gldng.attendancewatchsheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etMail;
    private EditText etName;
    private EditText etSurname;
    private EditText etPassword;
    private EditText etSecretQ;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName=findViewById(R.id.etName);
        etMail=findViewById(R.id.etMail);
        etSurname=findViewById(R.id.etSurname);
        etPassword=findViewById(R.id.etPassword);
        etSecretQ=findViewById(R.id.etSecretQ);

        btRegister=findViewById(R.id.btRegister);
        btRegister.setEnabled(false);

        etName.addTextChangedListener(registerTextWatcher);
        etSurname.addTextChangedListener(registerTextWatcher);
        etMail.addTextChangedListener(registerTextWatcher);
        etPassword.addTextChangedListener(registerTextWatcher);
        etSecretQ.addTextChangedListener(registerTextWatcher);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"Your registration request has been sent.",Toast.LENGTH_LONG).show();
            }
        });

    }

    private TextWatcher registerTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nameinput=etName.getText().toString().trim();
            String mailinput=etMail.getText().toString().trim();
            String surnameinput=etSurname.getText().toString().trim();
            String passwordinput=etPassword.getText().toString().trim();
            String secretqinput=etSecretQ.getText().toString().trim();

            btRegister.setEnabled(!mailinput.isEmpty() && !passwordinput.isEmpty() && !nameinput.isEmpty() && !surnameinput.isEmpty() && !secretqinput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

