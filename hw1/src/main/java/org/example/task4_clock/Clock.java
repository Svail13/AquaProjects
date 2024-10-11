package org.example.task4_clock;
/*
Создайте класс Clock с полями для хранения часов, минут и секунд.
Реализуйте методы для установки и получения времени, а также метод tick() для увеличения времени на одну секунду.
Создайте интерфейс Readable с методом readTime(), который выводит текущее время часов.
 */
public class Clock implements Readable{
    int hours;
    int minutes;
    int seconds;

    public void setHours(int hours){
        this.hours = hours;

    };

    public int getHours(){
        return this.hours;
    }

    public void setMinutes(int minutes){
         this.minutes = minutes;
    }

    public int getMinutes(){
        return this.minutes;
    };

    public void setSeconds(int seconds) {
            this.seconds = seconds;
            };

    public void tick(){
        seconds ++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes =0;
                hours++;
                if (hours == 24) {
                    hours =0;
                }
            }
        }
    };

    public int getSeconds(){
        return this.seconds;
    };



    @Override
    public void readTime() {
        System.out.println("Время увеличенное на 1 сек: " + this.hours +":"+ this.minutes +":"+ this.seconds);
        System.out.println(); //для визуального разделения в консоли
    }


}
