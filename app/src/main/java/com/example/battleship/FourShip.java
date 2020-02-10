package com.example.battleship;

import android.widget.ImageView;

public class FourShip extends Ship  {
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
