package com.example.battleship.data;

import android.provider.BaseColumns;

public class Database {

    public static class DatabasePlayer implements BaseColumns {
        public final static String TABLE_NAME = "Player";

        public final static String id_Player = "id_Player";
        public final static String name_Player = "name_Player";
        public final static String login_Player = "login_Player";
        public final static String password_Player = "password_Player";
        public final static String money_Player = "money_Player";
        public final static String experiment_Player = "experiment_Player";
        public final static String count_game_Player = "count_game_Player";
        public final static String count_win_Player = "count_win_Player";
        public final static String id_zvanie_Player = "id_zvanie_Player";

    }

    public static class DatabaseZvanie implements BaseColumns {

        public final static String TABLE_NAME = "Zvanie";
        public final static String id_Zvanie = "id_Zvanie";
        public final static String name_Zvanie = "name_Zvanie";

    }

    public static class DatabaseFeature implements BaseColumns {

        public final static String TABLE_NAME = "Feature";
        public final static String id_Feature = "id_Feature";
        public final static String name_Feature= "name_Feature";

    }

    public static class DatabasePlayer_has_Feature implements BaseColumns {

        public final static String TABLE_NAME = "Player_has_Feature";
        public final static String id_Player = "id_Player";
        public final static String id_Feature = "id_Feature";
        public final static String count_Feature = "count_Feature";

    }


}
