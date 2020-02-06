package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Shop extends AppCompatActivity {

    String title ;
    String description ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__shop);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
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
                    title = "Бонус1";
                    description = "Описание бонуса1";
                    ;}
                else if (view.getId() == R.id.Bonus2) {
                    title = "Бонус2";
                    description = "Описание бонуса2";
                    ;}
                else if(view.getId() == R.id.Bonus3) {
                    title = "Бонус3";
                    description = "Описание бонуса3";
                    ;}
                else if (view.getId() == R.id.Bonus4) {
                    title = "Бонус4";
                    description = "Описание бонуса4";
                    ;}
                else   {
                    title = "Магазин";
                    description = "Описание магазина ";
                    ;}


                TextView Title = (TextView) dialog.findViewById(R.id.Title);
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
