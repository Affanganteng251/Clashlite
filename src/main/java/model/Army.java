/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Troop> troops;
    private int maxCapacity; // kapasitas saat ini

    public Army() {
        this.troops = new ArrayList<>();
        this.maxCapacity = 0; // akan diset oleh Village sesuai ArmyCamp
    }

    // tambahkan troop (kembalikan false jika penuh)
    public boolean addTroop(Troop t) {
        if (troops.size() >= maxCapacity) {
            return false;
        }
        troops.add(t);
        return true;
    }

    // tingkatkan kapasitas (dipanggil saat upgrade ArmyCamp)
    public void increaseCapacity(int amount) {
        this.maxCapacity += amount;
        if (this.maxCapacity < 0) this.maxCapacity = 0;
    }

    public void setCapacity(int capacity) {
        this.maxCapacity = Math.max(0, capacity);
    }

    public int getTotalTroops() {
        return troops.size();
    }

    public int getCapacity() {
        return maxCapacity;
    }

    public List<Troop> getTroops() {
        return troops;
    }

    public void clearTroops() {
        troops.clear();
    }

    @Override
    public String toString() {
        if (troops.isEmpty()) return "No troops (0/" + maxCapacity + ")";
        StringBuilder sb = new StringBuilder();
        for (Troop t : troops) {
            sb.append(t).append(", ");
        }
        // hapus koma terakhir jika perlu
        return sb.toString() + " (" + troops.size() + "/" + maxCapacity + ")";
    }
}