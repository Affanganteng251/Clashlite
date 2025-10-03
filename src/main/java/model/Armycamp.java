/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Armycamp extends Building {
    public Armycamp() {
        super("Army Camp");
    }

    public int getCapacityBonus() {
        return (level - 1) * 2; // tiap level tambah 2 slot kapasitas
    }
}