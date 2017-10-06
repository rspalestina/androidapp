package com.accenture.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword=(EditText) findViewById(R.id.etPassword);

    }
    public void OnLigin(View view){
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        String type="login";
        BackgroundWorker backgroundWorker=new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
        etUsername.setText("");
        etPassword.setText("");
        startActivity(new Intent(this,MainActivity.class));
    }
    public void OpenReg(View view){
        startActivity(new Intent(this,Register.class));
    }
}
