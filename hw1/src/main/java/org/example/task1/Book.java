package org.example.task1;
/*
Задача "Книга":
Создайте класс Book с полями для хранения названия, автора и года издания.
Реализуйте методы для получения и установки этих полей.
Создайте интерфейс Displayable с методом display(), который реализуется в классе Book для отображения информации о книге.
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
        System.out.println("Name of the book: " + this.name);
        System.out.println("Author of the book: " + this.author);
        System.out.println("Year of the book: " + this.year);
    }
}
