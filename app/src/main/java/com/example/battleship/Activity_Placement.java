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
    Map map ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__placement);


            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    int res = getResources().getIdentifier("imageView" + i + j, "id", getPackageName());
                    field[i][j] = new Field((ImageView) findViewById(res));
                    field[i][j].GetImageView().setImageResource(R.drawable.fon_18);

                }
            }

       map = new Map(field);

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

              map.PlacementRand(field);

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
