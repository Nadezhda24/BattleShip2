package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;


public class TwoShip extends  Ship  implements Serializable {
    private ships [] ship = new  ships[2];

    public TwoShip() {
        ship[0] =  com.example.battleship.ships.ship21;
        ship[1] =  com.example.battleship.ships.ship22;
    }


    public TwoShip(ships st1,ships st2) {
        ship[0]=  st1;
        ship[1]=  st2;

    }



    public ships GetShip (int i){
        return  ship[i];

    }

}
