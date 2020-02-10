package com.example.battleship;

import android.widget.ImageView;


public class TwoShip extends  Ship {
    private ImageView[] ship = new  ImageView[2];
    private int[] x = new int[2];
    private int[] y = new int[2];

    public TwoShip(ImageView ImageView1,ImageView ImageView2) {
        ship[0]=  ImageView1;
        ship[1]=  ImageView2;

    }



    public ImageView GetShip (int i){
        return  ship[i];

    }

}
