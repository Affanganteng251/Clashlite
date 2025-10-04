/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class TownHall extends Building {
    public TownHall() {
        super("TownHall", 1);
    }

    // keep simple: TownHall upgrades without external limit
    @Override
    public void upgrade() {
        super.upgrade();
        System.out.println("TownHall upgraded to level " + getLevel());
    }
}
