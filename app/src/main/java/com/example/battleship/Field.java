package com.example.battleship;


import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), фича, бомба, убит

enum status{
     empty, ship, near_ship, checked, feature, bomb, kill
}

enum ship {
    ship11, ship21, ship22, ship31, ship32, ship33, ship41, ship42, ship43, ship44
    
}

public class Field implements Serializable {

  //  ImageView ImageView ;
    int id;
    status st;

    public Field(ImageView ImageView, int id){

        this.id = id;
      //  this.ImageView =  ImageView;
        this.st = status.empty;
    }

    public status GetStatus(){ return st; }
  //  public ImageView GetImageView(){return ImageView;}
    public  int GetID(){return id;}

    public void SetStatus(status status){ this.st= status; }
 //   public void SetImageView(ImageView im){this.ImageView = im;}
    public void SetID(int id){this.id = id;}



}
