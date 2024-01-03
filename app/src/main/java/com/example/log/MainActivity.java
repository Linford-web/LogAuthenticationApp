package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    TextView details;
    Button logoutBtn;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        details = findViewById(R.id.details);
        logoutBtn = findViewById(R.id.logoutBtn);
        user = auth.getCurrentUser();
        // check if user is null or not
        if (user == null){
            Intent intent = new Intent(MainActivity.this, loginActivity.class);
            startActivity(intent);
            finish();
        }else{
            //
            details.setText(user.getEmail());
        }
        // deal with logout
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}