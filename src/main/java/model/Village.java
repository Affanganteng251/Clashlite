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
    private Armycamp armyCamp;
    private Army army;

    public Village() {
        this.gold = 1000;
        this.elixir = 500;
        this.townHall = new TownHall();
        this.barracks = new Barracks();
        this.armyCamp = new Armycamp();
        this.army = new Army();
    }

    // Getter & Setter untuk resource
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }

    public int getElixir() { return elixir; }
    public void setElixir(int elixir) { this.elixir = elixir; }

    // Getter untuk building
    public TownHall getTownHall() { return townHall; }
    public Barracks getBarracks() { return barracks; }
    public Armycamp getArmyCamp() { return armyCamp; }
    public Army getArmy() { return army; }

    // daftar semua bangunan (buat scanning seperti cari Barracks di recruitTroop)
    public List<Building> getBuildings() {
        return Arrays.asList(townHall, barracks, armyCamp);
    }

    // status desa
    public void showStatus() {
        System.out.println("Gold: " + gold + " | Elixir: " + elixir);
        System.out.println(townHall);
        System.out.println(barracks);
        System.out.println(armyCamp);
        System.out.println(army);
    }
}

