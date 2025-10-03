/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Village {
    private Player owner;
    private ArrayList<Building> buildings;
    private Army army;

    public Village(Player owner) {
        this.owner = owner;
        this.buildings = new ArrayList<>();
        this.army = new Army();
        buildings.add(new TownHall());
        buildings.add(new Barracks());
        buildings.add(new Armycamp());
    }

    public Player getOwner() { return owner; }
    public ArrayList<Building> getBuildings() { return buildings; }
    public Army getArmy() { return army; }

    public void showStatus() {
        System.out.println("=== Village of " + owner.getName() + " ===");
        for (Building b : buildings) {
            System.out.println("- " + b);
        }
        System.out.println("Army: " + army);
        System.out.println("Gold: " + owner.getGold() + " | Elixir: " + owner.getElixir());
    }
}

