package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Setting_Account extends AppCompatActivity {

    Player[] Player = new Player[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__setting__account);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

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


        TextView ZvaniePlayer = findViewById(R.id.Zvanie);
        ZvaniePlayer.setText(Player[0].Getzvanie());
        EditText editTextName = findViewById(R.id.editTextName);
        editTextName.setText(Player[0].Getname());
        EditText editTextLogin = findViewById(R.id.editTextLogin);
        editTextLogin.setText(Player[0].Getlogin());
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword.setText(Player[0].Getpassword());

        EditText editTextPassword2 = findViewById(R.id.editTextPassword2);
        editTextPassword2.setText("");

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
            case R.id.Back: {
                Intent intent = new Intent(Activity_Setting_Account.this, Activity_Account.class);
                intent.putExtra("id", Player[0].Getid());
                intent.putExtra("name", Player[0].Getname());
                intent.putExtra("login", Player[0].Getlogin());
                intent.putExtra("password", Player[0].Getpassword());
                intent.putExtra("money", Player[0].Getmoney());
                intent.putExtra("experiment", Player[0].Getexperiment());
                intent.putExtra("count_game", Player[0].Getcount_game());
                intent.putExtra("zvanie", Player[0].Getzvanie());
                startActivity(intent);
            }
            break;
            case R.id.Save: {

                EditText editTextName = findViewById(R.id.editTextName);
                EditText editTextLogin = findViewById(R.id.editTextLogin);
                EditText editTextPassword = findViewById(R.id.editTextPassword);
                EditText editTextPassword2 = findViewById(R.id.editTextPassword2);


              //  if(editTextPassword.getText().toString()==editTextPassword2.getText().toString()) {

                    Player[0].Setname(editTextName.getText().toString());

                    Player[0].Setlogin(editTextLogin.getText().toString());

                    Player[0].Setpassword(editTextPassword.getText().toString());
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Изменения сохранены", Toast.LENGTH_SHORT);
                    toast.show();
             /*   }else {

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Изменения не сохранены.Пароль повторно был введен не верно.", Toast.LENGTH_SHORT);
                    toast.show();
                }*/
            }
        }
    }


}
