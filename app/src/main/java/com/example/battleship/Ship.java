package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;




/* состояния карабля однопалубный, 1 элемент двухпалубного, 2 элемент двухпалубного,
по аналогии с трехпалубным и четырехпалубным, убит, ранен*/



// однопалубный
public class Ship implements Serializable {
        status.ShipType [] ship = new  status.ShipType[1];




    public Ship ( status.ShipType st){
        ship[0]= st;

    }

    public Ship() {
         ship[0] =  status.Ship.ship11;
    }


    public void SetShip ( status.ShipType st){
        ship[0] = st;
    }

    public  status.ShipType GetShip (int i){
        return  ship[i];

    }



}
