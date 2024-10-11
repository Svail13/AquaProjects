package org.example;

import org.example.task1_book.Book;
import org.example.task2_student.Student;
import org.example.task3_dots.Point;

/*
Создайте класс Point с приватными полями x и y для координат точки на плоскости.
Реализуйте методы для получения (get) и установки (set) этих полей.
Создайте интерфейс Movable с методами moveUp(), moveDown(), moveLeft(), и moveRight() для изменения положения точки
 */
public class Main {
    public static void main(String[] args) {

//task1
        Book Book1 = new Book();
        Book1.setName("Harry Potter and the Philosopher's Stone");
        Book1.setAuthor("J. K. Rowling");
        Book1.setYear(1997);

        System.out.println("Ниже результаты задачи Книга (Task 1):");
        Book1.display();
//task2
        Student student1 = new Student();
        student1.setName("Michail Travolta");
        student1.setNumberBook(131313);
        student1.setAverageScore(8.713);

        System.out.println("Ниже результаты задачи Студенты (Task 2):");
        student1.print();
//task3
        Point point1 = new Point();
        point1.setX(5);
        point1.setY(13);

        System.out.println("Ниже результаты задачи Точки (Task 3):");
        point1.moveLeft();
        point1.moveRight();
        point1.moveUp();
        point1.moveDown();




    }


}