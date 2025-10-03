/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Player {
    private String name;
    private int gold;
    private int elixir;
    private Village village;

    public Player(String name) {
        this.name = name;
        this.gold = 1000;
        this.elixir = 500;
        this.village = new Village(this);
    }

    public String getName() { return name; }
    public int getGold() { return gold; }
    public int getElixir() { return elixir; }
    public Village getVillage() { return village; }

    public void addGold(int amount) { this.gold += amount; }
    public void addElixir(int amount) { this.elixir += amount; }
    public void spendGold(int amount) { this.gold -= amount; }
    public void spendElixir(int amount) { this.elixir -= amount; }
}
