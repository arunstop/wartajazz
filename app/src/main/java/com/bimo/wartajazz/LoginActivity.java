package com.bimo.wartajazz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private Button login;
    private TextView user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
                    Intent login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(login);
                }else{
                    Toast.makeText(LoginActivity.this, "User/Passwowrd Salah",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
