package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class FourShip extends Ship implements Serializable {
    private ships[] ship = new  ships[4];

    public FourShip() {
        ship[0] =  com.example.battleship.ships.ship41;
        ship[1] =  com.example.battleship.ships.ship42;
        ship[2] =  com.example.battleship.ships.ship43;
        ship[3] = com.example.battleship.ships.ship44;
    }

    public FourShip(ships st1,ships st2, ships st3, ships st4 ) {

        ship[0]=  st1;
        ship[1]=  st2;
        ship[2]=  st3;
        ship[3]=  st4;
    }


    public ships GetShip (int i){
        return  ship[i];

    }


}
