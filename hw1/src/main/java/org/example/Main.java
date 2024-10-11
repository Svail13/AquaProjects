package org.example;

import org.example.task1_book.Book;
import org.example.task2_student.Student;
import org.example.task3_dots.Point;
import org.example.task4_clock.Clock;

/*
Создайте класс Clock с полями для хранения часов, минут и секунд.
Реализуйте методы для установки и получения времени, а также метод tick() для увеличения времени на одну секунду.
Создайте интерфейс Readable с методом readTime(), который выводит текущее время часов.
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
//task4
        Clock time1 = new Clock();
        time1.setHours(13);
        time1.setMinutes(13);
        time1.setSeconds(13);
        time1.tick();
        System.out.println("Ниже результаты задачи Часы (Task 4):");
        time1.readTime();


    }


}