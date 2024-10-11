package org.example.task3_dots;
/*
Создайте класс Point с приватными полями x и y для координат точки на плоскости.
Реализуйте методы для получения (get) и установки (set) этих полей.
Создайте интерфейс Movable с методами moveUp(), moveDown(), moveLeft(), и moveRight() для изменения положения точки
 */
public class Point implements Movable {
    private int x;
    private int y;

    public void setX(int x){
        this.x = x;
    };
    public int getX(){
        return this.x;
    };

    public void setY(int y){
        this.y = y;
    };

    public int getY(){
        return this.y;
    }




    @Override


    public void moveLeft() {
        System.out.println(); //для визуального разделения в консоли
        System.out.println("Двигаем точку влево на: " + this.x);

    }

    public void moveRight() {

        System.out.println("Двигаем точку вправо на: " + this.x);

    }

    public void moveUp() {

        System.out.println("Двигаем точку вверх на: " + this.y);

    }

    public void moveDown() {
        System.out.println("Двигаем точку вниз на: " + this.y);
        System.out.println(); //для визуального разделения в консоли

    }
}
