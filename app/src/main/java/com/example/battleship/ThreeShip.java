package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class ThreeShip extends Ship  implements Serializable {
    private   status.ShipType[] ship = new    status.ShipType[3];

    public ThreeShip() {
        ship[0] =  status.Ship.ship31;
        ship[1] =  status.Ship.ship32;
        ship[2] =  status.Ship.ship33;
    }

    public ThreeShip(  status.ShipType st1,  status.ShipType  st2,   status.ShipType st3) {

        ship[0]=  st1;
        ship[1]=  st2;
        ship[2]=  st3;
    }

    public   status.ShipType GetShip (int i){
        return  ship[i];

    }
}
