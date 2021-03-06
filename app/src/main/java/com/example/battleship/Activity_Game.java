package com.example.battleship;
import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;

import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


import android.widget.Toast;


import static com.example.battleship.status.checked;
import static com.example.battleship.status.empty;
import static com.example.battleship.status.near_ship;


public class Activity_Game extends AppCompatActivity {


    Field [][] fieldPlayer = new Field[10][10];
    Field [][] fieldOpponent = new Field[10][10];
    ImageView [][] ImPlayer = new ImageView[10][10];
    ImageView [][] ImOpponent = new ImageView[10][10];
    ImageStatus [][] ImStOpponent =  new ImageStatus[10][10];
  //  ImageStatus [][] ImStPlayer =  new ImageStatus[10][10];
    Ship [] ship = new Ship[10];
    Map mapPlayer, mapOpponent ;
    Player[] Player = new Player[2];
    int flag;//переключатель между игроками во время игры

    boolean flag_bomb;
    boolean flag_trubka;
    boolean flag_anchor;
    boolean flag_abortazh;
    boolean flag_tool;


    ImageView image;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }



        flag = 0;
        flag_bomb = false;
        flag_trubka= false;
        flag_anchor= false;
        flag_abortazh= false;
        flag_tool= false;
        Player[0] = new Player();



        Player[1] = new Player();
        Bundle arguments = getIntent().getExtras();
        Player[0] =  (Player) arguments.getSerializable("player");

        Thread  thread = new Thread(new Runnable() { @Override public void run() {  try {

            Client_obj client_obj = new Client_obj();
            client_obj.run("[p]".getBytes());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(Player[0]);

            client_obj.run(bos.toByteArray());
            client_obj.run("[p]".getBytes());
            // Пробуем приконнетиться...
        } catch (IOException e) {
            // если объект не создан...
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Unable to connect. Server not running?", Toast.LENGTH_LONG);
            toast.show();

        } } }); thread.start();

     /*   thread = new Thread(new Runnable() { @Override public void run() {  try {

            Client_obj client_obj = new Client_obj();

            ByteArrayInputStream bis = new ByteArrayInputStream(client_obj.ansServer.getBytes());

            ObjectInput in = new ObjectInputStream(bis);
            try {
                Player[1] = (Player) in.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            // если объект не создан...
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Unable to connect. Server not running?", Toast.LENGTH_LONG);
            toast.show();

        } } }); thread.start();

*/

        if (  Player[0].Getregim_game() == 1 ) {


        //сундучки
        final Dialog dialog = new Dialog(Activity_Game.this);
        dialog.setContentView(R.layout.choice);
        Button button = dialog.findViewById(R.id.Ok);
        final TextView text = dialog.findViewById(R.id.Choice);
        final ImageView box_one = dialog.findViewById(R.id.box_one);
        final ImageView box_two= dialog.findViewById(R.id.box_two);
        final Button ok = dialog.findViewById(R.id.Ok);
        ok.setClickable(false);
        //Право первого хода
         final int player_choice = 0+(int)(Math.random() * 2);

        box_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setClickable(true);
                if (player_choice == 1){

                box_one.setImageResource(R.drawable.box_open);
                text.setText("Твой ход первый!");

                }
                else { box_one.setImageResource(R.drawable.box_empy);
                    text.setText("Увы, первый ход у твоего противника...");

                }
                box_two.setClickable(false);
            }
        });
        box_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setClickable(true);
                if (player_choice == 1){
                box_two.setImageResource(R.drawable.box_open);
                    text.setText("Твой ход первый!");}
                else { box_two.setImageResource(R.drawable.box_empy);
                    text.setText("Увы, первый ход у твоего противника...");}
                box_one.setClickable(false);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();




                //пират
                final Dialog dialog1 = new Dialog(Activity_Game.this, R.style.NewDialog);
                dialog1.setContentView(R.layout.pirate);
                Button button1 = dialog1.findViewById(R.id.yes);
                Button button2 = dialog1.findViewById(R.id.no);

                TextView text = dialog1.findViewById(R.id.piratetext);


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    // расстановка бомб
                      fieldOpponent = mapOpponent.PirateBomb(0+(int)(Math.random() * 4));
                      DrawMap(fieldPlayer, ImPlayer);
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

        ImageView ImageView6 = new ImageView(this);
        ImageView6.setVisibility(View.INVISIBLE);
            ImageView6.setImageResource(R.drawable.t70);
            LinerLayout.addView(ImageView6);

        final ImageView ImageView0 = new ImageView(this);
        ImageView0.setImageResource(R.drawable.bomb70);

        final Animation myanimfig = AnimationUtils.loadAnimation(this, R.anim.myanimfig);
        ImageView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView0.setImageResource(R.drawable.abortazh70);
                v.startAnimation(myanimfig);
            }
        });
        LinerLayout.addView(ImageView0);


        ImageView ImageView2 = new ImageView(this);
        ImageView2.setImageResource(R.drawable.t70);
        LinerLayout.addView(ImageView2);

        ImageView ImageView3 = new ImageView(this);
        ImageView3.setImageResource(R.drawable.abortazh70);
        LinerLayout.addView(ImageView3);

        LinearLayout LinerLayout1 = (LinearLayout) findViewById(R.id.LF2);

        ImageView ImageView4 = new ImageView(this);
        ImageView4.setImageResource(R.drawable.yak70);
        LinerLayout1.addView(ImageView4);

        ImageView ImageView5 = new ImageView(this);
        ImageView5.setImageResource(R.drawable.molot70);
        LinerLayout1.addView(ImageView5);


        ImageView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // поражение области 3*3

                flag_bomb = true;
            }
        });

        ImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // подгляделка

                flag_trubka = true;
            }
        });
        ImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // подгляделка

                flag_abortazh = true;
            }
        });
        ImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // подгляделка

                flag_anchor = true;
            }
        });
        ImageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // подгляделка

                flag_tool = true;
            }
        });









    }





        fieldPlayer=  Player[0].GetMap().field ;
        fieldOpponent = Player[0].GetMap().field;

        Player[1].Setname("Player2");
       Player[1].Setzvanie("главный старшина");
       Player[1].Setexperiment(480);






        for ( int  i = 0; i < 10; i++) {
            for ( int j = 0; j < 10; j++) {
                final int ii =i ;
                final int jj =  j;
                final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());


                ImPlayer [i][j] = (ImageView) findViewById(res);
                ImOpponent [i][j] = (ImageView) findViewById(res);

                ImStOpponent [i][j] = ImageStatus.down;

                if (fieldPlayer[ii][jj].GetStatusOrientation() == orientation.vertically) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                        ImPlayer[i][j].animate().rotation(90);
                    }
                }
                if (fieldOpponent[ii][jj].GetStatusOrientation() == orientation.vertically) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                        ImOpponent[i][j].animate().rotation(90);
                    }

                }

                ImPlayer[i][j].setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        ChangePlayer (res, ii, jj);
                        NoClick(ImPlayer);

                    }
                });
            }
        }


        DrawMap(fieldPlayer, ImPlayer);

        mapPlayer = new Map(fieldPlayer, ship);
        mapOpponent = new Map(fieldOpponent, ship);

        TextView NamePlayer = findViewById(R.id.Use_name);
        NamePlayer.setText(Player[0].Getname());

        TextView ZvaniePlayer = findViewById(R.id.Zvanie);
        ZvaniePlayer.setText(Player[0].Getzvanie());

        TextView ExperiencePlayer = findViewById(R.id.Count);
        ExperiencePlayer.setText(String.valueOf(Player[0].Getexperiment()));





    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
    }




    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {





                final Dialog dialog  = new Dialog(Activity_Game.this);



                // Передайте ссылку на разметку
                dialog.setContentView(R.layout.exit);
                //нет
                Button button1 = dialog.findViewById(R.id.Ok);
                //да
                Button button2 = dialog.findViewById(R.id.ok2);




                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                    }
                });


                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

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
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
                            //  overridePendingTransition(R.anim.anim, R.anim.anim1);
                        }
                    }
                });

                dialog.setCancelable(false);
                dialog.show();


            }
            break;

            case R.id.Ukaz:{



                ImageView ImageView = (ImageView) findViewById(R.id.Ukaz);

                        if (flag == 1){
                            // поле противника

                            TextView NamePlayer = findViewById(R.id.Use_name);
                            NamePlayer.setText(Player[1].Getname());

                            TextView ZvaniePlayer = findViewById(R.id.Zvanie);
                            ZvaniePlayer.setText(Player[1].Getzvanie());

                            TextView ExperiencePlayer = findViewById(R.id.Count);
                            ExperiencePlayer.setText(String.valueOf(Player[1].Getexperiment()));


                            ImageView.setImageResource(R.drawable.button_left);

                            for(int i =0; i< 10; i++){
                                for (int j =0; j<10;j++){

                                    final int ii = i;
                                    final int jj = j;
                                    // скрытие поля противника

                              if (ImStOpponent[i][j] == ImageStatus.down) ImOpponent[i][j].setImageResource(R.drawable.my_map);

                                    final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());

                                    ImOpponent[i][j].setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {

                                            Thread thread = new Thread(new Runnable() { @Override public void run() {  try {

                                                Client_obj client_obj = new Client_obj();

                                                byte[] byteArray = ( "[g] "+String.valueOf(ii) + " " + String.valueOf(jj)).getBytes();
                                                client_obj.run(byteArray); // Пробуем приконнетиться...
                                            } catch (IOException e) {
                                                // если объект не создан...
                                                Toast toast = Toast.makeText(getApplicationContext(),
                                                        "Unable to connect. Server not running?", Toast.LENGTH_LONG);
                                                toast.show();

                                            } } }); thread.start();

                                            if(fieldOpponent[ii][jj].GetStatus() != status.ship){

                                                fieldOpponent[ii][jj].SetStatus(checked);}

                                            ImStOpponent[ii][jj] =  ImageStatus.up;
                                            // прорисовка выбранной клетки
                                            ChangeOpponent (res, ii, jj, fieldOpponent);

                                            if(flag_bomb) {


                                                image = findViewById(R.id.imageView3);
                                                image.setBackgroundResource(R.drawable.push_bomb);
                                                animation = (AnimationDrawable)image.getBackground();
                                                animation.start();

                                                if (ii != 10 && jj != 10)   {

                                                    ImStOpponent[ii+1][jj+1] =  ImageStatus.up;
                                                    if((fieldOpponent[ii+1][jj+1].GetStatus() != status.ship) &&(fieldOpponent[ii+1][jj+1].GetStatus() != status.kill) ){

                                                        fieldOpponent[ii+1][jj+1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj+1), "id", getPackageName()), ii+1, jj+1, fieldOpponent);
                                                }
                                                if (ii != 10) {

                                                    ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                    if(fieldOpponent[ii+1][jj].GetStatus() != status.ship && fieldOpponent[ii+1][jj].GetStatus() != status.kill){

                                                        fieldOpponent[ii+1][jj].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + jj, "id", getPackageName()), ii+1, jj, fieldOpponent);
                                                }
                                                if (ii != 10 && jj != 0){

                                                    ImStOpponent[ii+1][jj-1] =  ImageStatus.up;
                                                    if(fieldOpponent[ii+1][jj-1].GetStatus() != status.ship && fieldOpponent[ii+1][jj-1].GetStatus() != status.kill){

                                                        fieldOpponent[ii+1][jj-1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj-1), "id", getPackageName()), ii+1, jj-1, fieldOpponent);
                                                    }
                                                if (jj != 10){ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                    if(fieldOpponent[ii][jj+1].GetStatus() != status.ship&& fieldOpponent[ii][jj+1].GetStatus() != status.kill){

                                                        fieldOpponent[ii][jj+1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + ii + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);
                                                    }
                                                if (jj != 0) {ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                    if(fieldOpponent[ii][jj-1].GetStatus() != status.ship&&fieldOpponent[ii][jj-1].GetStatus() != status.kill){

                                                        fieldOpponent[ii][jj-1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + ii + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                    }
                                                if (ii != 0 && jj != 10){ImStOpponent[ii-1][jj+1] =  ImageStatus.up;
                                                    if(fieldOpponent[ii-1][jj+1].GetStatus() != status.ship && fieldOpponent[ii-1][jj+1].GetStatus() != status.kill){

                                                        fieldOpponent[ii-1][jj+1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj+1), "id", getPackageName()), ii-1, jj+1, fieldOpponent);
                                                    }
                                                if (ii != 0){
                                                    ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                    if(fieldOpponent[ii-1][jj].GetStatus() != status.ship&&fieldOpponent[ii-1][jj].GetStatus() != status.kill){

                                                    fieldOpponent[ii-1][jj].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + jj, "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                }
                                                if (ii != 0 && jj != 0) {
                                                    ImStOpponent[ii-1][jj-1] =  ImageStatus.up;
                                                    if( fieldOpponent[ii-1][jj-1].GetStatus() != status.ship && fieldOpponent[ii-1][jj-1].GetStatus() != status.kill){

                                                    fieldOpponent[ii-1][jj-1].SetStatus(checked);}
                                                        ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj-1), "id", getPackageName()), ii-1, jj+1, fieldOpponent);
                                                }

                                                flag_bomb = false;
                                            }



                                            if(flag_trubka){

                                                    ImStOpponent[ii][jj] =  ImageStatus.up;
                                                ChangeOpponent (res, ii, jj, fieldOpponent);


                                                Toast toast = Toast.makeText(getApplicationContext(),
                                                        "У тебя есть 5 секунд!", Toast.LENGTH_LONG);
                                                toast.show();
                                                 toast = Toast.makeText(getApplicationContext(),
                                                        "У тебя есть 5 секунд!", Toast.LENGTH_SHORT);
                                                toast.show();

                                                ImStOpponent[ii][jj] =  ImageStatus.down;

                                                ImOpponent[ii][jj].setImageResource(R.drawable.my_map);

                                                flag_trubka = false;

                                            }

                                            if(flag_abortazh) {


                                                if (fieldOpponent[ii][jj].GetStatus() == status.ship ) {


                                                    switch ( fieldOpponent[ii][jj].GetStatus_Ship()) {


                                                        case ship11:
                                                        ImStOpponent[ii][jj] =  ImageStatus.up;
                                                        ChangeOpponent (res, ii, jj, fieldOpponent);
                                                        break;
                                                    case ship21:
                                                            if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                                ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);

                                                            }else {
                                                                ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                                ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);

                                                            }


                                                        break;
                                                    case ship22:

                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);

                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);

                                                        }

                                                        break;
                                                    case ship31:
                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);
                                                            ImStOpponent[ii+2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+2) + (jj), "id", getPackageName()), ii+2, jj, fieldOpponent);

                                                        }else {
                                                            ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);
                                                            ImStOpponent[ii][jj+2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+2), "id", getPackageName()), ii, jj+2, fieldOpponent);

                                                        }


                                                        break;
                                                    case ship32:
                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                            ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                            ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);

                                                        }
                                                        break;
                                                    case ship33:

                                                         if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                            ImStOpponent[ii-2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-2) + (jj), "id", getPackageName()), ii-2, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                            ImStOpponent[ii][jj-2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-2), "id", getPackageName()), ii, jj-2, fieldOpponent);

                                                        }


                                                        break;
                                                    case ship41:

                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);
                                                            ImStOpponent[ii+2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+2) + (jj), "id", getPackageName()), ii+2, jj, fieldOpponent);
                                                            ImStOpponent[ii+3][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+3) + (jj), "id", getPackageName()), ii+3, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                            ImStOpponent[ii][jj-2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-2), "id", getPackageName()), ii, jj-2, fieldOpponent);
                                                            ImStOpponent[ii][jj-3] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-3), "id", getPackageName()), ii, jj-3, fieldOpponent);

                                                        }

                                                        break;
                                                    case ship42:
                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                            ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);
                                                            ImStOpponent[ii+2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+2) + (jj), "id", getPackageName()), ii+2, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                            ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);
                                                            ImStOpponent[ii][jj+2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+2), "id", getPackageName()), ii, jj+2, fieldOpponent);

                                                        }
                                                        break;
                                                    case ship43:
                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                            ImStOpponent[ii-2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-2) + (jj), "id", getPackageName()), ii-2, jj, fieldOpponent);
                                                            ImStOpponent[ii+1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii+1) + (jj), "id", getPackageName()), ii+1, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj-1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-1), "id", getPackageName()), ii, jj-1, fieldOpponent);
                                                            ImStOpponent[ii][jj-2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj-2), "id", getPackageName()), ii, jj-2, fieldOpponent);
                                                            ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);

                                                        }

                                                        break;
                                                    case ship44:

                                                        if(fieldOpponent[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                            ImStOpponent[ii-1][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-1) + (jj), "id", getPackageName()), ii-1, jj, fieldOpponent);
                                                            ImStOpponent[ii-2][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-2) + (jj), "id", getPackageName()), ii-2, jj, fieldOpponent);
                                                            ImStOpponent[ii-3][jj] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii-3) + (jj), "id", getPackageName()), ii-3, jj, fieldOpponent);


                                                        }else {
                                                            ImStOpponent[ii][jj+1] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+1), "id", getPackageName()), ii, jj+1, fieldOpponent);
                                                            ImStOpponent[ii][jj+2] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+2), "id", getPackageName()), ii, jj+2, fieldOpponent);
                                                            ImStOpponent[ii][jj+3] =  ImageStatus.up;
                                                            ChangeOpponent (getResources().getIdentifier("imageView" + (ii) + (jj+3), "id", getPackageName()), ii, jj+3, fieldOpponent);

                                                        }

                                                        break;
                                                }
                                                }

                                                flag_abortazh = false;
                                            }


                                            // запрет  на нажатия всех клеток после совершения хода
                                            NoClick(ImOpponent);
                                        }
                                    });

                                }


                            }







                                    flag = 0;
                        }
                        else {

                            TextView NamePlayer = findViewById(R.id.Use_name);
                            NamePlayer.setText(Player[0].Getname());

                            TextView ZvaniePlayer = findViewById(R.id.Zvanie);
                            ZvaniePlayer.setText(Player[0].Getzvanie());

                            TextView ExperiencePlayer = findViewById(R.id.Count);
                            ExperiencePlayer.setText(String.valueOf(Player[0].Getexperiment()));


                            // поле игрока
                            DrawMap(fieldPlayer, ImPlayer);

                            if( Client_obj.ansServer.contains("[g]") ){
                                // перерисовка выбранной клетки
                                String s = Client_obj.ansServer;

                                int i =  Character.getNumericValue(Client_obj.ansServer.charAt(4));
                                int j=Character.getNumericValue( Client_obj.ansServer.charAt(6));
                                ChangePlayer (getResources().getIdentifier("imageView" + i + j, "id", getPackageName()), i, j);
                            }


                            for(int i =0; i< 10; i++){
                                for (int j =0; j<10;j++){

                                    final int ii = i;
                                    final int jj = j;
                                    if (fieldPlayer[ii][jj].GetStatusOrientation() == orientation.vertically) {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                                            ImPlayer[i][j].animate().rotation(90);
                                        }

                                    }
                                    final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                                    ImPlayer[i][j].setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {
                                            // перерисовка выбранной клетки
                                            ChangePlayer (res, ii, jj);

                                            if(flag_tool){


                                                if (fieldPlayer[ii][jj].GetStatus() == status.kill ) {

                                                    fieldPlayer[ii][jj].SetStatus(status.ship);

                                                    switch ( fieldPlayer[ii][jj].GetStatus_Ship()) {


                                                        case ship11:

                                                            fieldPlayer[ii][jj].SetStatus(status.ship);

                                                            break;
                                                        case ship21:
                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){

                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);

                                                            }else {
                                                                fieldPlayer[ii][jj+1].SetStatus(status.ship);
                                                            }


                                                            break;
                                                        case ship22:

                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){

                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                            }else {

                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                            }

                                                            break;
                                                        case ship31:
                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+2][jj].SetStatus(status.ship);

                                                            }else {
                                                                fieldPlayer[ii][jj+1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj+2].SetStatus(status.ship);
                                                            }


                                                            break;
                                                        case ship32:
                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){

                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);


                                                            }else {
                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj+1].SetStatus(status.ship);

                                                            }
                                                            break;
                                                        case ship33:

                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii-2][jj].SetStatus(status.ship);

                                                            }else {
                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-2].SetStatus(status.ship);

                                                            }


                                                            break;
                                                        case ship41:

                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+2][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+3][jj].SetStatus(status.ship);

                                                            }else {
                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-2].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-3].SetStatus(status.ship);

                                                            }

                                                            break;
                                                        case ship42:
                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+2][jj].SetStatus(status.ship);


                                                            }else {
                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj+1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj+2].SetStatus(status.ship);


                                                            }
                                                            break;
                                                        case ship43:
                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii-2][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii+1][jj].SetStatus(status.ship);



                                                            }else {
                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-2].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj+1].SetStatus(status.ship);

                                                            }

                                                            break;
                                                        case ship44:

                                                            if(fieldPlayer[ii][jj].GetStatusOrientation() ==  orientation.vertically){
                                                                fieldPlayer[ii-1][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii-2][jj].SetStatus(status.ship);
                                                                fieldPlayer[ii-3][jj].SetStatus(status.ship);



                                                            }else {

                                                                fieldPlayer[ii][jj-1].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-2].SetStatus(status.ship);
                                                                fieldPlayer[ii][jj-3].SetStatus(status.ship);

                                                            }

                                                            break;
                                                    }
                                                }

                                                flag_tool = false;
                                            }
                                            if (flag_anchor){

                                                for(int k =0; k< 10; k++){
                                                    for (int h=0; h<10; h++){
                                                        if (fieldPlayer[k][h].GetStatus()== status.ship )
                                                        mapPlayer.NearOneShip(k,h);

                                                    }

                                                }

                                                if (fieldPlayer[ii][jj].GetStatus() == status.ship ) {
                                                     ImPlayer[ii][jj].setImageResource(R.drawable.my_map);
                                                     fieldPlayer[ii][jj].SetStatus(empty);

                                                    // размещение однопалубного
                                                    int  new_i;
                                                    int  new_j;
                                                        do {
                                                            new_i = 0 + (int) (Math.random() * 9);
                                                            new_j = 0 + (int) (Math.random() * 9);
                                                        }
                                                        while ( fieldPlayer[new_i][new_j].GetStatus() != empty);


                                                        fieldPlayer[new_i][new_j].SetStatus(status.ship);
                                                        fieldPlayer[new_i][new_j].SetStatus_Ship(ships_st.ship11);
                                                       ImPlayer[new_i][new_j].setImageResource(R.drawable.ship_one);


                                                    for(int k =0; k< 10; k++){
                                                        for (int h=0; h<10; h++){
                                                            if (fieldPlayer[k][h].GetStatus()== near_ship )
                                                                fieldPlayer[k][h].SetStatus(empty);

                                                        }

                                                    }





                                                }


                                                flag_anchor = false;

                                            }

                                            // запрет  на нажатия всех клеток после совершения хода
                                            NoClick(ImPlayer);


                                        }
                                    });



                                }

                            }

                            // поле игрока
                            DrawMap(fieldPlayer, ImPlayer);
                            ImageView.setImageResource(R.drawable.button_right);
                            flag = 1;

                        }


            }
            break;

            // чат
            case R.id.Auto: {
                final Dialog dialog = new Dialog(Activity_Game.this);
                dialog.setContentView(R.layout.chat);
                Button button =  dialog.findViewById(R.id.Ok);
                Button button1 = dialog.findViewById(R.id.Send);
                final TextView Message = dialog.findViewById(R.id.Edit_chat_text);
                 final TextView Message1 = dialog.findViewById(R.id.Message1);
                final TextView Message2 = dialog.findViewById(R.id.Message2);
                final TextView Message3 = dialog.findViewById(R.id.Message3);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Thread thread = new Thread(new Runnable() { @Override public void run() {  try {

                            Client_obj client_obj = new Client_obj();
                            byte[] byteArray = ("[c] " +Message.getText().toString()).getBytes();
                            client_obj.run( byteArray ); // Пробуем приконнетиться...
                            if( Client_obj.ansServer.contains("[c]") ){
                                Message1.setText(Message2.getText().toString());
                                Message2.setText(Message3.getText().toString());
                                Message3.setText(Client_obj.ansServer.replace("[c]", Player[0].Getname()+": "));}
                        } catch (IOException e) {
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "Unable to connect. Server not running?", Toast.LENGTH_LONG);
                            toast.show();

                } } }); thread.start();
            }
        });


                dialog.setCancelable(false);
                dialog.show();
            }
            break;
        }


    }


//изменение состояния клетки при нажатии
    public  void  ChangeOpponent (int res, int i, int j, Field[][] field){

        ImageView Imm = (ImageView) findViewById(res);
        switch (field[i][j].GetStatus()){

            case ship:
                switch (field[i][j].GetStatus_Ship()){
                case ship11:
                    Imm.setImageResource(R.drawable.ship_one);
                    break;
                case ship21:
                    Imm.setImageResource(R.drawable.ship_two_1);
                    break;
                case ship22:
                    Imm.setImageResource(R.drawable.ship_two_2);
                    break;
                case ship31:
                    Imm.setImageResource(R.drawable.ship_three_1);
                    break;
                case ship32:
                    Imm.setImageResource(R.drawable.ship_three_2);
                    break;
                case ship33:
                    Imm.setImageResource(R.drawable.ship_three_3);
                    break;
                case ship41:
                    Imm.setImageResource(R.drawable.ship_four_1);
                    break;
                case ship42:
                    Imm.setImageResource(R.drawable.ship_four_2);
                    break;
                case ship43:
                    Imm.setImageResource(R.drawable.ship_four_3);
                    break;
                case ship44:
                    Imm.setImageResource(R.drawable.ship_four_4);
                    break;

            }
            break;
            case empty:
                Imm.setImageResource(R.drawable.my_map);
                break;
            case bomb:
                Imm.setImageResource(R.drawable.bomb70);
                break;
            case kill:
                Imm.setImageResource(R.drawable.fire1);
            case checked:
                Imm.setImageResource(R.drawable.mimo);

        }

    }

    // запрет на нажатие клеток после совершения хода
    public void NoClick( ImageView [][] Im){

        for(int i =0; i< 10; i++){
            for (int j =0; j<10;j++) {
                Im[i][j].setClickable(false);
            }
        }
    }


   // разрешение нажатия на клетки поля
    public  void Click (ImageView [][] Im){

        for(int i =0; i< 10; i++){
            for (int j =0; j<10;j++) {
                Im[i][j].setClickable(true);
                    }
                }
    }

    //нанесение удара
    public void ChangePlayer(int res, int i, int j){

        ImageView Imm = (ImageView) findViewById(res);
       if (fieldPlayer[i][j].GetStatus() == status.ship){

           Imm.setImageResource(R.drawable.fire1);
           fieldPlayer[i][j].SetStatus(status.kill);}
           else if (fieldPlayer[i][j].GetStatus() == status.kill &&  flag_tool){
           DrawField(fieldPlayer[i][j], i,j, ImPlayer);
       }else {
           Imm.setImageResource(R.drawable.mimo);
           fieldPlayer[i][j].SetStatus(checked);
       }
    }

    //заполнение клетки картинкой
    public Field DrawField (Field field, int i , int j, ImageView [][] Im){
        switch (field.GetStatus()){

            case ship:
                switch (field.GetStatus_Ship()){
                    case ship11:
                        Im[i][j].setImageResource(R.drawable.ship_one);

                        break;
                    case ship21:
                        Im[i][j].setImageResource(R.drawable.ship_two_1);
                        break;
                    case ship22:
                        Im[i][j].setImageResource(R.drawable.ship_two_2);
                        break;
                    case ship31:
                        Im[i][j].setImageResource(R.drawable.ship_three_1);
                        break;
                    case ship32:
                        Im[i][j].setImageResource(R.drawable.ship_three_2);
                        break;
                    case ship33:
                        Im[i][j].setImageResource(R.drawable.ship_three_3);
                        break;
                    case ship41:
                        Im[i][j].setImageResource(R.drawable.ship_four_1);
                        break;
                    case ship42:
                        Im[i][j].setImageResource(R.drawable.ship_four_2);
                        break;
                    case ship43:
                        Im[i][j].setImageResource(R.drawable.ship_four_3);
                        break;
                    case ship44:
                        Im[i][j].setImageResource(R.drawable.ship_four_4);
                        break;

                }
                break;
            case empty:
                Im[i][j].setImageResource(R.drawable.my_map);
                break;
            case bomb:
                Im[i][j].setImageResource(R.drawable.bomb70);
                break;
            case kill:
                Im[i][j].setImageResource(R.drawable.fire1);
        }
        return field;
    }


    // заполнение поля картинками
    public  void DrawMap (Field[][] field, ImageView [][] Im){
        for(int i =0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (field[i][j].GetStatus()){

                    case ship:
                        switch (field[i][j].GetStatus_Ship()){
                            case ship11:
                                Im[i][j].setImageResource(R.drawable.ship_one);

                                break;
                            case ship21:
                                Im[i][j].setImageResource(R.drawable.ship_two_1);
                                break;
                            case ship22:
                                Im[i][j].setImageResource(R.drawable.ship_two_2);
                                break;
                            case ship31:
                                Im[i][j].setImageResource(R.drawable.ship_three_1);
                                break;
                            case ship32:
                                Im[i][j].setImageResource(R.drawable.ship_three_2);
                                break;
                            case ship33:
                                Im[i][j].setImageResource(R.drawable.ship_three_3);
                                break;
                            case ship41:
                                Im[i][j].setImageResource(R.drawable.ship_four_1);
                                break;
                            case ship42:
                                Im[i][j].setImageResource(R.drawable.ship_four_2);
                                break;
                            case ship43:
                                Im[i][j].setImageResource(R.drawable.ship_four_3);
                                break;
                            case ship44:
                                Im[i][j].setImageResource(R.drawable.ship_four_4);
                                break;

                        }
                        break;
                    case empty:
                        Im[i][j].setImageResource(R.drawable.my_map);
                        break;
                    case bomb:
                        Im[i][j].setImageResource(R.drawable.bomb70);
                        break;
                    case checked:
                        Im[i][j].setImageResource(R.drawable.mimo);
                        break;
                    case kill:
                        Im[i][j].setImageResource(R.drawable.fire1);
                }


            }
        }

    }


}
