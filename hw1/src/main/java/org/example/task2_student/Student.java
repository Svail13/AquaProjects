package org.example.task2_student;
/*
Задача "Студент":
Создайте класс Student с полями для хранения имени, номера зачётной книжки и среднего балла.
Реализуйте методы для получения и установки этих полей.
Создайте интерфейс Printable с методом print(), аналогично задаче "Банковский счёт", для вывода информации о студенте.

*/
public class Student implements Printable{

    String name;
    int numberBook;
    double averageScore;

    public void setName(String name){
        this.name = name;
    };

    public String getName(){
        return this.name;
    };

    public void setNumberBook(int numberBook){
        this.numberBook = numberBook;
    };

    public int getNumberBook(){
        return this.numberBook;
    }

    public void setAverageScore(double averageScore){
        this.averageScore=averageScore;
    }

    public double getAverageScore(){
        return this.averageScore;
    }





    @Override
    public void print() {
        System.out.println("Student name: " + this.name);
        System.out.println("Student number book: " + this.numberBook);
        System.out.println("Student average score: " + this.averageScore);
        System.out.println(); //для визуального разделения в консоли
    }
}
