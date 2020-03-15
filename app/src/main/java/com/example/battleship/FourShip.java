package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class FourShip extends Ship implements Serializable {
    private status.ShipType[] ship = new status.ShipType[4];

    public FourShip() {
        ship[0] =  status.Ship.ship41;
        ship[1] =  status.Ship.ship42;
        ship[2] =  status.Ship.ship43;
        ship[3] =  status.Ship.ship44;
    }

    public FourShip(status.ShipType st1,status.ShipType st2, status.ShipType st3, status.ShipType st4 ) {

        ship[0]=  st1;
        ship[1]=  st2;
        ship[2]=  st3;
        ship[3]=  st4;
    }


    public status.ShipType GetShip (int i){
        return  ship[i];

    }


}
