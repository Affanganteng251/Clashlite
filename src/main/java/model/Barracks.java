/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Barracks extends Building {
    public Barracks() {
        super("Barracks");
    }

    public int getTroopPowerBonus() {
        return (level - 1) * 10; // +10 power per level upgrade
    }
}