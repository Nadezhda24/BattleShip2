package com.example.battleship;

import android.widget.ImageView;

public class TwoShip extends  Ship {

    private ImageView[] ship = new  ImageView[2];

    public TwoShip() {
        ship[0].setImageResource(R.drawable.two1);
        ship[1].setImageResource(R.drawable.two2);
    }



}
