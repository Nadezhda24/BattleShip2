package com.example.battleship.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static com.example.battleship.data.Database.DatabasePlayer.TABLE_NAME;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "player.db";

     //Версия базы данных. При изменении схемы увеличить на единицу
    private static final int DATABASE_VERSION = 4;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // для создания бд

    @Override
    public void onCreate(SQLiteDatabase db) {

        String  SQL_create_Player =
                "CREATE TABLE if not exists " + Database.DatabasePlayer.TABLE_NAME +
                        " (" + Database.DatabasePlayer.id_Player + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + Database.DatabasePlayer.name_Player + " TEXT NOT NULL, "
                        + Database.DatabasePlayer.login_Player + " TEXT NOT NULL, "
                        + Database.DatabasePlayer.password_Player + " TEXT NOT NULL, "
                        + Database.DatabasePlayer.money_Player + " INTEGER NOT NULL DEFAULT 0, "
                        + Database.DatabasePlayer.experiment_Player + " INTEGER NOT NULL DEFAULT 0, "
                        + Database.DatabasePlayer.count_game_Player + " INTEGER NOT NULL DEFAULT 0, "
                        + Database.DatabasePlayer. count_win_Player + " INTEGER NOT NULL DEFAULT 0, "
                        + Database.DatabasePlayer.id_zvanie_Player + " INTEGER NOT NULL DEFAULT 0," +
                        "FOREIGN KEY (" + Database.DatabasePlayer.id_zvanie_Player + ")REFERENCES "
                        + Database.DatabaseZvanie.TABLE_NAME + "(" + Database.DatabaseZvanie.id_Zvanie
                        + ") ON DELETE NO ACTION ON UPDATE NO ACTION);";

        String  SQL_create_Zvanie =
                "CREATE TABLE if not exists  " + Database.DatabaseZvanie.TABLE_NAME +
                        " (" + Database.DatabaseZvanie.id_Zvanie + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + Database.DatabaseZvanie.name_Zvanie + " TEXT NOT NULL);";

        String  SQL_create_Feature =
                "CREATE TABLE if not exists " + Database.DatabaseFeature.TABLE_NAME +
                        " (" + Database.DatabaseFeature.id_Feature + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                        + Database.DatabaseFeature.name_Feature + " TEXT NOT NULL);";

    /*    String  SQL_create_Player_has_Feature =
                        "CREATE TABLE " + Database.DatabasePlayer_has_Feature.TABLE_NAME
                         + "(" + Database.DatabasePlayer_has_Feature.id_Player + " INTEGER NOT NULL PRIMARY KEY ,"
                         + Database.DatabasePlayer_has_Feature.id_Feature + " INTEGER NOT NULL PRIMARY KEY ,"
                         + Database.DatabasePlayer_has_Feature.count_Feature +  " INTEGER NOT NULL,"
                         + "FOREIGN KEY (" + Database.DatabasePlayer_has_Feature.id_Player + ")REFERENCES "
                         + Database.DatabasePlayer.TABLE_NAME + "(" + Database.DatabasePlayer.id_Player
                         + ") ON DELETE NO ACTION ON UPDATE NO ACTION,"
                         + "FOREIGN KEY (" + Database.DatabasePlayer_has_Feature.id_Feature + ")REFERENCES "
                         + Database.DatabaseFeature.TABLE_NAME + "(" + Database.DatabaseFeature.id_Feature
                         + ") ON DELETE NO ACTION ON UPDATE NO ACTION);";
*/
        db.execSQL(SQL_create_Player);
        db.execSQL(SQL_create_Zvanie);
        db.execSQL(SQL_create_Feature);
     //   db.execSQL(SQL_create_Player_has_Feature);




    }

// при обновлении схемы бд
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // Запишем в журнал

        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE " + Database.DatabasePlayer.TABLE_NAME);
        // Создаём новую таблицу
        onCreate(db);

    }
}
