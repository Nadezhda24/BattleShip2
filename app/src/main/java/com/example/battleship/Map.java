package com.example.battleship;

import android.view.View;
import android.widget.ImageView;

public class Map {
    Field[][] map = new Field[10][10];
    Ship[] ship = new Ship [10];

    public  Map (Field [][] field){

        for (int i =0; i < 10; i ++){

            for (int j =0; j < 10; j ++){

                map[i][j] = field[i][j];
            }
         }

        ship [0]= new FourShip();
        ship[1] = new ThreeShip();
        ship[2]= new ThreeShip();

        for (int i=3; i< 6; i++){
            ship[i]= new TwoShip();
        }

        for (int i=6; i< 10; i++){
            ship[i]= new Ship();
        }
    }




    public void PlacementRand(Field [][] field){

        for (int i =0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        map[i][j] = field[i][j];
                    }
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
                     map[i + ki * k][j + kj * k].SetImageView(ship[0].GetShip(k));
                     map[i + ki * k][j + kj * k].SetStatus(status.ship);
                           }


                           // размещение трехпалубного
                for (int r =1; r<3; r++) {
                  do {
                      i = 0 + (int) (Math.random() * 7);
                      j = 0 + (int) (Math.random() * 7);
                  }
                  while (map[i][j].GetStatus() == status.ship );

                  ki = 0 + (int) (Math.random() * 1);
                  kj = 0 + (int) (Math.random() * 1);
                  if (ki == kj && ki == 1) { ki--; }
                  else if (ki == kj && ki == 0) { ki++; }

                 for (int k =0; k< 3 ; k++) {
                     map[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                     map[i + ki * k][j + kj * k].SetStatus(status.ship);
                 }

             }

              // размещение двухпалубного
                for (int r =3; r<6; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 8);
                        j = 0 + (int) (Math.random() * 8);
                    }
                    while (map[i][j].GetStatus() == status.ship);

                    ki = 0 + (int) (Math.random() * 1);
                    kj = 0 + (int) (Math.random() * 1);
                    if (ki == kj && ki == 1) {ki--; }
                    else if (ki == kj && ki == 0) { ki++; }

                    for (int k =0; k< 2 ; k++) {
                        map[i + ki * k][j + kj * k].SetImageView(ship[r].GetShip(k));
                        map[i + ki * k][j + kj * k].SetStatus(status.ship);
                    }

                }

                // размещение однопалубного
                for (int r =6; r<10; r++) {
                    do {
                        i = 0 + (int) (Math.random() * 9);
                        j = 0 + (int) (Math.random() * 9);
                    }
                    while (map[i][j].GetStatus() == status.ship);

                    map[i][j].SetImageView(ship[r].GetShip(0));
                    map[i][j].SetStatus(status.ship);
                }

   }



}
