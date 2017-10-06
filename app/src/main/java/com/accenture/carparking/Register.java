package com.accenture.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText etName,etApellido,etEdad,etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Signup");
        etName=(EditText)findViewById(R.id.etName);
        etApellido=(EditText)findViewById(R.id.etApellido);
        etEdad=(EditText)findViewById(R.id.etEdad);
        etUsername=(EditText)findViewById(R.id.etUsernameR);
        etPassword=(EditText)findViewById(R.id.etPasswordR);
    }
    public void OnRegister(View view){
        String str_name=etName.getText().toString();
        String str_surname=etApellido.getText().toString();
        String str_age=etEdad.getText().toString();
        String str_username=etUsername.getText().toString();
        String str_password=etPassword.getText().toString();
        String type="register";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,str_name,str_surname,str_age,str_username,str_password);
        startActivity(new Intent(this,MainActivity.class));
    }
}
