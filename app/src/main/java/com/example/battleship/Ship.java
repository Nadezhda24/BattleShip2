package com.example.battleship;

import android.widget.ImageView;

import java.io.Serializable;

/* состояния карабля однопалубный, 1 элемент двухпалубного, 2 элемент двухпалубного,
по аналогии с трехпалубным и четырехпалубным, убит, ранен*/



// однопалубный
public class Ship implements Serializable {
        ImageView [] ship = new ImageView[1];


    public Ship (ImageView ImageView){
        ship[0]= ImageView;

    }

    public Ship() {
    }


    public void SetShip (ImageView ImageView){
        ship[0] = ImageView;
    }

    public ImageView GetShip (int i){
        return  ship[i];

    }



}
