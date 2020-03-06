package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

public class Activity_Game extends AppCompatActivity {
    Field [][] field = new Field[10][10];

    Ship [] ship = new Ship[10];
    Serializable map ;
    Player[] Player = new Player[2];
    int flag;//переключатель между игроками во время игры
    int regime_game ; // 1- расширенный 0- классический
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        flag = 0;
        Player[0] = new Player();
        Bundle arguments = getIntent().getExtras();
        Player[0] =  (Player) arguments.getSerializable("player");


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                field[i][j] = new Field((ImageView) findViewById(res),res);

               field[i][j].GetImageView().setImageResource(R.drawable.my_map);


            }
        }




        TextView NamePlayer = findViewById(R.id.Use_name);
        NamePlayer.setText(Player[0].Getname());

        TextView ZvaniePlayer = findViewById(R.id.Zvanie);
        ZvaniePlayer.setText(Player[0].Getzvanie());

        TextView ExperiencePlayer = findViewById(R.id.Count);
        ExperiencePlayer.setText(String.valueOf(Player[0].Getexperiment()));



    if (  Player[0].Getregim_game() == 1 ) {
//сундучки
        final Dialog dialog = new Dialog(Activity_Game.this);
        dialog.setContentView(R.layout.choice);
        Button button = dialog.findViewById(R.id.Ok);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                //пират

                final Dialog dialog1 = new Dialog(Activity_Game.this);
                dialog1.setContentView(R.layout.pirate);
                Button button1 = dialog1.findViewById(R.id.yes);
                Button button2 = dialog1.findViewById(R.id.no);

                TextView text = dialog1.findViewById(R.id.piratetext);
                //   text.setText("Расставь бамбы и напакости противнику!\n хе хе хе ");


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //  map.PirateBomb(0+(int)(Math.random() * 3));
                        dialog1.dismiss();
                    }
                });


                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });


                dialog1.setCancelable(false);
                dialog1.show();


            }
        });

        dialog.setCancelable(false);
        dialog.show();


        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LF);


        ImageView ImageView0 = new ImageView(this);
        ImageView0.setImageResource(R.drawable.coins);
        LinerLayout.addView(ImageView0);

        ImageView ImageView2 = new ImageView(this);
        ImageView2.setImageResource(R.drawable.coins);
        LinerLayout.addView(ImageView2);

        ImageView ImageView3 = new ImageView(this);
        ImageView3.setImageResource(R.drawable.coins);
        LinerLayout.addView(ImageView3);

        LinearLayout LinerLayout1 = (LinearLayout) findViewById(R.id.LF2);

        ImageView ImageView4 = new ImageView(this);
        ImageView4.setImageResource(R.drawable.coins);
        LinerLayout1.addView(ImageView4);

        ImageView ImageView5 = new ImageView(this);
        ImageView5.setImageResource(R.drawable.coins);
        LinerLayout1.addView(ImageView5);


    }




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




    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Game.this, Activity_Menu.class);

                intent.putExtra("id", Player[0].Getid());
                intent.putExtra("name", Player[0].Getname());
                intent.putExtra("login", Player[0].Getlogin());
                intent.putExtra("password", Player[0].Getpassword());
                intent.putExtra("money", Player[0].Getmoney());
                intent.putExtra("experiment", Player[0].Getexperiment());
                intent.putExtra("count_game", Player[0].Getcount_game());
                intent.putExtra("zvanie", Player[0].Getzvanie());
                startActivity(intent);
                overridePendingTransition(R.anim.anim, R.anim.anim1);
            }
            break;

            case R.id.Ukaz:{
                ImageView ImageView = (ImageView) findViewById(R.id.Ukaz);
                        if (flag == 1){

                ImageView.setImageResource(R.drawable.left_1);
                        flag = 0;}
                        else {

                            ImageView.setImageResource(R.drawable.right_1);
                            flag = 1;
                        }


            }
            break;
            case R.id.Auto: {
                final Dialog dialog = new Dialog(Activity_Game.this);
                dialog.setContentView(R.layout.chat);
                Button button =  dialog.findViewById(R.id.Ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });



                dialog.setCancelable(false);
                dialog.show();
            }
            break;
        }

    }
}
