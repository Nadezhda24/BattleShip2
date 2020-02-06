package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Activity_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);


        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        LinerLayout.addView(Login);

        EditText  Login_edit = new EditText(this);
        Login_edit.setWidth(200);
        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        LinerLayout.addView(Password);

        EditText  Password_edit = new EditText(this);
        Password_edit.setWidth(200);
        LinerLayout.addView(Password_edit);

        Button Registration = (Button) findViewById(R.id.Registration);
        Button Authentication = (Button) findViewById(R.id.Authentication);
        Button Next = (Button) findViewById(R.id.Next);

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
    public void OnClickR(View view) {

        setContentView(R.layout.activity_main);
        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);

        TextView Name = new TextView(this);
        Name.setWidth(200);
        Name.setText("Имя");
        LinerLayout.addView(Name);

        EditText  Name_edit = new EditText(this);
        Name_edit.setWidth(200);
        LinerLayout.addView(Name_edit);

        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        LinerLayout.addView(Login);

        EditText  Login_edit = new EditText(this);
        Login_edit.setWidth(200);
        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        LinerLayout.addView(Password);

        EditText  Password_edit = new EditText(this);
        Password_edit.setWidth(200);
        LinerLayout.addView(Password_edit);

        TextView Password2 = new TextView(this);
        Password2.setWidth(200);
        Password2.setText("Подтвердите пароль");
        LinerLayout.addView(Password2);

        EditText  Password2_edit = new EditText(this);
        Password2_edit.setWidth(200);
        LinerLayout.addView(Password2_edit);

    }

    public void OnClickA(View view) {
        setContentView(R.layout.activity_main);
        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);


        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        LinerLayout.addView(Login);

        EditText  Login_edit = new EditText(this);
        Login_edit.setWidth(200);
        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        LinerLayout.addView(Password);

        EditText  Password_edit = new EditText(this);
        Password_edit.setWidth(200);
        LinerLayout.addView(Password_edit);


    }

    public void OnClickNext(View view) {
        Intent intent = new Intent(Activity_Registration.this, Activity_Menu.class);
        startActivity(intent);
    }
}
