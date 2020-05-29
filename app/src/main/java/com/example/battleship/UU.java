package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UU extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }


        ImageView image = findViewById(R.id.imageView4);
        image.setBackgroundResource(R.drawable.animation);
        AnimationDrawable animation = (AnimationDrawable)image.getBackground();
            animation.start();


    }

    public void Click(View view) {
        Intent intent = new Intent(this, Activity_Registration.class);
        startActivity(intent);
    }
}
