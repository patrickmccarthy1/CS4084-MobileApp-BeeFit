package com.example.beefit;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterLoginDatabase DB;

        TextView username = (TextView) findViewById(R.id.username1);
        TextView password = (TextView) findViewById(R.id.password1);
        TextView repassword = (TextView) findViewById(R.id.repassword);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn1);
        DB = new RegisterLoginDatabase(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else {
                    if(pass.equals(repass)){
                        Boolean checkUser = DB.checkUsername(user);
                        if(checkUser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert == true ){
                                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "User already exists, sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords do not match, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}