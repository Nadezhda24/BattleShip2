package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Help.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.imageView: {
                //Настройка музыки
            }
            break;
            case R.id.Left: {
                //Прокрутка влево
            }
            break;
            case R.id.Right: {
                //Прокрутка вправо
            }
            break;
        }
    }
}
