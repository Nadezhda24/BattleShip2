package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class FourShip extends Ship implements Serializable {
    private ImageView[] ship = new  ImageView[4];

    public FourShip(ImageView ImageView1,ImageView ImageView2, ImageView ImageView3,ImageView ImageView4 ) {

        ship[0]=  ImageView1;
        ship[1]=  ImageView2;
        ship[2]= ImageView3;
        ship[3]= ImageView4;
    }


    public ImageView GetShip (int i){
        return  ship[i];

    }


}
