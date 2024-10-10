package org.example;

import org.example.task1.Book;

import static org.example.task1.Book.*;

/*
Задача "Книга":
Создайте класс Book с полями для хранения названия, автора и года издания.
Реализуйте методы для получения и установки этих полей.
Создайте интерфейс Displayable с методом display(), который реализуется в классе Book для отображения информации о книге.
 */
public class Main {
    public static void main(String[] args) {

        Book Book1 = new Book();
        Book1.setName("Harry Potter and the Philosopher's Stone");
        Book1.setAuthor("J. K. Rowling");
        Book1.setYear(1997);

        Book1.display();

    }


}