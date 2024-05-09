package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_pub extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pub);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }
    public void pub_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewPubs:
                startActivity(new Intent(activity_pub.this, view_pub.class));
                break;
            case R.id.ibtn_addPub:
                startActivity(new Intent(activity_pub.this, create_pub.class));
                break;
        }
    }
}