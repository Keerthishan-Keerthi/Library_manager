package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_copy extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

    public void copy_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewCopies:
                startActivity(new Intent(activity_copy.this, view_copy.class));
                break;
            case R.id.ibtn_addCopies:
                startActivity(new Intent(activity_copy.this, create_copy.class));
                break;
        }
    }
}