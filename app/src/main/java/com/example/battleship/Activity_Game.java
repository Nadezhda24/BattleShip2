package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity_Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
    }






    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.Back: {
                Intent intent = new Intent(Activity_Game.this, Activity_Menu.class);
                startActivity(intent);
            }
            break;

            case R.id.Auto: {
                final Dialog dialog = new Dialog(Activity_Game.this);
                dialog.setContentView(R.layout.chat);
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
        }

    }
}
