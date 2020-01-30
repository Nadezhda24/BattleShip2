package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void onClick(View view) {
        switch (view.getId()) {
                case R.id.New_game: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Regime.class);
                    startActivity(intent);
                }
                break;
                case R.id.Account: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Account.class);
                    startActivity(intent);
                }
                break;
                case R.id.Shop: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Shop.class);
                    startActivity(intent);
                }
                break;
                case R.id.Help: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Help.class);
                    startActivity(intent);
                }
            break;
            case R.id.Exit: {
                Intent intent = new Intent(Activity_Menu.this, Activity_Registration.class);
                startActivity(intent);
            }
            break;
            case R.id.Setting: {
                Intent intent = new Intent(Activity_Menu.this, Activity_Setting.class);
                startActivity(intent);
            }
            break;
        }
    }
}
