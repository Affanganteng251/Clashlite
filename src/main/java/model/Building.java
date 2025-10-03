/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Building {
    public String name;
    public int level;

    public Building(String name) {
        this.name = name;
        this.level = 1;
    }

    public void upgrade() {
        this.level++;
    }

    @Override
    public String toString() {
        return name + " (Level " + level + ")";
    }
}
