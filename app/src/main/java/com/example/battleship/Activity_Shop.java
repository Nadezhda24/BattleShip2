package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Shop extends AppCompatActivity {
    Player[] Player = new Player[2];
    String title ;
    String description ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__shop);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

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

        TextView Count_money = findViewById(R.id.Count_money);
        Count_money.setText(String.valueOf(Player[0].Getmoney()));

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
            case R.id.Back: {
                Intent intent = new Intent(Activity_Shop.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.Bonus1:
            case R.id.Bonus2:
            case R.id.Bonus3:
            case R.id.Bonus4:
            case R.id.Help: {
                final Dialog dialog = new Dialog(Activity_Shop.this);
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
                    title = "Магазин";
                    description = "Ты попал в торговый порт. Торговцы с разных стран прибыли сюда продавать свои товары. Ты можешь купить все необходимое за золотые монеты, что поможет тебе стать лучшим мореплавателем и одерживать больше побед.";
                    ;}


                TextView Title = (TextView) dialog.findViewById(R.id.Topic);
                Title.setText(title);
                TextView Description = (TextView) dialog.findViewById(R.id.Description);
                Description.setText(description);


                dialog.setCancelable(false);
                dialog.show();

            }
            break;

        }
    }
}
