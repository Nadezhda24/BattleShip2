package com.example.battleship;


import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), фича, бомба, убит




public class Field implements Serializable {

    int id;
    status st;

    public Field(int id){

        this.id = id;
        this.st =   status.empty;
    }

    public status GetStatus(){ return st; }

    public  int GetID(){return id;}

    public void SetStatus(status status){ this.st= status; }
    public void SetID(int id){this.id = id;}



}
