package com.aaronencinasgordillo.mrfox;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyLogin extends AppCompatActivity {
    Button Login;
    TextView txtuser, txtpassword;
    EditText edit1, edit2;
    Typeface tipography;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        Login = (Button)findViewById(R.id.Login);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        txtuser = (TextView)findViewById(R.id.txtUser);
        txtpassword = (TextView)findViewById(R.id.txtPassword);
        tipography = Typeface.createFromAsset(getAssets(),"fonts/AmaticSC-Regular.ttf");
        txtuser.setTypeface(tipography);
        txtpassword.setTypeface(tipography);
        Login.setTypeface(tipography);
        edit1.setTypeface(tipography);
        edit2.setTypeface(tipography);
    }
    public void login(View view){
        Intent intent = new Intent(MyLogin.this, MyMain.class);
        startActivity(intent);
    }
}
