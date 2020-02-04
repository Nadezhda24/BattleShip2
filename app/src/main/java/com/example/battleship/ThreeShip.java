package com.example.battleship;

import android.widget.ImageView;

public class ThreeShip extends Ship {
    private ImageView[] ship = new  ImageView[3];

    public ThreeShip() {
        super();
        ship[1].setImageResource(R.drawable.fouri2);
        ship[2].setImageResource(R.drawable.fouri3);
    }

    public ImageView GetShip2 (){
        return  ship[1];

    }

    public ImageView GetShip3 (){
        return  ship[2];

    }
}
