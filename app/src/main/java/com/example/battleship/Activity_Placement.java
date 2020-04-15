package com.example.battleship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.battleship.status.*;


public class Activity_Placement extends AppCompatActivity implements View.OnTouchListener{

    Field [][] field = new Field[10][10];
    Ship [] ship = new Ship[10];
    Map map ;
    Player[] Player = new Player[2];
    ImageView [][] Im = new ImageView[10][10];
    boolean flag_turn;
    // 1- расширенный 0- классический

    private ImageView mImageView11,mImageView12,mImageView13,mImageView14,mImageView21,mImageView22,mImageView23,mImageView31,mImageView32,mImageView41;
    private ViewGroup mMoveLayout0;
    private int mX;
    private int mY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);

        Player[0] = new Player(field ,ship );
        Bundle arguments = getIntent().getExtras();
        Player[0].Setid(arguments.getInt("id"));
        Player[0].Setname(arguments.getString("name"));
        Player[0].Setlogin(arguments.getString("login"));
        Player[0].Setpassword(arguments.getString("password"));
        Player[0].Setzvanie(arguments.getString("zvanie"));
        Player[0].Setmoney(arguments.getInt("money"));
        Player[0].Setcount_game(arguments.getInt("count_game"));
        Player[0].Setexperiment(arguments.getInt("experiment"));
        Player[0].Setregim_game(arguments.getInt("regime_game"));

        ship [0]= new FourShip();

        for(int i =1 ; i< 3; i++ ) {
            ship[i] = new ThreeShip();
        }
        for (int i=3; i< 6; i++){
            ship[i]= new TwoShip();
        }

        for (int i=6; i< 10; i++){
            ship[i]= new Ship();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                field[i][j] = new Field(res);
                Im [i][j] = (ImageView) findViewById(res);
                Im [i][j].setImageResource(R.drawable.my_map);

            }
        }


        map = new Map(field, ship);


//Связываемся с нашими объектами, определяя изображение через заданный ViewGroup:
        mMoveLayout0 = (ViewGroup) findViewById(R.id.FL);

        mImageView11 = (ImageView) mMoveLayout0.findViewById(R.id.Ship11);
        mImageView12 = (ImageView) mMoveLayout0.findViewById(R.id.Ship12);
        mImageView13 = (ImageView) mMoveLayout0.findViewById(R.id.Ship13);
        mImageView14 = (ImageView) mMoveLayout0.findViewById(R.id.Ship14);

        mImageView21 = (ImageView) mMoveLayout0.findViewById(R.id.Ship21);
        mImageView22 = (ImageView) mMoveLayout0.findViewById(R.id.Ship22);
        mImageView23 = (ImageView) mMoveLayout0.findViewById(R.id.Ship23);

        mImageView31 = (ImageView) mMoveLayout0.findViewById(R.id.Ship31);
        mImageView32 = (ImageView) mMoveLayout0.findViewById(R.id.Ship32);

        mImageView41 = (ImageView) mMoveLayout0.findViewById(R.id.Ship41);
        flag_turn = false;
        //И настраиваем ему слушателя (обработчик) прикосновений:
        mImageView11.setOnTouchListener(this);
        mImageView12.setOnTouchListener(this);
        mImageView13.setOnTouchListener(this);
        mImageView14.setOnTouchListener(this);

        mImageView21.setOnTouchListener(this);
        mImageView22.setOnTouchListener(this);
        mImageView23.setOnTouchListener(this);

        mImageView31.setOnTouchListener(this);
        mImageView32.setOnTouchListener(this);

        mImageView41.setOnTouchListener(this);



    }

    @SuppressLint("NewApi")
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

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
                   // overridePendingTransition(R.anim.anim, R.anim.anim1);
                }
            }
            break;
            case R.id.Turn:{

               if(!flag_turn) {
                    mImageView11.animate().rotation(90);
                    mImageView12.animate().rotation(90);
                    mImageView13.animate().rotation(90);
                    mImageView14.animate().rotation(90);

                    mImageView21.animate().rotation(90);
                    mImageView22.animate().rotation(90);
                    mImageView23.animate().rotation(90);

                    mImageView31.animate().rotation(90);
                    mImageView32.animate().rotation(90);

                    mImageView41.animate().rotation(90);
                    flag_turn = true;
                }else{
                   mImageView11.animate().rotation(0);
                   mImageView12.animate().rotation(0);
                   mImageView13.animate().rotation(0);
                   mImageView14.animate().rotation(0);

                   mImageView21.animate().rotation(0);
                   mImageView22.animate().rotation(0);
                   mImageView23.animate().rotation(0);

                   mImageView31.animate().rotation(0);
                   mImageView32.animate().rotation(0);

                   mImageView41.animate().rotation(0);
                   flag_turn = false;
               }

            }
            break;
            case R.id.Music: {
                //настройки звука
            }
            break;
           case R.id.Auto: {
                for (int k = 0; k < 10; k++) {
                    for (int  p = 0; p < 10; p++) {
                        field[k][p].SetStatus(empty);
                     Im[k][p].setImageResource(R.drawable.my_map);

                    }
                }
                int i = 0+(int)(Math.random() * 6);
                int j = 0+(int)(Math.random() * 6);
                // для выбора смещаения по горизонтали i и вертикали j
                int ki = 0+(int)(Math.random() * 2);
                int kj = 0+(int)(Math.random() * 2);

                if (ki == kj && ki == 1) { ki--;}
                else if (ki== kj && ki == 0) {ki++;}

                // размещение четырехпалубного
               for (int k =0; k< 4 ; k++) {
                    this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
                     this.field = map.NearOneShip(i + ki * k,j + kj * k );

                }

               this.field[i + ki * 0][j + kj * 0].SetStatus_Ship(ships_st.ship41);
               this.field[i + ki * 1][j + kj * 1].SetStatus_Ship(ships_st.ship42);
               this.field[i + ki * 2][j + kj * 2].SetStatus_Ship(ships_st.ship43);
               this.field[i + ki * 3][j + kj * 3].SetStatus_Ship(ships_st.ship44);

               if (ki== 1){
                   Im[i + ki * 0][j + kj * 0].animate().rotation(90);
                   Im[i + ki * 1][j + kj * 1].animate().rotation(90);
                   Im[i + ki * 2][j + kj * 2].animate().rotation(90);
                   Im[i + ki * 3][j + kj * 3].animate().rotation(90);
                   this.field[i + ki * 0][j + kj * 0].SetStatusOrientation(orientation.vertically);
                   this.field[i + ki * 1][j + kj * 1].SetStatusOrientation(orientation.vertically);
                   this.field[i + ki * 2][j + kj * 2].SetStatusOrientation(orientation.vertically);
                   this.field[i + ki * 3][j + kj * 3].SetStatusOrientation(orientation.vertically);
               }

               Im[i + ki * 0][j + kj * 0].setImageResource(R.drawable.ship_four_1);
               Im[i + ki * 1][j + kj * 1].setImageResource(R.drawable.ship_four_2);
               Im[i + ki * 2][j + kj * 2].setImageResource(R.drawable.ship_four_3);
               Im[i + ki * 3][j + kj * 3].setImageResource(R.drawable.ship_four_4);


                // размещение трехпалубного
              for (int r =1; r<3; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 7);
                        j = 0 + (int) (Math.random() * 7);


                         ki = 0+(int)(Math.random() * 2);
                        kj = 0+(int)(Math.random() * 2);
                        if (ki == kj && ki == 1) { ki--; }
                    else if (ki == kj && ki == 0) { ki++; }

                    }
                    while ( (field[i + ki * 0][i + kj * 0].GetStatus() == status.ship || field[i + ki * 0][i + kj * 0].GetStatus() == near_ship) ||
                            (field[i + ki * 1][i + kj * 1].GetStatus() == status.ship || field[i + ki * 1][i + kj * 1].GetStatus() == near_ship )||
                            (field[i + ki * 2][i + kj * 2].GetStatus() == status.ship || field[i + ki * 2][i + kj * 2].GetStatus() == near_ship )

                    );

                    for (int k =0; k< 3 ; k++) {

                        this.field[i + ki * k][j + kj * k].SetStatus(status.ship);


                        this.field = map.NearOneShip(i + ki * k,j + kj * k );

                    }
                  this.field[i + ki * 0][j + kj * 0].SetStatus_Ship(ships_st.ship31);
                  this.field[i + ki * 1][j + kj * 1].SetStatus_Ship(ships_st.ship32);
                  this.field[i + ki * 2][j + kj * 2].SetStatus_Ship(ships_st.ship33);

                  if (ki== 1){
                      Im[i + ki * 0][j + kj * 0].animate().rotation(90);
                      Im[i + ki * 1][j + kj * 1].animate().rotation(90);
                      Im[i + ki * 2][j + kj * 2].animate().rotation(90);
                      this.field[i + ki * 0][j + kj * 0].SetStatusOrientation(orientation.vertically);
                      this.field[i + ki * 1][j + kj * 1].SetStatusOrientation(orientation.vertically);
                      this.field[i + ki * 2][j + kj * 2].SetStatusOrientation(orientation.vertically);

                  }
                  Im[i + ki * 0][j + kj * 0].setImageResource(R.drawable.ship_three_1);
                  Im[i + ki * 1][j + kj * 1].setImageResource(R.drawable.ship_three_2);
                  Im[i + ki * 2][j + kj * 2].setImageResource(R.drawable.ship_three_3);



                }

                // размещение двухпалубного
                for (int r =3; r<6; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 8);
                        j = 0 + (int) (Math.random() * 8);
                    }
                    while ( field[i][j].GetStatus() == status.ship ||field[i][j].GetStatus() == near_ship);

                    ki = 0+(int)(Math.random() * 2);
                    kj = 0+(int)(Math.random() * 2);
                    if (ki == kj && ki == 1) {ki--; }
                    else if (ki == kj && ki == 0) { ki++; }

                    for (int k =0; k< 2 ; k++) {
                        //  this.field[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                        this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
                        this.field = map.NearOneShip(i + ki * k,j + kj * k );
                    }
                    this.field[i + ki * 0][j + kj * 0].SetStatus_Ship(ships_st.ship21);
                    this.field[i + ki * 1][j + kj * 1].SetStatus_Ship(ships_st.ship22);

                    if (ki== 1){
                        Im[i + ki * 0][j + kj * 0].animate().rotation(90);
                        Im[i + ki * 1][j + kj * 1].animate().rotation(90);
                        this.field[i + ki * 0][j + kj * 0].SetStatusOrientation(orientation.vertically);
                        this.field[i + ki * 1][j + kj * 1].SetStatusOrientation(orientation.vertically);


                    }

                    Im[i + ki * 0][j + kj * 0].setImageResource(R.drawable.ship_two_1);
                    Im[i + ki * 1][j + kj * 1].setImageResource(R.drawable.ship_two_2);


                }




                // размещение однопалубного
               for (int r =6; r<10; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 9);
                        j = 0 + (int) (Math.random() * 9);
                    }
                    while ( field[i][j].GetStatus() == status.ship ||field[i][j].GetStatus() == near_ship );

                    //  this.field[i][j].SetImageView(ship[r].GetShip(0));
                    this.field[i][j].SetStatus(status.ship);
                   this.field[i + ki * 0][j + kj * 0].SetStatus_Ship(ships_st.ship11);



                   Im[i + ki * 0][j + kj * 0].setImageResource(R.drawable.ship_one);


                    this.field = map.NearOneShip(i ,j );


                }

               for (int k =0; k <10; k++){
                   for (int p=0; p<10; p++){

                       if (field[k][p].GetStatus() == near_ship)  field[k][p].SetStatus(empty);

                   }

               }


               //DrawMap(field);
             Player[0].SetMap(this.map);

//проверка растановки
         /*     for (int k = 0; k < 10; k++) {
                   for (int  p = 0; p < 10; p++) {
                     if( field[k][p].GetStatus() == status.bomb)

                       field[k][p].GetImageView().setImageResource(R.drawable.ka);

                   }
               }

*/




           }
            break;


            case R.id.Start:{

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        field[i][j].SetStatus(empty);
                    }
                }


                map = new Map(field, ship);

            }
            break;
            case R.id.Next: {

    Intent intent = new Intent(Activity_Placement.this, Activity_Game.class);
    intent.putExtra("player", Player[0]);
    startActivity(intent);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
                  //  overridePendingTransition(R.anim.anim, R.anim.anim1);
                }


            }

            break;
        }

    }
      @Override
   public boolean onTouch(View v, MotionEvent event) {
        //Определение координат через getRawX() и getRawY() дает
        //координаты по отношению к размерам экрана устройства:
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
          RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
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

                layoutParams.leftMargin = X - mX;
                layoutParams.topMargin = Y - mY;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                break;
        }






        return true;
    }


// заполнение поля картинками
    public  void DrawMap (Field[][] field){
for(int i =0; i<10; i++) {
    for (int j = 0; j < 10; j++) {
        switch (field[i][j].GetStatus()){

    case ship:
        Im[i][j].setImageResource(R.drawable.ship_one);
        break;
        case empty:
       Im[i][j].setImageResource(R.drawable.my_map);
       break;
            case bomb:
        Im[i][j].setImageResource(R.drawable.bomb);
        break;

        }

    }
}

    }
}

