package com.example.battleship;

import android.widget.ImageView;

public class FourShip extends Ship  {
    private ImageView[] ship = new  ImageView[3];

    public FourShip() {
        ship[0].setImageResource(R.drawable.fouri1);
        ship[1].setImageResource(R.drawable.fouri2);
        ship[2].setImageResource(R.drawable.fouri3);
        ship[3].setImageResource(R.drawable.fouri4);
    }





}
