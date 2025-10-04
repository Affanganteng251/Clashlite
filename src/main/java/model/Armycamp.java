/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Armycamp extends Building {
    public Armycamp() {
        super("Army Camp", 1);
    }

    // upgrade dengan cek batas TownHall (implementasi contoh)
    public void upgrade(int townHallLevel) {
        int max = getMaxLevel(townHallLevel);
        if (this.level >= max) {
            System.out.println("Army Camp cannot be upgraded further at TownHall level " + townHallLevel);
            return;
        }
        this.level++;
        System.out.println("Army Camp upgraded to level " + this.level);
    }

    private int getMaxLevel(int townHallLevel) {
        switch (townHallLevel) {
            case 1: return 2;
            case 2: return 4;
            case 3: return 6;
            default: return 10;
        }
    }

    // kapasitas yang disediakan oleh ArmyCamp (misal 5 slot per level)
    public int getCapacity() {
        return 5 * this.level;
    }
}
