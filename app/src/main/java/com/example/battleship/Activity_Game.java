package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

import static com.example.battleship.status.checked;

public class Activity_Game extends AppCompatActivity {


    Field [][] fieldPlayer = new Field[10][10];
    Field [][] fieldOpponent = new Field[10][10];
    ImageView [][] ImPlayer = new ImageView[10][10];
    ImageView [][] ImOpponent = new ImageView[10][10];
    Ship [] ship = new Ship[10];
    Map mapPlayer, mapOpponent ;
    Player[] Player = new Player[2];
    int flag;//переключатель между игроками во время игры

    int flag_bomb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }

        flag = 0;
        flag_bomb = 1;
        Player[0] = new Player();
        Player[1] = new Player();
        Bundle arguments = getIntent().getExtras();
        Player[0] =  (Player) arguments.getSerializable("player");


        fieldPlayer=  Player[0].GetMap().field ;

        // проверка карты у игроков пока одинаковые
        fieldOpponent = Player[0].GetMap().field;


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                final int ii =i ;
                final int jj =  j;
                final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());


                ImPlayer [i][j] = (ImageView) findViewById(res);
                ImOpponent [i][j] = (ImageView) findViewById(res);


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

        TextView NamePlayer = findViewById(R.id.Use_name);
        NamePlayer.setText(Player[0].Getname());

        TextView ZvaniePlayer = findViewById(R.id.Zvanie);
        ZvaniePlayer.setText(Player[0].Getzvanie());

        TextView ExperiencePlayer = findViewById(R.id.Count);
        ExperiencePlayer.setText(String.valueOf(Player[0].Getexperiment()));

        mapPlayer = new Map(fieldPlayer, ship);
        mapOpponent = new Map(fieldOpponent, ship);



    if (  Player[0].Getregim_game() == 1 ) {
        //сундучки
        final Dialog dialog = new Dialog(Activity_Game.this);
        dialog.setContentView(R.layout.choice);
        Button button = dialog.findViewById(R.id.Ok);
        final TextView text = dialog.findViewById(R.id.Choice);
        final ImageView box_one = dialog.findViewById(R.id.box_one);
        final ImageView box_two= dialog.findViewById(R.id.box_two);

        //Право первого хода
         final int player_choice = 0+(int)(Math.random() * 2);

        box_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                final Dialog dialog1 = new Dialog(Activity_Game.this);
                dialog1.setContentView(R.layout.pirate);
                Button button1 = dialog1.findViewById(R.id.yes);
                Button button2 = dialog1.findViewById(R.id.no);

                TextView text = dialog1.findViewById(R.id.piratetext);


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    // расстановка бомб
                      fieldOpponent = mapOpponent.PirateBomb(0+(int)(Math.random() * 4));

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


        ImageView0.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                flag_bomb = 1;
            }
        });




    }




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
                    overridePendingTransition(R.anim.anim, R.anim.anim1);
                }
            }
            break;

            case R.id.Ukaz:{

                ImageView ImageView = (ImageView) findViewById(R.id.Ukaz);

                        if (flag == 1){
                            // поле противника
                            ImageView.setImageResource(R.drawable.button_left);

                            for(int i =0; i< 10; i++){
                                for (int j =0; j<10;j++){

                                    final int ii = i;
                                    final int jj = j;
                                    // скрытие поля противника
                                    ImOpponent[i][j].setImageResource(R.drawable.my_map);

                                    final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                                    ImOpponent[i][j].setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {
                                            // прорисовка выбранной клетки
                                            ChangeOpponent (res, ii, jj, fieldOpponent);
                                            // запрет  на нажатия всех клеток после совершения хода
                                            NoClick(ImOpponent);
                                        }
                                    });

                                }

                            }

                            flag = 0;
                        }
                        else {
                            // поле игрока
                            DrawMap(fieldPlayer, ImPlayer);
                            for(int i =0; i< 10; i++){
                                for (int j =0; j<10;j++){

                                    final int ii = i;
                                    final int jj = j;
                                    final int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                                    ImPlayer[i][j].setOnClickListener(new View.OnClickListener() {


                                        @Override
                                        public void onClick(View v) {
                                            // перерисовка выбранной клетки
                                            ChangePlayer (res, ii, jj);
                                            // запрет  на нажатия всех клеток после совершения хода
                                            NoClick(ImPlayer);
                                        }
                                    });
                                }

                            }
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


//изменение состояния клетки при нажатии
    public  void  ChangeOpponent (int res, int i, int j, Field[][] field){

        ImageView Imm = (ImageView) findViewById(res);
        switch (field[i][j].GetStatus()){

            case ship:
                Imm.setImageResource(R.drawable.ship1);
                break;
            case empty:
                Imm.setImageResource(R.drawable.my_map);
                break;
            case bomb:
                Imm.setImageResource(R.drawable.bomb);
                break;

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
        Imm.setImageResource(R.drawable.indikator);
        fieldPlayer[i][j].SetStatus(checked);
    }

    //заполнение клетки картинкой
    public Field DrawField (Field field, int i , int j, ImageView [][] Im){
        switch (field.GetStatus()){

            case ship:
                Im[i][j].setImageResource(R.drawable.ship1);
                break;
            case empty:
                Im[i][j].setImageResource(R.drawable.my_map);
                break;
            case bomb:
                Im[i][j].setImageResource(R.drawable.bomb);
                break;
        }
        return field;
    }

    // заполнение поля картинками
    public  void DrawMap (Field[][] field, ImageView [][] Im){
        for(int i =0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                switch (field[i][j].GetStatus()){

                    case ship:
                        Im[i][j].setImageResource(R.drawable.ship1);
                        break;
                    case empty:
                        Im[i][j].setImageResource(R.drawable.my_map);
                        break;
                    case bomb:
                        Im[i][j].setImageResource(R.drawable.bomb);
                        break;
                    case checked:
                        Im[i][j].setImageResource(R.drawable.indikator);
                        break;
                }

            }
        }

    }
}
