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


    public Field[][] NearOneShip (Field[][] field){

        for (int i =0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.field[i][j] = field[i][j];
            }
        }

        for (int i =0; i < 10; i++){
            for(int j=0; j< 10; j++){

if (this.field[i][j].GetStatus() == status.ship){


}

            }

        }


        return this.field;
    }


   /* public Field[][] PlacementRand(Field [][] field, Ship[] ship){

        for (int i =0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        this.field[i][j] = field[i][j];
                    }
                }
        for (int i = 0; i < 10 ; i++){
            this.ship[i] = ship[i];

        }

       int i = 0+(int)(Math.random() * 6);
        int j = 0+(int)(Math.random() * 6);
        // для выбора смещаения по горизонтали i и вертикали j
        int ki = 0+(int)(Math.random() * 1);
        int kj = 0+(int)(Math.random() * 1);

        if (ki == kj && ki == 1) { ki--;}
        else if (ki== kj && ki == 0) {ki++;}

        // размещение четырехпалубного
        for (int k =0; k< 4 ; k++) {
            this.field[i + ki * k][j + kj * k].SetImageView(ship[0].GetShip(k));
            this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
        }


        // размещение трехпалубного
        for (int r =1; r<3; r++) {
            do {
                i = 0 + (int) (Math.random() * 7);
                j = 0 + (int) (Math.random() * 7);
            }
            while ( field[i][j].GetStatus() == status.ship );

            ki = 0 + (int) (Math.random() * 1);
            kj = 0 + (int) (Math.random() * 1);
            if (ki == kj && ki == 1) { ki--; }
            else if (ki == kj && ki == 0) { ki++; }

            for (int k =0; k< 3 ; k++) {
                this.field[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
            }

        }

        // размещение двухпалубного
        for (int r =3; r<6; r++) {
            do {
                i = 0 + (int) (Math.random() * 8);
                j = 0 + (int) (Math.random() * 8);
            }
            while ( field[i][j].GetStatus() == status.ship);

            ki = 0 + (int) (Math.random() * 1);
            kj = 0 + (int) (Math.random() * 1);
            if (ki == kj && ki == 1) {ki--; }
            else if (ki == kj && ki == 0) { ki++; }

            for (int k =0; k< 2 ; k++) {
                this.field[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                this.field[i + ki * k][j + kj * k].SetStatus(status.ship);
            }

        }


        // размещение однопалубного
        for (int r =6; r<10; r++) {
            do {
               i = 0 + (int) (Math.random() * 9);
               j = 0 + (int) (Math.random() * 9);
            }
            while ( field[i][j].GetStatus() == status.ship);

            this.field[i][j].SetImageView(ship[r].GetShip(0));
            this.field[i][j].SetStatus(status.ship);
        }



return  this.field;
   }

*/




}
