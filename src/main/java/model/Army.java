/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Army {
    private ArrayList<Troop> troops;
    private int capacity;   
    private int maxCapacity;

    public Army() {
        this.troops = new ArrayList<>();
        this.maxCapacity = 5; 
    }

    public boolean addTroop(Troop t) {
        if (troops.size() >= maxCapacity) {
            return false; 
        }
        troops.add(t);
        return true;
    }

    public void increaseCapacity(int amount) {
        this.maxCapacity += amount;
    }

    public ArrayList<Troop> getTroops() { return troops; }

    @Override
    public String toString() {
        if (troops.isEmpty()) return "No troops";
        StringBuilder sb = new StringBuilder();
        for (Troop t : troops) {
            sb.append(t).append(", ");
        }
        return sb.toString() + "(Capacity: " + troops.size() + "/" + maxCapacity + ")";
    }
}