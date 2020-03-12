package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class ThreeShip extends Ship  implements Serializable {
    private ships[] ship = new  ships[3];

    public ThreeShip() {
        ship[0] =  com.example.battleship.ships.ship31;
        ship[1] =  com.example.battleship.ships.ship32;
        ship[2] =  com.example.battleship.ships.ship33;
    }

    public ThreeShip(ships st1,ships st2, ships st3) {

        ship[0]=  st1;
        ship[1]=  st2;
        ship[2]=  st3;
    }

    public ships GetShip (int i){
        return  ship[i];

    }
}
