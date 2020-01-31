package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Account.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.SettinAccount: {
                Intent intent = new Intent(Activity_Account.this, Activity_Setting_Account.class);
                startActivity(intent);
            }
            break;
            case R.id.Rating: {
                //диалоговое окно с рейтингом
            }
            break;
            case R.id.Shop: {
                Intent intent = new Intent(Activity_Account.this, Activity_Shop.class);
                startActivity(intent);
            }
            break;
        }
    }
}
