package com.example.battleship;

import android.widget.ImageView;

public class ThreeShip extends Ship {
    private ImageView[] ship = new  ImageView[3];

    public ThreeShip() {
        ship[0].setImageResource(R.drawable.three1);
        ship[1].setImageResource(R.drawable.three2);
        ship[2].setImageResource(R.drawable.three3);
    }


}
