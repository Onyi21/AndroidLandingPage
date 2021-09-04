package com.example.landingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // This will be the Login page ig
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword =  findViewById(R.id.etPassword);

        //set up a click listener for the Create Account button on the welcome(home) page.
        View loginButton = findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        String inputName = etUsername.getText().toString();
        String inputPasswrod = etPassword.getText().toString();
//        if ((inputName.matches("Bret") && inputPasswrod.matches("1234"))  || (inputName.matches("Antonette")  && inputPasswrod.matches("1231"))
//                || (inputName.matches("Samantha") && inputPasswrod.matches("1232")) || inputName.matches("Karianne")&& inputPasswrod.matches("1233")
//                || (inputName.matches("Kamren") && inputPasswrod.matches("1235")) || (inputName.matches("Leopoldo_Corkery") && inputPasswrod.matches( "1236"))
//                || (inputName.matches("Elwyn.Skiles") && inputPasswrod.matches("1237")) || (inputName.matches("Maxime_Nienow") && inputPasswrod.matches("12348"))
//                || (inputName.matches("Delphine") && inputPasswrod.matches("1239"))
                if(inputName.matches("Moriah.Stanton") && inputPasswrod.matches("12341") ) {
            Intent i = new Intent(this, Landing.class);
            startActivity(i);

        } else {
            Toast.makeText(MainActivity.this, "Error, please correct your info", Toast.LENGTH_LONG).show();
            }
        }

//        if(view.getId() == R.id.btnLogin) {
//            Intent i = new Intent(this, Landing.class);
//            startActivity(i);
//            }


    }

}