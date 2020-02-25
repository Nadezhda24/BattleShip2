package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class Activity_Placement extends AppCompatActivity implements View.OnTouchListener{
    Field [][] field = new Field[10][10];

    Ship [] ship = new Ship[10];
    Map map ;
    Player[] Player = new Player[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);


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

        ImageView ImageView1 = (ImageView) findViewById(R.id.imageView00);
        ImageView ImageView2 = (ImageView) findViewById(R.id.imageView01);
        ImageView ImageView3 = (ImageView) findViewById(R.id.imageView02);
        ImageView ImageView4 = (ImageView) findViewById(R.id.imageView03);


        ship [0]= new FourShip(ImageView1,ImageView2,ImageView3,ImageView4);
        ship[0].GetShip(0).setImageResource(R.drawable.fouri1);
        ship[0].GetShip(1).setImageResource(R.drawable.fouri2);
        ship[0].GetShip(2).setImageResource(R.drawable.fouri3);
        ship[0].GetShip(3).setImageResource(R.drawable.fouri4);

        for(int i =1 ; i< 3; i++ ) {
            ship[i] = new ThreeShip(ImageView1, ImageView2, ImageView3);
            ship[i].GetShip(0).setImageResource(R.drawable.three1);
            ship[i].GetShip(1).setImageResource(R.drawable.three2);
            ship[i].GetShip(2).setImageResource(R.drawable.three3);

        }
        for (int i=3; i< 6; i++){
            ship[i]= new TwoShip(ImageView1,ImageView2);
            ship[i].GetShip(0).setImageResource(R.drawable.two1);
            ship[i].GetShip(1).setImageResource(R.drawable.two2);
        }

        for (int i=6; i< 10; i++){
            ship[i]= new Ship(ImageView1);
            ship[i].GetShip(0).setImageResource(R.drawable.oneship);
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                field[i][j] = new Field((ImageView) findViewById(res),res);
                field[i][j].GetImageView().setImageResource(R.drawable.my_map);

            }
        }


        map = new Map(field, ship);

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
            case R.id. Back: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Menu.class);

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
            case R.id.Music: {
                //настройки звука
            }
            break;
           case R.id.Auto: {

                // map.PlacementRand(field, ship);

                for (int k = 0; k < 10; k++) {
                    for (int  p = 0; p < 10; p++) {
                        field[k][p].SetStatus(status.empty);
                        field[k][p].GetImageView().setImageResource(R.drawable.my_map);

                    }
                }



                int i = 0+(int)(Math.random() * 6);
                int j = 0+(int)(Math.random() * 6);
                // для выбора смещаения по горизонтали i и вертикали j
                int ki = 0+(int)(Math.random() * 1);
                int kj = 0+(int)(Math.random() * 1);

                if (ki == kj && ki == 1) { ki--;}
                else if (ki== kj && ki == 0) {ki++;}

                // размещение четырехпалубного
                for (int k =0; k< 4 ; k++) {
                    //   this.field[i + ki * k][j + kj * k].SetImageView(ship[0].GetShip(k));
                    this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
                    this.field = map.NearOneShip(this.field,i + ki * k,j + ki * k );

                }
                this.field[i + ki * 0][j + kj * 0]. GetImageView().setImageResource(R.drawable.fouri1);

                this.field[i + ki * 1][j + kj * 1]. GetImageView().setImageResource(R.drawable.fouri2);
                this.field[i + ki * 2][j + kj * 2]. GetImageView().setImageResource(R.drawable.fouri3);
                this.field[i + ki * 3][j + kj * 3]. GetImageView().setImageResource(R.drawable.fouri4);



                // размещение трехпалубного
                for (int r =1; r<3; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 7);
                        j = 0 + (int) (Math.random() * 7);
                    }
                    while ( field[i][j].GetStatus() == status.ship ||field[i][j].GetStatus() == status.near_ship );

                    ki = 0 + (int) (Math.random() * 1);
                    kj = 0 + (int) (Math.random() * 1);
                    if (ki == kj && ki == 1) { ki--; }
                    else if (ki == kj && ki == 0) { ki++; }

                    for (int k =0; k< 3 ; k++) {
                        //   this.field[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                        this.field[i + ki * k][j + kj * k].SetStatus(status.ship);


                        this.field = map.NearOneShip(this.field,i + ki * k,j + ki * k );

                    }

                    this.field[i + ki * 0][j + kj * 0]. GetImageView().setImageResource(R.drawable.three1);
                    this.field[i + ki * 1][j + kj * 1]. GetImageView().setImageResource(R.drawable.three2);
                    this.field[i + ki * 2][j + kj * 2]. GetImageView().setImageResource(R.drawable.three3);


                }

                // размещение двухпалубного
                for (int r =3; r<6; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 8);
                        j = 0 + (int) (Math.random() * 8);
                    }
                    while ( field[i][j].GetStatus() == status.ship ||field[i][j].GetStatus() == status.near_ship);

                    ki = 0 + (int) (Math.random() * 1);
                    kj = 0 + (int) (Math.random() * 1);
                    if (ki == kj && ki == 1) {ki--; }
                    else if (ki == kj && ki == 0) { ki++; }

                    for (int k =0; k< 2 ; k++) {
                        //  this.field[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                        this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
                        this.field = map.NearOneShip(this.field,i + ki * k,j + ki * k );
                    }


                    this.field[i + ki * 0][j + kj * 0]. GetImageView().setImageResource(R.drawable.two1);
                    this.field[i + ki * 1][j + kj * 1]. GetImageView().setImageResource(R.drawable.two2);


                }




                // размещение однопалубного
                for (int r =6; r<10; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 9);
                        j = 0 + (int) (Math.random() * 9);
                    }
                    while ( field[i][j].GetStatus() == status.ship ||field[i][j].GetStatus() == status.near_ship );

                    //  this.field[i][j].SetImageView(ship[r].GetShip(0));
                    this.field[i][j].SetStatus(status.ship);
                    this.field[i][j]. GetImageView().setImageResource(R.drawable.oneship);

                    this.field = map.NearOneShip(this.field,i ,j );


                }



            }
            break;

            case R.id.Next: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Game.class);
               // intent.putExtra("field", field);
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
        }

    }
      @Override
   public boolean onTouch(View v, MotionEvent event) {
//Определение координат через getRawX() и getRawY() дает
        //координаты по отношению к размерам экрана устройства:
     /*   final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            //ACTION_DOWN срабатывает при прикосновении к экрану,
            //здесь определяется начальное стартовое положение объекта:
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                mX = X - lParams.leftMargin;
                mY = Y - lParams.topMargin;
                break;

            //ACTION_MOVE обрабатывает случившиеся в процессе прикосновения изменения, здесь
            //содержится информация о последней точке, где находится объект после окончания действия прикосновения ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                layoutParams.leftMargin = X - mX;
                layoutParams.topMargin = Y - mY;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                break;
        }*/
        return true;
    }
}
