package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_branch extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }
    public void branch_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewBranch:
                startActivity(new Intent(activity_branch.this, view_branch.class));
                break;
            case R.id.ibtn_addBranch:
                startActivity(new Intent(activity_branch.this, create_branch.class));
                break;
        }
    }

}
