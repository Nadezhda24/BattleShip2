package com.example.battleship;

import java.io.Serializable;

public class Player implements Serializable {
    int id;
    String name;
    String login;
    String password;
    int money;
    int experiment;
    int count_game;
    String zvanie;
    int count_feature;
    int count_win;
    Feature [] feature = new Feature[count_feature];



    public Player(){
        this.id = 0;
        this.name = "Игрок";
        this.login = "Игрок1";
        this.password = "12345";
        this.money =0;
        this.experiment=0;
        this.count_game=0;
        this.count_win =0;
        this.zvanie="матрос";
        int count_feature=4;
        Feature [] feature = new Feature[count_feature];
    }

    public Player(int id,
                  String name,
                  String login,
                  String password, String confirm_password){

         this();
       // if (password == confirm_password) {
            this.id = id;
            this.name = name;
            this.login = login;
            this.password = password;
      //  }

    }

    public void Setid(int id){this.id = id;}
    public void Setname(String name){this.name= name;}
    public void Setlogin(String login){this.login= login;}
    public void Setpassword(String password){this.password = password ;}
    public void Setmoney(int money){this.money= money;}
    public void Setexperiment(int experiment){this.experiment = experiment;}
    public void Setcount_game(int count_game){this.count_game= count_game;}
    public void Setcount_win(int count_win){this.count_win= count_win;}
    public void Setzvanie(String zvanie){this.zvanie= zvanie;}

   public int Getid(){return  id;}
   public String Getname(){return name;}
   public String Getlogin(){return login;}
   public String Getpassword(){return password;}
   public int Getmoney(){return money;}
   public int Getexperiment(){return experiment;}
   public int Getcount_game(){return count_game;}
    public int Getcount_win(){return count_win;}
   public String Getzvanie(){return zvanie;}




}
