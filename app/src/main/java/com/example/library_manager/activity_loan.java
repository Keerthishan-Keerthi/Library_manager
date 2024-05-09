package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_loan extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

    public void loan_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewLendings:
                startActivity(new Intent(activity_loan.this, view_loan.class));
                break;
            case R.id.ibtn_addLendings:
                startActivity(new Intent(activity_loan.this, create_loan.class));
                break;
        }
    }
}