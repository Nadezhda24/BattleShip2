package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;


public class Activity_Registration extends AppCompatActivity {

    Player[] Player = new Player[2];

    EditText  Name_edit ;
    EditText  Login_edit ;
    EditText  Password_edit ;
    EditText  Password2_edit ;

    String SName ;
    String SLogin ;
    String SPassword ;
    String SPassword2 ;

    boolean flag; // true - аунтификация false - регистрация
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }



        flag = true;
        Player[0] = new Player();
        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);


        Login_edit = new EditText(this);
        Password_edit = new EditText(this);

        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Login.setTextAppearance(R.style.strings);

            Login.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Login);

        Login_edit = new EditText(this);
        Login_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Login_edit.setTextAppearance(R.style.strings);

            Login_edit.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password.setTextAppearance(R.style.strings);

            Password.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password);

        Password_edit = new EditText(this);
        Password_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password_edit.setTextAppearance(R.style.strings);

            Password_edit.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password_edit);

        Button Registration = (Button) findViewById(R.id.Registration);
        Button Authentication = (Button) findViewById(R.id.Authentication);
        Button Next = (Button) findViewById(R.id.Next);

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

    public void OnClickR(View view) {

        flag = false;
        setContentView(R.layout.activity_main);
        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);

        TextView Name = new TextView(this);
        LinerLayout.addView(Name);
        Name.setWidth(200);
        Name.setText("Имя");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Name.setTextAppearance(R.style.strings);

            Name.setTextColor(Color.BLACK);
        }


        Name_edit = new EditText(this);
        Login_edit = new EditText(this);
        Password_edit = new EditText(this);
        Password2_edit = new EditText(this);


        Name_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Name_edit.setTextAppearance(R.style.strings);

            Name_edit.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Name_edit);

        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Login.setTextAppearance(R.style.strings);

            Login.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Login);


        Login_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Login_edit.setTextAppearance(R.style.strings);

            Login_edit.setTextColor(Color.BLACK);
        }

        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password.setTextAppearance(R.style.strings);

            Password.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password);


        Password_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password_edit.setTextAppearance(R.style.strings);

            Password_edit.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password_edit);

        TextView Password2 = new TextView(this);
        Password2.setWidth(200);
        Password2.setText("Подтвердите пароль");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password2.setTextAppearance(R.style.strings);

            Password2.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password2);


        Password2_edit.setWidth(200);
        Password_edit.setWidth(200);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password2_edit.setTextAppearance(R.style.strings);

            Password2_edit.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password2_edit);






    }

    public void OnClickA(View view) {
        setContentView(R.layout.activity_main);

        flag = true;

        LinearLayout LinerLayout = (LinearLayout) findViewById(R.id.LinearLayout);


        Login_edit = new EditText(this);
        Password_edit = new EditText(this);


        TextView Login = new TextView(this);
        Login.setWidth(200);
        Login.setText("Логин");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Login.setTextAppearance(R.style.strings);

            Login.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Login);

        Login_edit = new EditText(this);
        Login_edit.setWidth(200);
        LinerLayout.addView(Login_edit);

        TextView Password = new TextView(this);
        Password.setWidth(200);
        Password.setText("Пароль");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Password.setTextAppearance(R.style.strings);

            Password.setTextColor(Color.BLACK);
        }
        LinerLayout.addView(Password);

        Password_edit = new EditText(this);
        Password_edit.setWidth(200);
        LinerLayout.addView(Password_edit);


        Player[0] = new Player();


    }

    public void OnClickNext(View view) {

        SLogin = Login_edit.getText().toString();
        SPassword = Password_edit.getText().toString();
if(flag){



   Thread thread = new Thread(new Runnable() { @Override public void run() {  try {

        Client_obj client_obj = new Client_obj();
        byte[] byteArray = ("[a] " + SLogin + " " + SPassword).getBytes();
        client_obj.run( byteArray ); // Пробуем приконнетиться...

    } catch (IOException e) {
        // если объект не создан...
        Toast toast = Toast.makeText(getApplicationContext(),
                "Unable to connect. Server not running?", Toast.LENGTH_LONG);
        toast.show();



    } } }); thread.start();

    Player[0] = new Player(1,"Player","PL1","12345Player1", "12345Player1");

}
else{
        SName =  Name_edit.getText().toString() ;

        SPassword2 = Password2_edit.getText().toString();

    Thread thread = new Thread(new Runnable() { @Override public void run() {  try {

        Client_obj client_obj = new Client_obj();
        byte[] byteArray = ("[r] " +SName+" "+SLogin + " " + SPassword).getBytes();
        client_obj.run( byteArray ); // Пробуем приконнетиться...

    } catch (IOException e) {
        // если объект не создан...
        Toast toast = Toast.makeText(getApplicationContext(),
                "Unable to connect. Server not running?", Toast.LENGTH_LONG);
        toast.show();

    } } }); thread.start();
        Player[0] = new Player(1,SName,SLogin,SPassword, SPassword2);}

        Intent intent = new Intent(Activity_Registration.this, Activity_Menu.class);
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
          //  overridePendingTransition(R.anim.anim, R.anim.anim1);
        }
    }
}
