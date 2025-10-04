/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;
import java.util.List;

public class Village {
    private int gold;
    private int elixir;
    private TownHall townHall;
    private Barracks barracks;
    private Armycamp armyCamp;   // pastikan penamaan sesuai
    private Army army;

    public Village() {
        this.gold = 1000;
        this.elixir = 500;
        this.townHall = new TownHall();
        this.barracks = new Barracks();
        this.armyCamp = new Armycamp();    // gunakan ArmyCamp
        this.army = new Army();

        // sinkronkan kapasitas army dengan armyCamp level awal
        this.army.setCapacity(this.armyCamp.getCapacity());
    }

    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }

    public int getElixir() { return elixir; }
    public void setElixir(int elixir) { this.elixir = elixir; }

    public TownHall getTownHall() { return townHall; }
    public Barracks getBarracks() { return barracks; }
    public Armycamp getArmyCamp() { return armyCamp; } // kembalikan ArmyCamp
    public Army getArmy() { return army; }

    public List<Building> getBuildings() {
        return Arrays.asList(townHall, barracks, armyCamp);
    }

    public void showStatus() {
        System.out.println("Gold: " + gold + " | Elixir: " + elixir);
        System.out.println(townHall);
        System.out.println(barracks);
        System.out.println(armyCamp);
        System.out.println(army);
    }
}
