/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Barracks extends Building {
    public Barracks() {
        super("Barracks", 1);
    }

    // upgrade with TownHall level check
    public void upgrade(int townHallLevel) {
        int max = getMaxLevel(townHallLevel);
        if (this.level >= max) {
            System.out.println("Barracks cannot be upgraded further at TownHall level " + townHallLevel);
            return;
        }
        this.level++;
        System.out.println("Barracks upgraded to level " + this.level);
    }

    private int getMaxLevel(int townHallLevel) {
        switch (townHallLevel) {
            case 1: return 2;
            case 2: return 4;
            case 3: return 6;
            default: return 10;
        }
    }

    // troop power bonus used when recruiting
    public int getTroopPowerBonus() {
        return (level - 1) * 10; // setiap level +10 power
    }
}
