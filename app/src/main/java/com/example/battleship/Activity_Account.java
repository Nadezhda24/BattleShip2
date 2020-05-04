package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Activity_Account extends AppCompatActivity {
    Player[] Player = new Player[2];
    String title ;
    String description ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }

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

        TextView NamePlayer = findViewById(R.id.Bonus);
        NamePlayer.setText(Player[0].Getname());

        TextView ZvaniePlayer = findViewById(R.id.Zvanie);
        ZvaniePlayer.setText(Player[0].Getzvanie());

        TextView ExperiencePlayer = findViewById(R.id.Experience);
        ExperiencePlayer.setText(String.valueOf(Player[0].Getexperiment()));

        TextView Best_experience = findViewById(R.id.Best_experience);
        Best_experience.setText("500");

        TextView Count_bonus1 = findViewById(R.id.Count_bonus1);
        Count_bonus1.setText(String.valueOf(Player[0].money));
        TextView Count_bonus2 = findViewById(R.id.Count_bonus2);
        Count_bonus2.setText(String.valueOf(Player[0].money));
        TextView Count_bonus3 = findViewById(R.id.Count_bonus3);
        Count_bonus3.setText(String.valueOf(Player[0].money));
        TextView Count_bonus4 = findViewById(R.id.Count_bonus4);
        Count_bonus4.setText(String.valueOf(Player[0].money));

        TextView Count_money = findViewById(R.id.Count_money);
        Count_money.setText(String.valueOf(Player[0].money));


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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Account.this, Activity_Menu.class);

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
                   // overridePendingTransition(R.anim.anim, R.anim.anim1);
                }
            }
            break;
            case R.id.Help: {
                Intent intent = new Intent(Activity_Account.this, Activity_Setting_Account.class);

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
                 //   overridePendingTransition(R.anim.anim, R.anim.anim1);
                }

            }
            break;
            case R.id.Rating: {

                final Dialog dialog = new Dialog(Activity_Account.this);
                dialog.setContentView(R.layout.rating);



                Button button = (Button) dialog.findViewById(R.id.Ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                final TextView N1 = (TextView) dialog.findViewById(R.id.Name1);
                final TextView N2 = (TextView) dialog.findViewById(R.id.Name2);
                final TextView N3 = (TextView) dialog.findViewById(R.id.Name3);
                final TextView L1 = (TextView) dialog.findViewById(R.id.Login1);
                final TextView L2 = (TextView) dialog.findViewById(R.id.Login2);
                final TextView L3 = (TextView) dialog.findViewById(R.id.Login3);
                final TextView Z1 = (TextView) dialog.findViewById(R.id.Zvanie1);
                final TextView Z2 = (TextView) dialog.findViewById(R.id.Zvanie2);
                final TextView Z3 = (TextView) dialog.findViewById(R.id.Zvanie3);
                final TextView E1 = (TextView) dialog.findViewById(R.id.Count_exp1);
                final TextView E2 = (TextView) dialog.findViewById(R.id.Count_exp2);
                final TextView E3 = (TextView) dialog.findViewById(R.id.Count_exp3);

                final String[] s = {"1 3 2"};

                Thread thread = new Thread(new Runnable() { @Override public void run() {  try {

                    Client_obj client_obj = new Client_obj();
                    byte[] byteArray = ("[t] ").getBytes();
                    client_obj.run( byteArray ); // Пробуем приконнетиться...

                    if( Client_obj.ansServer.contains("[t]") ){

                        N1.setText(Client_obj.ansServer);}
                } catch (IOException e) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Unable to connect. Server not running?", Toast.LENGTH_LONG);
                    toast.show();

                } } }); thread.start();



                String ans_Server = s[0];

                N1.setText("Player2");L1.setText("PL");Z1.setText("главный старшина"); E1.setText("480");
                N2.setText("Player1");L2.setText("PL1");Z2.setText("матрос"); E2.setText("100");
                N3.setText("Player3");L3.setText("PL3");Z3.setText("матрос"); E3.setText("0");


                dialog.setCancelable(false);
                dialog.show();




            }
            break;
            case R.id.Bonus1:
            case R.id.Bonus2:
            case R.id.Bonus3:
            case R.id.Bonus4:
            case R.id.Money: {
                final Dialog dialog = new Dialog(Activity_Account.this);
                dialog.setContentView(R.layout.bonus_description);
                Button button = (Button) dialog.findViewById(R.id.Ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

             if(view.getId() == R.id.Bonus1) {
                 title = "Ремонт";
                 description = "Команда судоремонтников восстанавливают разрушенные части твоего корабля и приводят его в боевую готовность для дальнейших сражений.";
                 ;}
             else if (view.getId() == R.id.Bonus2) {
                    title = "Подзорная труба";
                    description = "Отправь матроса на наблюдательную башню, выбери поле противника размером 3*3 и тебе сообщат в течение 5 секунд все, что видно на горизонте.";
                    ;}
             else if(view.getId() == R.id.Bonus3) {
                    title = "Бомба";
                    description = "Прикажи зарядить баллисту, выстрелив в поле противника бомбой, радиус одного удара 3*3.";
                    ;}
             else if (view.getId() == R.id.Bonus4) {
                    title = "Динамит";
                    description = "Комендор предоставляет твоей команде динамит, сокруши весь корабль противника одним ударом!";
                    ;}
             else   {
                    title = "Золотые монеты";
                    description = "Побеждай противников в бою и пополняй свои трюма золотом.";
                    ;}


                TextView Title = (TextView) dialog.findViewById(R.id.Topic);
                Title.setText(title);
                TextView Description = (TextView) dialog.findViewById(R.id.Description);
                Description.setText(description);


                dialog.setCancelable(false);
                dialog.show();

            }
            break;
            case R.id.progressBar: {

                final Dialog dialog = new Dialog(Activity_Account.this);
                dialog.setContentView(R.layout.statistics);
                Button button = (Button) dialog.findViewById(R.id.ok);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                TextView NamePlayer = dialog.findViewById(R.id.Name);
                NamePlayer.setText(Player[0].Getname());

                TextView ZvaniePlayer = dialog.findViewById(R.id.Zvanie);
                ZvaniePlayer.setText(Player[0].Getzvanie());

                TextView Count = (TextView) dialog.findViewById(R.id.Count);
                Count.setText("Очки: " + String.valueOf(Player[0].Getexperiment()));
                TextView Count_game = (TextView) dialog.findViewById(R.id.Count_game);
                Count_game.setText("Количество игр: " + String.valueOf(Player[0].Getcount_game()));
                TextView Count_win = (TextView) dialog.findViewById(R.id.Count_win);
                Count_win.setText("Количество побед: " + String.valueOf(Player[0].Getcount_win()) );
                TextView Count_loss = (TextView) dialog.findViewById(R.id.Count_loss);
                Count_loss.setText("Количество поражений: " + String.valueOf(Player[0].Getcount_game() - Player[0].Getcount_win()));

                dialog.setCancelable(false);
                dialog.show();
            }
            break;
            case R.id.Shop: {
                Intent intent = new Intent(Activity_Account.this, Activity_Shop.class);
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
                   // overridePendingTransition(R.anim.anim, R.anim.anim1);
                }
            }
            break;
        }
    }
}
