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
import model.Village;

import java.util.List;
import java.util.Scanner;
import model.Army;

public class GameService {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.print("Enter your player name: ");
        String name = scanner.nextLine().trim();
        player = new Player(name); // pastikan Player(String) membuat Village dll.

        int choice = 0;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Show Village");
            System.out.println("2. Upgrade Building");
            System.out.println("3. Recruit Troop");
            System.out.println("4. Attack");
            System.out.println("5. Show Army");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Input must be a number.");
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (choice) {
                case 1:
                    player.getVillage().showStatus();
                    break;
                case 2:
                    upgradeBuilding();
                    break;
                case 3:
                    recruitTroop();
                    break;
                case 4:
                    attack();
                    break;
                case 5:
                    showArmy();
                    break;
                case 0:
                    System.out.println("Exiting game...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);
    }

    private void upgradeBuilding() {
        Village village = player.getVillage();
        System.out.println("\n=== Choose Building to Upgrade ===");
        System.out.println("1. TownHall");
        System.out.println("2. Army Camp");
        System.out.println("3. Barracks");
        System.out.print("Choose: ");
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Input must be a number.");
            return;
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // buang newline

        switch (choice) {
            case 1: {
                int thCost = 100 * village.getTownHall().getLevel();
                if (village.getGold() >= thCost) {
                    village.setGold(village.getGold() - thCost);
                    village.getTownHall().upgrade();
                } else {
                    System.out.println("❌ Not enough Gold to upgrade TownHall! Need " + thCost);
                }
            } break;

            case 2: {
                int acCost = 100 * village.getArmyCamp().getLevel();
                if (village.getElixir() >= acCost) {
                    village.setElixir(village.getElixir() - acCost);
                    village.getArmyCamp().upgrade(village.getTownHall().getLevel());
                    // setiap upgrade tambahkan kapasitas (sesuai design)
                    village.getArmy().increaseCapacity(2);
                } else {
                    System.out.println("❌ Not enough Elixir to upgrade Army Camp! Need " + acCost);
                }
            } break;

            case 3: {
                int brCost = 100 * village.getBarracks().getLevel();
                if (village.getElixir() >= brCost) {
                    village.setElixir(village.getElixir() - brCost);
                    village.getBarracks().upgrade(village.getTownHall().getLevel());
                } else {
                    System.out.println("❌ Not enough Elixir to upgrade Barracks! Need " + brCost);
                }
            } break;

            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    private void recruitTroop() {
        if (player == null) {
            System.out.println("Start the game first (player not initialized).");
            return;
        }

        try {
            System.out.print("Enter troop type (Barbarian/Archer): ");
            String type = scanner.nextLine().trim();
            if (!type.equalsIgnoreCase("Barbarian") && !type.equalsIgnoreCase("Archer")) {
                throw new GameException("Unknown troop type!");
            }

            // cari Barracks untuk bonus power
            Barracks barracks = null;
            List<Building> buildings = (List<Building>) player.getVillage().getBuildings();
            for (Building b : buildings) {
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
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    private void attack() {
        if (player == null) {
            System.out.println("Start the game first (player not initialized).");
            return;
        }

        Army army = player.getVillage().getArmy();
        int totalPower = army.getTroops().stream().mapToInt(Troop::getPower).sum();
        System.out.println("You attacked with total power " + totalPower);

        if (totalPower > 100) {
            System.out.println("Victory! You gained 200 gold and 100 elixir.");
            player.addGold(200);
            player.addElixir(100);
        } else {
            System.out.println("Defeat! Train more troops.");
        }

        // After attack, troops are used 
        army.getTroops().clear();
        System.out.println("Your army has returned empty. You must recruit new troops!");
    }

    private void showArmy() {
        if (player == null) {
            System.out.println("Start the game first (player not initialized).");
            return;
        }
        System.out.println("\n=== Current Army ===");
        System.out.println(player.getVillage().getArmy());
    }
}
