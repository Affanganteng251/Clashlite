/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public abstract class Building {
    protected String name;
    protected int level;

    public Building(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }

    // default upgrade (no townhall limit check)
    public void upgrade() {
        level++;
    }

    @Override
    public String toString() {
        return name + " (Level " + level + ")";
    }
}
