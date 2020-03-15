package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;


public class TwoShip extends  Ship  implements Serializable {
    private status.ShipType [] ship = new  status.ShipType[2];

    public TwoShip() {
        ship[0] =  status.Ship.ship21;
        ship[1] =  status.Ship.ship22;
    }


    public TwoShip(status.ShipType st1,status.ShipType st2) {
        ship[0]=  st1;
        ship[1]=  st2;

    }


    public  status.ShipType GetShip (int i){
        return  ship[i];

    }


}
