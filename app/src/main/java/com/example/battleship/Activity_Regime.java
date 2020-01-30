package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Regime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regime);
    }


    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id. Back: {
                Intent intent = new Intent(Activity_Regime.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.imageView: {
               //настройки звука
            }
            break;
            case R.id.NoClassic :
            case R.id.Classic: {
                Intent intent = new Intent(Activity_Regime.this, Activity_Game.class);
                startActivity(intent);
            }
            break;
        }

    }
}

