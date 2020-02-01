package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Activity_Placement extends AppCompatActivity implements View.OnTouchListener{

    private ViewGroup mMoveLayout1 ;
    private int mX;
    private int mY;


    private ImageView imageView3, FourShip,
            ThreeShip1, ThreeShip2,
            TwoShip1,TwoShip2, TwoShip3,
            OneSip1,OneSip2,OneSip3,OneSip4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);
       //Связываемся с нашими объектами, определяя изображение через заданный ViewGroup:

        mMoveLayout1 = (ViewGroup) findViewById(R.id.TouchLayout);



        imageView3 = (ImageView) mMoveLayout1.findViewById(R.id.imageView3);

        //Создаем программно RelativeLayout с параметрами 100*100:
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);

        //Применяем эти параметры к нашему изображению:
         imageView3.setLayoutParams(layoutParams);
        //И настраиваем ему слушателя (обработчик) прикосновений:
        imageView3.setOnTouchListener(this);



    }


    public void OnClick(View view) {

        switch (view.getId()) {
            case R.id. Back: {
                Intent intent = new Intent(Activity_Placement.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.imageView: {
                //настройки звука
            }
            break;
            case R.id.Auto: {
                //Растановка кораблей случайно
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
        final int X = (int) event.getRawX();
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
        }
        return true;

    }
}
