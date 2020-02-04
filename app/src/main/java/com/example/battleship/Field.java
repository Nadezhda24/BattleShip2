package com.example.battleship;


import android.widget.ImageView;

//Состояния, в которых может находиться клетка поля
//пусто, проверено(мимо), убит/ранен (в зависимости от корабля), фича, бомба

enum status{
     empty,ship, checked,  killed, feature, bomb
}
public class Field {
    android.widget.ImageView ImageView;
    status st;

    public Field(){
        ImageView.setImageResource(R.drawable.fon_18);
        st = com.example.battleship.status.empty;
    }
    public status GetStatus(){ return st; }
    public ImageView GetImageView(){return ImageView;}

    public void SetStatus(status status){ this.st= status; }
    public void SetImageView(ImageView im){this.ImageView = im;}

}
