package com.example.battleship;

import android.widget.ImageView;

public class TwoShip extends  Ship {

    private ImageView[] ship = new  ImageView[2];

    public TwoShip() {
        super();
        ship[1].setImageResource(R.drawable.fouri2);
    }

    public ImageView GetShip2 (){
        return  ship[1];

    }

}
