package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;




public class Activity_Help extends AppCompatActivity {

int flag ;
int title_count =9;
String titles;
String description ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        titles = "Предыстория";
        description = "Дорогой друг, ты попал в те времена, когда океаны еще не были исследованы, " +
                "моря не принадлежали государствам. " +
                "Вокруг происходят сражения за территорию. " +
                "Брось вызов другим завоевателям и стань повелителем морей!" ;

        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(titles);
        TextView text = new TextView(this);
        text.setWidth(200);
        text.setText(description);
        LinerLayout.addView(text);

        flag = 0;

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
                Intent intent = new Intent(Activity_Help.this, Activity_Menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim, R.anim.anim1);

            }
            break;
            case R.id.Music: {
                //Настройка музыки
            }
            break;
            case R.id.Left: {
                if(flag == 0) flag =title_count;
                else flag--;
            }
            break;
            case R.id.Right: {
                if(flag == title_count) flag =0;
                else flag++;
            }
            break;
        }


           switch (flag) {
                case 0: {


                    titles = "Предыстория";
                    description = "Дорогой друг, ты попал в те времена, когда океаны еще не были исследованы, " +
                            "моря не принадлежали государствам. " +
                            "Вокруг происходят сражения за территорию. " +
                            "Брось вызов другим завоевателям и стань повелителем морей!";

                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);
                }
                break;
                case 1: {
                    titles = "Общие правила";
                    description = "Ты сражаешься с противником." +
                            " Перед началом битвы ты тянешь жребий, " +
                            "выбирая один из двух сундуков." +
                            " Если сундук заполнен, поздравляем – первый ход твой!" +
                            " Ты уже на шаг ближе к победе. Время наносить удары по кораблям противника. " +
                            "Успешное попадание дает тебе право еще одного хода, а промах – это право передается противнику." +
                            " Твоя цель — потопить все вражеские корабли.";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 2: {
                    titles = "Расстановка кораблей";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 3: {
                    titles = "Классический режим игры";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 4: {
                    titles = "Расширенный режим игры";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 5: {
                    titles = "Новые возможности";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 6: {
                    titles = "Победа или поражение ";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
                case 7: {
                    titles = "Звания";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);
                }
                break;
                case 8: {
                    titles = "Рейтинг";
                    description = "";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);

                }
                break;
               case 9: {
                   titles = "Настройки";
                   description = "";
                   LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                   LinerLayout.removeAllViewsInLayout();
                   TextView title = (TextView) findViewById(R.id.title);
                   title.setText(titles);
                   TextView text = new TextView(this);
                   text.setWidth(200);
                   text.setText(description);
                   LinerLayout.addView(text);

               }
               break;
            }







    }
}
