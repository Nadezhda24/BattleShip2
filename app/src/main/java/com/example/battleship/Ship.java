package com.example.battleship;

import android.widget.ImageView;

// однопалубный
public class Ship {
    private ImageView [] ship = new  ImageView[1];


    public Ship (){
        ship[0].setImageResource(R.drawable.oneship);

    }

    public ImageView GetShip1 (int i){
        return  ship[i];

    }


}
