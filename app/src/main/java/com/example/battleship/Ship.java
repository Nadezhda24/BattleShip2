package com.example.battleship;

import android.widget.ImageView;

// однопалубный
public class Ship {
    ImageView [] ship = new  ImageView[1];

 public Ship (){

        ship[0].setImageResource(R.drawable.oneship);

    }

    public ImageView GetShip (int i){
        return  ship[i];

    }



}
