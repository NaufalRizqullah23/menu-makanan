package com.example.menu_makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.Button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
        public void login(){
        TextView Uname = findViewById(R.id.Uname_text);
        TextView Pass = findViewById(R.id.Pass_text);

        String User = Uname.getText().toString();
        String pw = Pass.getText().toString();


        if (User.equals("Admin") && pw.equals("Lapar123")){
            Intent intent = new Intent(getApplicationContext(),Home.class);
            startActivity(intent);
            this.finish();
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Username atau Password salah!",Toast.LENGTH_SHORT);
            toast.show();
        }
        }
}