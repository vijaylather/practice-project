package org.example.design.patterns.observer;

public class TvDisplay implements Observer{
    private String weather;
    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    public void display() {
        System.out.println("Tv Display: " + weather);
    }
}
