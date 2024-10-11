package org.example.task1_book;
/*
Задача "Студент":
Создайте класс Student с полями для хранения имени, номера зачётной книжки и среднего балла.
Реализуйте методы для получения и установки этих полей.
Создайте интерфейс Printable с методом print(), аналогично задаче "Банковский счёт", для вывода информации о студенте.

*/
public class Book implements Displayable {


    String name;
    String author;
    int year;

    //setter NAME
    public void setName (String name) {
        this.name = name;
    };
    //getter NAME
    public String getName(){
        return this.name;
    }

    //setter AUTHOR
    public void setAuthor(String author){
        this.author = author;
    };
    //getter AUTHOR
    public String getAuthor(){
        return this.author;
    };

    //setter YEAR
    public void setYear (int year){
        this.year = year;
    };
    //getter YEAR
    public int getYear (){
        return this.year;
    };



    @Override
    public void display() {
        System.out.println(); //для визуального разделения в консоли
        System.out.println("Name of the book: " + this.name);
        System.out.println("Author of the book: " + this.author);
        System.out.println("Year of the book: " + this.year);
        System.out.println(); //для визуального разделения в консоли
    }
}
