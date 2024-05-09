package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_member extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

    public void member_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewMembers:
                startActivity(new Intent(activity_member.this, view_member.class));
                break;
            case R.id.ibtn_addMembers:
                startActivity(new Intent(activity_member.this, create_member.class));
                break;
        }
    }
}