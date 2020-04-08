package com.example.battleship;


import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), фича, бомба, убит




public class Field implements Serializable {

    int id;
    status st;
    ships_st status_ship ;

    public Field(int id){

        this.id = id;
        this.st =   status.empty;
        this.status_ship = ships_st.empty;
    }

    public status GetStatus(){ return st; }

    public  ships_st GetStatus_Ship(){return status_ship;}

    public void SetStatus(status status){ this.st= status; }
    public void SetStatus_Ship(ships_st status_ship){this.status_ship = status_ship;}



}
