package com.singed.annotation.beans;

/**
 * @Author : Singed
 * @Date : 2021/9/7 22:52
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
