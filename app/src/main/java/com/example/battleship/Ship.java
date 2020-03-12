package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

import static com.example.battleship.status.*;


/* состояния карабля однопалубный, 1 элемент двухпалубного, 2 элемент двухпалубного,
по аналогии с трехпалубным и четырехпалубным, убит, ранен*/

enum ships{
    ship11, ship21, ship22, ship31, ship32, ship33, ship41, ship42, ship43, ship44

}


// однопалубный
public class Ship implements Serializable {
        ships [] ship = new ships[1];




    public Ship (ships st){
        ship[0]= st;

    }

    public Ship() {
        ship[0] =  com.example.battleship.ships.ship11;
    }


    public void SetShip (ships st){
        ship[0] = st;
    }

    public ships GetShip (int i){
        return  ship[i];

    }



}
