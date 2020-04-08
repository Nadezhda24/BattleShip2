package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




public class Activity_Help extends AppCompatActivity {

int flag ;
int title_count =9;
String titles;
String description ;
Player[] Player = new Player[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
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
       //  Typeface face = Typeface.createFromAsset(getAssets(), "maintext.ttf");
      //  text.setTypeface(Typeface.createFromAsset(getAssets(), "maintext.ttf"));
        text.setText(description);
        LinerLayout.addView(text);

        flag = 0;

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
                Intent intent = new Intent(Activity_Help.this, Activity_Menu.class);

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
                    description = "1)\tСамостоятельная расстановка\n"+"Выбери самостоятельно позиции для своих боевых кораблей.";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);


                    ImageView ImageView = new ImageView(this);
                    ImageView.setImageResource(R.drawable.bomb);
                    LinerLayout.addView(ImageView);

                    TextView text1 = new TextView(this);
                    text1.setWidth(200);
                    text1.setText("2)\tРасстановка автоматически\n" +"Кнопка \"авто\" поможет расставить за тебя корабли.");
                    LinerLayout.addView(text1);

                    ImageView ImageView1 = new ImageView(this);
                    ImageView1.setImageResource(R.drawable.bomb);
                    LinerLayout.addView(ImageView1);





                }
                break;
                case 3: {
                    titles = "Режимы игры";
                    description = "1)\tКлассический режим\n" + "Наслаждайся классическими правилами игры в данном режи";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);


                    ImageView ImageView = new ImageView(this);
                    ImageView.setImageResource(R.drawable.bomb);
                    LinerLayout.addView(ImageView);

                    TextView text1 = new TextView(this);
                    text1.setWidth(200);
                    text1.setText("2)\tРассширенный режим\n" +"Мы добавили новые возможности для тебя, дорогой друг. Попробуй их все, стань сильнее, побеждай противников и выигрывай быстрее!");
                    LinerLayout.addView(text1);

                    ImageView ImageView1 = new ImageView(this);
                    ImageView1.setImageResource(R.drawable.bomb);
                    LinerLayout.addView(ImageView1);

                }
                break;
                case 4: {
                    titles = "Новые возможности";
                    description = "Для твоих героических сражений мы добавили новые возможности";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);


                    LinearLayout LL = new LinearLayout(this);
                    LL.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView ImageView1 = new ImageView(this);
                    ImageView1.setImageResource(R.drawable.galternatives);
                    ImageView1.setLayoutParams(new ViewGroup.LayoutParams
                            (200, 200));


                    LL.addView(ImageView1);

                    TextView text1 = new TextView(this);
                    text1.setWidth(200);
                    text1.setText("Ремонт\n" +
                            "Команда судоремонтников восстанавливают " +
                            "разрушенные части твоего корабля и приводят" +
                            " его в боевую готовность для дальнейших сражений.");
                    text1.setLayoutParams(new ViewGroup.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LL.addView(text1);

                    LinerLayout.addView(LL);


                    LinearLayout LL2 = new LinearLayout(this);
                    LL2.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView ImageView2 = new ImageView(this);
                    ImageView2.setImageResource(R.drawable.trubka);
                    ImageView2.setLayoutParams(new ViewGroup.LayoutParams
                            (200, 200));

                    LL2.addView(ImageView2);

                    TextView text2 = new TextView(this);
                    text2.setWidth(200);
                    text2.setText("Подзорная труба\n" +
                            "Отправь матроса на наблюдательную башню," +
                            " выбери поле противника размером 3*3 и" +
                            " тебе сообщат в течение 5 секунд все, что видно на горизонте.");
                    text2.setLayoutParams(new ViewGroup.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LL2.addView(text2);

                    LinerLayout.addView(LL2);

                    LinearLayout LL3 = new LinearLayout(this);
                    LL3.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView ImageView3 = new ImageView(this);
                    ImageView3.setImageResource(R.drawable.ka);
                    ImageView3.setLayoutParams(new ViewGroup.LayoutParams
                            (200, 200));

                    LL3.addView(ImageView3);

                    TextView text3 = new TextView(this);
                    text3.setWidth(200);
                    text3.setText("Бомба \n" +
                            "Прикажи зарядить баллисту, " +
                            "выстрелив в поле противника бомбой," +
                            " радиус одного удара 3*3.");
                    text3.setLayoutParams(new ViewGroup.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LL3.addView(text3);

                    LinerLayout.addView(LL3);

                    LinearLayout LL4 = new LinearLayout(this);
                    LL4.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView ImageView4 = new ImageView(this);
                    ImageView4.setImageResource(R.drawable.dynamite);
                    ImageView4.setLayoutParams(new ViewGroup.LayoutParams
                            (200, 200));

                    LL4.addView(ImageView4);

                    TextView text4 = new TextView(this);
                    text4.setWidth(200);
                    text4.setText("Динамит\n" +
                            "Комендор предоставляет твоей команде динамит, сокруши весь корабль противника одним ударом!");
                    text4.setLayoutParams(new ViewGroup.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LL4.addView(text4);

                    LinerLayout.addView(LL4);




                    LinearLayout LL5 = new LinearLayout(this);
                    LL4.setOrientation(LinearLayout.HORIZONTAL);

                    ImageView ImageView5 = new ImageView(this);
                    ImageView5.setImageResource(R.drawable.dynamite);
                    ImageView5.setLayoutParams(new ViewGroup.LayoutParams
                            (200, 200));

                    LL5.addView(ImageView5);

                    TextView text5 = new TextView(this);
                    text5.setWidth(200);
                    text5.setText("Поднять якорь!\n" +
                            "Подними якорь  корабля и  перемести его " +
                            "в другое место. Но будь внимателен, перемещать корабль уже " +
                            "нельзя на клетки проверенные противником. За один ход ты можешь продвинуться на одну" +
                            " клетку или повернуть корабль на 90* по часовой стрелки, если клетки для перемещения свободны.\n");
                    text5.setLayoutParams(new ViewGroup.LayoutParams
                            (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    LL5.addView(text5);

                    LinerLayout.addView(LL5);




                }
                break;
                case 5: {
                    titles = "Валюта";
                    description = "Возможно, ты уже заметил, в игре действует собственная валюта – золотые монеты. Сражайся в битвах, набирай очки, повышай звания  и ты сможешь заработать свое золото. На свои сбережения покупай припасы в магазине.";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);


                    ImageView ImageView = new ImageView(this);
                    ImageView.setImageResource(R.drawable.coins);
                    LinerLayout.addView(ImageView);


                }
                break;
                case 6: {
                    titles = "Победа или поражение ";
                    description = "Бой закончен, пора забирать свои награды! " +
                            "Одержав победу над противником, твое завоеванное золото удваивается." +
                            " Выиграв бой над соперником выше званием, ты быстрее заработаешь очки и приблизишься к новому званию.\n" +
                            "Не расстраивайся поражением, твоя награда тебя ждет, В следующий раз тебе точно повезет!  \n";
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
                    description = "В зависимости от твоих очков ты можешь получить следующий звания:";
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
                    description = "Зарабатывая очки, ты соревнуешься с другими мореплавателями. Найди свое место в рейтинге в аккаунте.\n" +
                            "Зарабатывай больше очков и стань самым могущественным повелителем морей.\n";
                    LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.TestL);
                    LinerLayout.removeAllViewsInLayout();
                    TextView title = (TextView) findViewById(R.id.title);
                    title.setText(titles);
                    TextView text = new TextView(this);
                    text.setWidth(200);
                    text.setText(description);
                    LinerLayout.addView(text);


                    ImageView ImageView = new ImageView(this);
                    ImageView.setImageResource(R.drawable.svitok);
                    LinerLayout.addView(ImageView);

                }
                break;
               case 9: {
                   titles = "Настройки";
                   description = "Не забывай, что ты можешь разнообразить свои сражения, обновив обстановку музыкой на выбор. Перейди в настройки в меню и выбери понравившуюся композицию.";
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
