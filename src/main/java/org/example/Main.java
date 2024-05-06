package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ToyStore store = new ToyStore();

        store.addToy(1, "PlayStation", 100, 20);
        store.addToy(2, "Badminton", 50, 10);
        store.addToy(3, "Doll", 200, 30);
        store.addToy(4, "Machine on the control panel", 150, 50);
        store.addToy(5, "Puzzles", 200, 50);


        store.setToyWeight(5, 50);

        store.play();

        try {
            store.getPrizeToy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Toy prizeToy = null;
        try {
            store.getPrizeToy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (prizeToy != null) {
            System.out.println("Выигрышная игрушка: " + prizeToy.getName());
        }
    }
}