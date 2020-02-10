package com.example.battleship;


import android.content.Context;
import android.widget.ImageView;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), фича, бомба, убит

enum status{
     empty,ship, near_ship, checked, feature, bomb, kill
}


public class Field  {

    ImageView ImageView ;
    int id;
    status st;

    public Field(ImageView ImageView, int id){

        this.id = id;
        this.ImageView =  ImageView;
        this.st = status.empty;
    }

    public status GetStatus(){ return st; }
    public ImageView GetImageView(){return ImageView;}
    public  int GetID(){return id;}

    public void SetStatus(status status){ this.st= status; }
    public void SetImageView(ImageView im){this.ImageView = im;}
    public void SetID(int id){this.id = id;}



}
