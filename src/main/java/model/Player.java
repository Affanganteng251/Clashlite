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
        this.gold = 0;
        this.elixir = 0;
        this.village = new Village();
    }

    public Village getVillage() {
        return village;
    }

    // Getter
    public int getGold() {
        return gold;
    }

    public int getElixir() {
        return elixir;
    }

    // Tambah gold
    public void addGold(int amount) {
        this.gold += amount;
    }

    // Tambah elixir
    public void addElixir(int amount) {
        this.elixir += amount;
    }

    // Kurangi elixir
    public void useElixir(int amount) {
        if (this.elixir >= amount) {
            this.elixir -= amount;
        } else {
            System.out.println("Not enough elixir!");
        }
    }

    public void spendElixir(int i) {
        throw new UnsupportedOperationException("troops added"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


