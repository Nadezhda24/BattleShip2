package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class Activity_Placement extends AppCompatActivity implements View.OnTouchListener{

   /* private ViewGroup mMoveLayout1 ;
    private int mX;
    private int mY;*/

   //Field [][] map  = new Field[10][10];
    ImageView[][] map = new  ImageView[10][10];
    int [][] intmap = new int [11][11]; // 1- корабль, 2- вокруг карабля
    Ship [] ship = new Ship[10];



    private ImageView ImageView;
            /* FourShip,
            ThreeShip1, ThreeShip2,
            TwoShip1,TwoShip2, TwoShip3,
            OneSip1,OneSip2,OneSip3,OneSip4;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);

        FourShip FourShip= new FourShip();
        ship[1] = new ThreeShip();
        ship[2]= new ThreeShip();

        for (int i=3; i< 6; i++){
            ship[i]= new TwoShip();
        }

        for (int i=6; i< 11; i++){
            ship[i]= new Ship();
        }



        for (int i =0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int res = getResources().getIdentifier("imageView" + i +j, "id", getPackageName());

                map[i][j] = (ImageView) findViewById(res);



               map[i][j].setClickable(true);
                map[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  Change(v);

                        // int a = v.getId();

                    }
                });
            }
        }

      /*  mMoveLayout1 = (ViewGroup) findViewById(R.id.TouchLayout);
        imageView3 = (ImageView) mMoveLayout1.findViewById(R.id.imageView3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
         imageView3.setLayoutParams(layoutParams);
        imageView3.setOnTouchListener(this);*/





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
                startActivity(intent);
            }
            break;
            case R.id.Music: {
                //настройки звука
            }
            break;
            case R.id.Auto: {

                for (int i =0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        map[i][j].setImageResource(R.drawable.fon_18);

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
                map[i+ki*0][j+kj*0].setImageResource(R.drawable.fouri1);
                map[i+ki*1][j+kj*1].setImageResource(R.drawable.fouri2);
                map[i+ki*2][j+kj*2].setImageResource(R.drawable.fouri3);
                map[i+ki*3][j+kj*3].setImageResource(R.drawable.fouri4);

              for (int k=0; k< 4; k++) {
                  intmap[i + ki * k][j + kj * k]=1;





              }


              // размещение трехпалубного
             for (int r =0; r<2; r++) {
                  do {
                      i = 0 + (int) (Math.random() * 7);
                      j = 0 + (int) (Math.random() * 7);
                  }
                  while (intmap[i][j] == 1 );

                  ki = 0 + (int) (Math.random() * 1);
                  kj = 0 + (int) (Math.random() * 1);
                  if (ki == kj && ki == 1) {
                      ki--;
                  } else if (ki == kj && ki == 0) {
                      ki++;
                  }

                  map[i + ki * 0][j + kj * 0].setImageResource(R.drawable.three1);
                  map[i + ki * 1][j + kj * 1].setImageResource(R.drawable.three2);
                  map[i + ki * 2][j + kj * 2].setImageResource(R.drawable.three3);

                  for (int k=0; k< 3; k++) {
                      intmap[i + ki * k][j + kj * k]=1;


                  }


              }

              // размещение двухпалубного
                for (int r =0; r<3; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 8);
                        j = 0 + (int) (Math.random() * 8);
                    }
                    while (intmap[i][j] == 1 );

                    ki = 0 + (int) (Math.random() * 1);
                    kj = 0 + (int) (Math.random() * 1);
                    if (ki == kj && ki == 1) {
                        ki--;
                    } else if (ki == kj && ki == 0) {
                        ki++;
                    }

                    map[i + ki * 0][j + kj * 0].setImageResource(R.drawable.two1);
                    map[i + ki * 1][j + kj * 1].setImageResource(R.drawable.two2);


                    for (int k=0; k< 2; k++) {
                        intmap[i + ki * k][j + kj * k]=1;




                    }


                }

// размещение однопалубного
                for (int r =0; r<4; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 9);
                        j = 0 + (int) (Math.random() * 9);
                    }
                    while (intmap[i][j] == 1 );

                    map[i][j].setImageResource(R.drawable. oneship);

                        intmap[i][j]=1;
                    int k =0;

                }





            }
            break;
            case R.id.Next: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Game.class);
                startActivity(intent);
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
