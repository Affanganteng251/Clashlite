/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Troop {
    private String type;
    private int power;

    public Troop(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public String getType() { return type; }
    public int getPower() { return power; }

    @Override
    public String toString() {
        return type + " (Power: " + power + ")";
    }
}
