package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_Account extends AppCompatActivity {

    String title ;
    String description ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Account.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;
            case R.id.Help: {
                Intent intent = new Intent(Activity_Account.this, Activity_Setting_Account.class);
                startActivity(intent);
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
                    title = "Монеты";
                    description = "Описание ";
                    ;}


                TextView Title = (TextView) dialog.findViewById(R.id.Title);
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

                TextView Count = (TextView) dialog.findViewById(R.id.Count);
                Count.setText("Очки: ");
                TextView Count_game = (TextView) dialog.findViewById(R.id.Count_game);
                Count_game.setText("Количество игр: ");
                TextView Count_win = (TextView) dialog.findViewById(R.id.Count_win);
                Count_win.setText("Количество побед: ");
                TextView Count_loss = (TextView) dialog.findViewById(R.id.Count_loss);
                Count_loss.setText("Количество поражений: ");

                dialog.setCancelable(false);
                dialog.show();
            }
            break;
            case R.id.Shop: {
                Intent intent = new Intent(Activity_Account.this, Activity_Shop.class);
                startActivity(intent);
            }
            break;
        }
    }
}
