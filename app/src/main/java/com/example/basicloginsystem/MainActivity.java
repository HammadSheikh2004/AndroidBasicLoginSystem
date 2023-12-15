package com.example.basicloginsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    AppCompatButton submit_btn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        submit_btn = findViewById(R.id.submit_btn);

        String userEmail = "hammad@gmail.com";
        String userpassword = "12345";

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailCheck = email.getText().toString();
                String passCheck = password.getText().toString();

                if (emailCheck.equals("")) {
                    email.setError("Email is Required.");
                } else if (passCheck.equals("")) {
                    password.setError("Password is Required.");
                } else {
                    if (emailCheck.equals(userEmail) && passCheck.equals(userpassword)) {
                        Intent intent = new Intent(MainActivity.this, DashBoard.class);
                        intent.putExtra("email", userEmail);
                        startActivity(intent);
                    } else {
                        count++;
                        Toast.makeText(MainActivity.this, "Your Email and Password are Wrong, Attempts: " + count, Toast.LENGTH_SHORT).show();
                    }

                    if (count == 3) {
                        submit_btn.setEnabled(false);
                        Toast.makeText(MainActivity.this, "Your Account is blocked, Attempts: " + count, Toast.LENGTH_SHORT).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                submit_btn.setEnabled(true);
                                count = 0; // Reset the count
                                Toast.makeText(MainActivity.this, "Your Account is Open. Please Login.", Toast.LENGTH_SHORT).show();
                            }
                        }, 5000);
                    }
                }
            }
        });
    }
}
