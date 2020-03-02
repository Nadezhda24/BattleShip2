package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

public class ThreeShip extends Ship  implements Serializable {
    private ImageView[] ship = new  ImageView[3];

    public ThreeShip(ImageView ImageView1,ImageView ImageView2, ImageView ImageView3) {

        ship[0]=  ImageView1;
        ship[1]=  ImageView2;
        ship[2]= ImageView3;
    }

    public ImageView GetShip (int i){
        return  ship[i];

    }
}
