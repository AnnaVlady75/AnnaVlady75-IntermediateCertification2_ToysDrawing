package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> winningToys;
    public ToyStore() {
        toys = new ArrayList<>();
        winningToys = new ArrayList<>();
    }
    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }
    public void setToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }
    public void play() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            winningToys.add(prizeToy);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }
    public void getPrizeToy() throws IOException {
        if (winningToys.size() > 0) {
            Toy winningToy = winningToys.remove(0);

            FileWriter writer = new FileWriter("ToysWinner.txt", true);
            writer.write(winningToy.getId() + "," + winningToy.getName() + "\n");
            writer.close();
        }
    }
}