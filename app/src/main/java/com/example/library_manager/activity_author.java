package com.example.library_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_author extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

    public void author_btn(View view){
        switch (view.getId()){
            case R.id.ibtn_viewAuthors:
                startActivity(new Intent(activity_author.this, view_author.class));
                break;
            case R.id.ibtn_addAuhors:
                startActivity(new Intent(activity_author.this, create_author.class));
                break;
        }
    }
}