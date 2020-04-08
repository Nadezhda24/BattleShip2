package com.example.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static int port = 8888; // Порт, такой же, как у сервера
    static String address = "91.195.136.86"; // Адрес сервера

    public  void  Podcl() {
        try {
            // Преобразуем адрес из строки во внутреннее представление
            InetAddress addr = InetAddress.getByName(address);

            // Создаём сокет и подключаем его к серверу

            Socket socket = null;
            try {
                socket = new Socket(addr, port);
            } catch (IOException e) {
                e.printStackTrace();
            }

           // Потоки ввода/вывода
            // BufferedReader позволяет читать вход по строкам
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // PrintWriter позволяет использовать println
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            // Создаем объект для чтения строк с клавиатуры
          //  Scanner scan = new Scanner(System.in, "UTF-8");

            // Читаем данные с клавиатуры и отправляем серверу
            // Запрашиваем строку
            System.out.print("[Запрос]:");
            String line = "проверка";

            // Отправляем строку серверу
            out.println(line);
            out.flush();    // принудительная отправка

            // Получаем ответ
            line = in.readLine(); // ждем пока сервер отошлет строку текста.
         //   System.out.println("[Ответ]:" + line);

            // Закрываем соединение
            socket.close();
        } catch (IOException x) {
            System.out.println("Ошибка ввода/вывода");
            x.printStackTrace();
        }
    }
}
