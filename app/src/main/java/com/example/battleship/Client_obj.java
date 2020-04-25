package com.example.battleship;

import java.io.*;
import java.net.Socket;

public class Client_obj {
    final Socket s;  // это будет сокет для сервера
    final BufferedReader socketReader; // буферизированный читатель с сервера
    final BufferedWriter socketWriter; // буферизированный писатель на сервер
    final BufferedReader userInput; // буферизированный читатель пользовательского ввода с консоли
    String host = "192.168.0.104";
    int port = 45000;
    static String ansServer;


    public Client_obj() throws IOException {

        s = new Socket(host, port); // создаем сокет
        // создаем читателя и писателя в сокет с дефолной кодировкой UTF-8
        socketReader = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
        socketWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
        // создаем читателя с консоли (от пользователя)
        userInput = new BufferedReader(new InputStreamReader(System.in));
        new Thread(new Receiver()).start();// создаем и запускаем нить асинхронного чтения из сокета
    }

    /**
     * метод, где происходит главный цикл чтения сообщений с консоли и отправки на сервер
     * @return
     */
    public void run(  byte[] byteArray ) {
        String   userString = new String(byteArray);

            if (userString == null || userString.length() == 0 || s.isClosed()) {
                close(); // ...закрываем коннект.

            } else { //...иначе...
                try {
                    socketWriter.write(userString); //пишем строку пользователя
                    socketWriter.write("\n"); //добавляем "новою строку", дабы readLine() сервера сработал
                    socketWriter.flush(); // отправляем
                } catch (IOException e) {
                    close(); // в любой ошибке - закрываем.
                }
            }


    }

    /**
     * метод закрывает коннект и выходит из
     * программы (это единственный  выход прервать работу BufferedReader.readLine(), на ожидании пользователя)
     */
    public synchronized void close() {//метод синхронизирован, чтобы исключить двойное закрытие.
        if (!s.isClosed()) { // проверяем, что сокет не закрыт...
            try {
                s.close(); // закрываем...
                System.exit(0); // выходим!
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }



    /**
     * Вложенный приватный класс асинхронного чтения
     */
    private class Receiver implements Runnable{
        /**
         * run() вызовется после запуска нити из конструктора клиента чата.
         */
        public void run() {
            while (!s.isClosed()) { //сходу проверяем коннект.
                String line = null;
                try {
                    line = socketReader.readLine(); // пробуем прочесть
                } catch (IOException e) { // если в момент чтения ошибка, то...
                    // проверим, что это не банальное штатное закрытие сокета сервером
                    if ("Socket closed".equals(e.getMessage())) {
                        break;
                    }
                    System.out.println("Connection lost"); // а сюда мы попадем в случае ошибок сети.
                    close(); // ну и закрываем сокет (кстати, вызвается метод класса ChatClient, есть доступ)
                }
                if (line == null) {  // строка будет null если сервер прикрыл коннект по своей инициативе, сеть работает
                    System.out.println("Server has closed connection");
                    close(); // ...закрываемся
                } else { // иначе печатаем то, что прислал сервер.
                    ansServer = line;
                }
            }
        }
    }
}

