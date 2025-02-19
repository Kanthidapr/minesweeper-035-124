package com.lab;

import java.util.Scanner;

public class App {
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }

    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Minesweeper!");
        
        System.out.println("Choose a row (1-9): ");
        int rowChoice = scanner.nextInt();
        
        System.out.println("Choose a column (1-9): ");
        int colChoice = scanner.nextInt();

        if (rowChoice < 1 || rowChoice > 9 || colChoice < 1 || colChoice > 9) {
            System.out.println("Invalid input. Please select both a row and a column between 1 and 9.");
            scanner.close();
            return;
        }

        Minesweeper game;
        if (rowChoice % 2 == 0) {
            System.out.println(" ");
            game = initMineField();
        } else {
            System.out.println(" ");
            game = initMineFieldFromFile("minefield/minefield01.txt");
        }

        
        if (game.cells[rowChoice - 1][colChoice - 1] == Minesweeper.IS_SAFE) {
            System.out.println("You're safe.");
        } else {
            System.out.println("Boom!");
        }

        scanner.close();
    }
}
