package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Menu extends AppCompatActivity {
    Player[] Player = new Player[2];
    MediaPlayer mediaPlayer ;
    int k ; // для регулирования музыки  1- вкл, 0- выкл
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mediaPlayer  = MediaPlayer.create(Activity_Menu.this, R.raw.beethoven_secrets_the_piano_guys);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        k =1 ;


        Player[0] = new Player();
       Bundle arguments = getIntent().getExtras();
        Player[0].Setid(arguments.getInt("id"));
        Player[0].Setname(arguments.getString("name"));
        Player[0].Setlogin(arguments.getString("login"));
        Player[0].Setpassword(arguments.getString("password"));
        Player[0].Setzvanie(arguments.getString("zvanie"));
        Player[0].Setmoney(arguments.getInt("money"));
        Player[0].Setcount_game(arguments.getInt("count_game"));
        Player[0].Setexperiment(arguments.getInt("experiment"));

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
                case R.id.New_game: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Regime.class);
                    intent.putExtra("id", Player[0].Getid());
                    intent.putExtra("name", Player[0].Getname());
                    intent.putExtra("login", Player[0].Getlogin());
                    intent.putExtra("password", Player[0].Getpassword());
                    intent.putExtra("money", Player[0].Getmoney());
                    intent.putExtra("experiment", Player[0].Getexperiment());
                    intent.putExtra("count_game", Player[0].Getcount_game());
                    intent.putExtra("zvanie", Player[0].Getzvanie());
                    startActivity(intent);
                }
                break;
                case R.id.Account: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Account.class);
                    intent.putExtra("id", Player[0].Getid());
                    intent.putExtra("name", Player[0].Getname());
                    intent.putExtra("login", Player[0].Getlogin());
                    intent.putExtra("password", Player[0].Getpassword());
                    intent.putExtra("money", Player[0].Getmoney());
                    intent.putExtra("experiment", Player[0].Getexperiment());
                    intent.putExtra("count_game", Player[0].Getcount_game());
                    intent.putExtra("zvanie", Player[0].Getzvanie());
                    startActivity(intent);
                }
                break;
                case R.id.Shop: {
                    Intent intent = new Intent(Activity_Menu.this, Activity_Shop.class);
                    intent.putExtra("id", Player[0].Getid());
                    intent.putExtra("name", Player[0].Getname());
                    intent.putExtra("login", Player[0].Getlogin());
                    intent.putExtra("password", Player[0].Getpassword());
                    intent.putExtra("money", Player[0].Getmoney());
                    intent.putExtra("experiment", Player[0].Getexperiment());
                    intent.putExtra("count_game", Player[0].Getcount_game());
                    intent.putExtra("zvanie", Player[0].Getzvanie());
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
            case  R.id.Music:{
 if (k==1){
     // выкл музыки
     k=0;

     mediaPlayer.start();

 }else {
     // вкл музыки
     k=1;

     mediaPlayer.pause();
 }



            }
            break;
        }
    }
}
