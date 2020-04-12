package com.example.battleship;


import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), фича, бомба, убит


enum orientation{
    horizontally, vertically
}


public class Field implements Serializable {

    int id;
    status st;
    ships_st status_ship ;
    orientation st_orientation;


    public Field(int id){

        this.id = id;
        this.st =   status.empty;
        this.status_ship = ships_st.empty;
        this.st_orientation = orientation.horizontally;
    }

    public status GetStatus(){ return st; }

    public  ships_st GetStatus_Ship(){return status_ship;}

    public void SetStatus(status status){ this.st= status; }
    public void SetStatus_Ship(ships_st status_ship){this.status_ship = status_ship;}

    public void SetStatusOrientation(orientation st_orientation){ this.st_orientation= st_orientation; }
    public orientation GetStatusOrientation(){ return st_orientation; }



}
