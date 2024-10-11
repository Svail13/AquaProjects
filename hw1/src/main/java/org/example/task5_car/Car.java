package org.example.task5_car;

public class Car implements Drivable{
    String producer;
    String model;
    int year;

    public void setProducer(String producer) {
        this.producer = producer;
    };

    public String getProducer() {
        return this.producer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    @Override
    public void start() {
        System.out.println("Движение начал автомобиль: " + this.producer +" "+ this.model + " " + this.year + "г.в.");
    }

    @Override
    public void stop() {
        System.out.println("Остановился автомобиль: " + this.producer +" "+ this.model + " " + this.year + "г.в.");

    }

    @Override
    public void drive(int distance) {
        System.out.println("Дистанция пройденна автомобилем: " + this.producer +" "+ this.model + " " + this.year + "г.в. = " + distance + "км");

    }
}
