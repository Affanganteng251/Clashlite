/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Scanner;

import exception.GameException;
import model.Armycamp;
import model.Barracks;
import model.Building;
import model.Player;
import model.TownHall;
import model.Troop;

public class GameService {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
    System.out.print("Enter your player name: ");
    String name = scanner.nextLine();
    player = new Player(name);

    int choice;
    do {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Show Village");
        System.out.println("2. Upgrade Building");
        System.out.println("3. Recruit Troop");
        System.out.println("4. Attack");
        System.out.println("5. Show Army");   // ✅ Tambahan opsi
        System.out.println("0. Exit");
        System.out.print("Choose: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> player.getVillage().showStatus();
            case 2 -> upgradeBuilding();
            case 3 -> recruitTroop();
            case 4 -> attack();
            case 5 -> showArmy();   // ✅ Tambahan
            case 0 -> System.out.println("Exiting game...");
            default -> System.out.println("Invalid choice!");
        }
    } while (choice != 0);
}


    private void upgradeBuilding() {
    System.out.println("Choose building to upgrade:");
    var buildings = player.getVillage().getBuildings();
    for (int i = 0; i < buildings.size(); i++) {
        System.out.println((i + 1) + ". " + buildings.get(i));
    }
    int idx = scanner.nextInt(); scanner.nextLine();

    if (idx > 0 && idx <= buildings.size()) {
        Building b = buildings.get(idx - 1);

        int cost = 100 * b.level;  

        if (b instanceof TownHall) {
            if (player.getGold() < cost) {
                System.out.println("Not enough gold! Need " + cost + " gold.");
                return;
            }
            player.spendGold(cost);
            b.upgrade();
            System.out.println("Town Hall upgraded to Level " + b.level +
                               " (-" + cost + " Gold)");

        } else if (b instanceof Barracks) {
            if (player.getElixir() < cost) {
                System.out.println("Not enough elixir! Need " + cost + " elixir.");
                return;
            }
            player.spendElixir(cost);
            b.upgrade();
            System.out.println("Barracks upgraded to Level " + b.level +
                               " (-" + cost + " Elixir) → Troops stronger!");

        } else if (b instanceof Armycamp) {
            if (player.getElixir() < cost) {
                System.out.println("Not enough elixir! Need " + cost + " elixir.");
                return;
            }
            player.spendElixir(cost);
            b.upgrade();

            // Tambah kapasitas Army
            player.getVillage().getArmy().increaseCapacity(2);
            System.out.println("Army Camp upgraded to Level " + b.level +
                               " (-" + cost + " Elixir) → Capacity increased!");

        } else {
            b.upgrade();
            System.out.println(b + " upgraded!");
        }
    } else {
        System.out.println("Invalid index.");
    }
}

    private void recruitTroop() {
    try {
        System.out.print("Enter troop type (Barbarian/Archer): ");
        String type = scanner.nextLine();

        if (!type.equalsIgnoreCase("Barbarian") && !type.equalsIgnoreCase("Archer")) {
            throw new GameException("Unknown troop type!");
        }

        // Cari Barracks untuk bonus power
        Barracks barracks = null;
        for (Building b : player.getVillage().getBuildings()) {
            if (b instanceof Barracks) {
                barracks = (Barracks) b;
                break;
            }
        }
        int basePower = type.equalsIgnoreCase("Barbarian") ? 50 : 40;
        int bonus = (barracks != null) ? barracks.getTroopPowerBonus() : 0;

        Troop t = new Troop(type, basePower + bonus);

        boolean added = player.getVillage().getArmy().addTroop(t);
        if (!added) {
            System.out.println("Army Camp is full! Upgrade it to increase capacity.");
            return;
        }

        player.spendElixir(50);
        System.out.println(type + " recruited with power " + t.getPower() + "!");
        System.out.println("Current Army: " + player.getVillage().getArmy());

    } catch (GameException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Something went wrong.");
    }
}

    private void showArmy() {
    System.out.println("\n=== Current Army ===");
    System.out.println(player.getVillage().getArmy());
}


    private void attack() {
    int totalPower = player.getVillage().getArmy().getTroops()
            .stream().mapToInt(Troop::getPower).sum();
    System.out.println("You attacked with total power " + totalPower);

    if (totalPower > 100) {
        System.out.println("Victory! You gained 200 gold and 100 elixir.");
        player.addGold(200);
        player.addElixir(100);
    } else {
        System.out.println("Defeat! Train more troops.");
    }

    player.getVillage().getArmy().getTroops().clear();
    System.out.println("Your army has returned empty. You must recruit new troops!");
}

}