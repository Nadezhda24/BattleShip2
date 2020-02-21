package com.example.battleship;

import android.widget.ImageView;

public class Map {
    Field[][] field = new Field[10][10];
    Ship[] ship = new Ship[10];

    public  Map (Field[][] field, Ship [] ship){

        for (int i =0; i < 10; i ++){

            for (int j =0; j < 10; j ++){
                this.field[i][j] = field[i][j];
            }
        }

        for (int i=0; i< 10; i++ ){
            this.ship[i] = ship[i];
        }
    }


    public Field[][] NearOneShip (Field[][] field, int i, int j){


        try {
            if (i != 10 || j != 10) {

                if (this.field[i + 1][j + 1].GetStatus() != status.ship)
                    this.field[i + 1][j + 1].SetStatus(status.near_ship);
            }
            if (i != 10) {
                if (this.field[i + 1][j + 1].GetStatus() != status.ship)
                    this.field[i + 1][j].SetStatus(status.near_ship);
            }
            if (i != 10 || j != 0) {
                if (this.field[i + 1][j - 1].GetStatus() != status.ship)
                    this.field[i + 1][j - 1].SetStatus(status.near_ship);
            }
            if (j != 10) {
                if (this.field[i][j + 1].GetStatus() != status.ship)
                    this.field[i][j + 1].SetStatus(status.near_ship);
            }
            if (j != 0) {
                if (this.field[i][j - 1].GetStatus() != status.ship)
                    this.field[i][j - 1].SetStatus(status.near_ship);
            }
            if (i != 0 || j != 10) {
                if (this.field[i - 1][j + 1].GetStatus() != status.ship)
                    this.field[i - 1][j + 1].SetStatus(status.near_ship);
            }
            if (i != 0) {
                if (this.field[i - 1][j].GetStatus() != status.ship)
                    this.field[i - 1][j].SetStatus(status.near_ship);
            }
            if (i != 0 || j != 0) {
                if (this.field[i - 1][j - 1].GetStatus() != status.ship)
                    this.field[i - 1][j - 1].SetStatus(status.near_ship);
            }

        } catch (Exception e) {

        }

        return this.field;
    }





}
