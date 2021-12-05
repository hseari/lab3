package com.company;

import java.util.regex.*;
import java.util.Scanner;

public class Lab3 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //  Вариант 1 String
        String request = "Введите пароль: ";
        System.out.print(request);

        //  Вариант 2 StringBuilder
        //String request = "Введите пароль: ";
        //StringBuilder req = new StringBuilder(request);
        //System.out.print(req);

        //  Вариант 3 StringBuffer
        //String request = "Введите пароль: ";
        //StringBuffer req = new StringBuffer(request);
        //System.out.print(req);

        String password = scan.nextLine();
        String pattern = "[a-z]+ && [A-Z]+ && \\d+ && _";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);

        while (!m.find()) {      //Пока не будет введен сильный пароль, просим пользователя изменять его:

            boolean validLength = password.length() >= 8;         //Длина 8 и более символов
            boolean hasLower = password.matches(".*[a-z].*");       //Имеет нижний регистр
            boolean hasUpper = password.matches(".*[A-Z].*");       //Имеет верхний регистр
            boolean hasDigit = password.matches(".*\\d.*");       //Имеет цифру
            boolean hasAlien = password.matches(".*[^a-zA-Z0-9 |_].*");  //Не содержит посторонних символов

            if (hasAlien) {
                System.out.println("Он может содержать только буквы английского алфавита, цифры и _.");
                System.out.print("Введите пароль еще раз: ");
                password = scan.next();
            } else if (!validLength) {
                System.out.println("Он должен содержать 8 и более символов.");
                System.out.print("Введите пароль еще раз: ");
                password = scan.next();
            } else if (!hasLower) {
                System.out.println("Должна быть хотя бы одна маленькая буква.");
                System.out.print("Введите пароль еще раз: ");
                password = scan.next();
            } else if (!hasUpper) {
                System.out.println("Должна быть хотя бы одна заглавная буква.");
                System.out.print("Введите пароль еще раз: ");
                password = scan.next();
            } else if (!hasDigit) {
                System.out.println("Должна быть хотя бы 1 цифра.");
                System.out.print("Введите пароль еще раз: ");
                password = scan.next();
            } else break;

        }

        System.out.println("Ваш пароль сильный.");

        scan.close();

    }
}