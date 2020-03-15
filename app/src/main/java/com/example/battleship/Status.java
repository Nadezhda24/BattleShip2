package com.example.battleship;


/*enum status{
    empty, ship, near_ship, checked, feature, bomb, kill
}

enum ships {

    ship11, ship21, ship22, ship31, ship32, ship33, ship41, ship42, ship43, ship44
}*/


enum status {

    empty, ship, near_ship, checked, feature, bomb, kill;

        public  interface ShipType{};
        private ShipType MyShipType;

        status (ShipType s) {
            this.MyShipType = s;
        }
        status(){};
        public  enum Ship implements ShipType{

            ship11, ship21, ship22, ship31, ship32, ship33, ship41, ship42, ship43, ship44;
        }
}
