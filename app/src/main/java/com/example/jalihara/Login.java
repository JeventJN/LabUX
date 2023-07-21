package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private static Login instance;
    private String passwordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        instance = this;

        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.password);
        TextView errorUsername = findViewById(R.id.errorusername);
        TextView errorPassword = findViewById(R.id.errorpassword);
        Button loginButton = findViewById(R.id.loginbutton);
        errorUsername.setVisibility(View.INVISIBLE);
        errorPassword.setVisibility(View.INVISIBLE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                boolean isUsernameValid = true;
                boolean isPasswordValid = true;

                if (username.isEmpty()) {
                    errorUsername.setText("Username cannot be empty");
                    errorUsername.setVisibility(View.VISIBLE);
                    isUsernameValid = false;
                } else if (username.length() < 6) {
                    errorUsername.setText("Username length must be more than 5 characters");
                    errorUsername.setVisibility(View.VISIBLE);
                    isUsernameValid = false;
                } else {
                    errorUsername.setVisibility(View.INVISIBLE);
                }

                if (password.isEmpty()) {
                    errorPassword.setText("Password cannot be empty");
                    errorPassword.setVisibility(View.VISIBLE);
                    isPasswordValid = false;
                } else if (password.length() < 8) {
                    errorPassword.setText("Password length must be more than 8 characters");
                    errorPassword.setVisibility(View.VISIBLE);
                    isPasswordValid = false;
                } else {
                    errorPassword.setVisibility(View.INVISIBLE);
                }

                if (isUsernameValid && isPasswordValid) {
                    instance.setPasswordLogin(password);
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("username", username);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    // Setter method for passwordLogin
    public void setPasswordLogin(String passwordLogin) {
        this.passwordLogin = passwordLogin;
    }

    // Getter method for passwordLogin
    public String getPasswordLogin() {
        return passwordLogin;
    }
}