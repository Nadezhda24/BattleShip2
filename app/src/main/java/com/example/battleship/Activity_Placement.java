package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Placement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);
    }



    public void OnClick(View view) {

        switch (view.getId()) {
            case R.id. Back: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.imageView: {
                //настройки звука
            }
            break;
            case R.id.Auto: {
                //Растановка кораблей случайно
            }
            break;
            case R.id.Next: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Game.class);
                startActivity(intent);
            }
            break;
        }

    }
}
