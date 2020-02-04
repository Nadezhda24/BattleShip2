package com.example.battleship;

import android.widget.ImageView;

public class FourShip extends Ship  {
    private ImageView[] ship = new  ImageView[3];

    public FourShip() {
        super();
        ship[1].setImageResource(R.drawable.fouri2);
        ship[2].setImageResource(R.drawable.fouri3);
        ship[3].setImageResource(R.drawable.fouri4);
    }

    public ImageView GetShip2 (){
        return  ship[1];

    }

    public ImageView GetShip3 (){
        return  ship[2];

    }
    public ImageView GetShip4 (){
        return  ship[3];

    }



}
