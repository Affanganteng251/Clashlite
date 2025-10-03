/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

import service.GameService;

public class Main {
    public static void main(String[] args) {
        GameService game = new GameService();
        game.start();
    }
}
