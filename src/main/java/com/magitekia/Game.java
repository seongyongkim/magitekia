package com.magitekia;

import java.util.Scanner;

public class Game {
    static int numRows = 10;
    static int numCols = 10;
    static int minRow = 0;
    static int minCol = 0;
    static int maxRow = numRows - 1;
    static int maxCol = numCols - 1;

    public static void test(String[] args) {
        System.out.println("Gradle GitHub actions 4tw!");
    }

    public static void main(String[] args) {
        char[][] grid = new char[numCols][numRows]; // create a 10xnumRows grid
        int row = minRow;
        int col = minCol;
        initializeGrid(grid); // set the boundaries of the grid
        grid[row][col] = '*'; // set the initial location of the character to the top-left corner

        // game loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGrid(grid);
            System.out.println(row + ", " + col);
            System.out.print("Enter a direction (n/s/e/w): ");
            String direction = scanner.nextLine().toLowerCase();
            switch (direction) {
                case "n":
                    if (row > minRow) {
                        grid[row][col] = ' ';
                        row--;
                        grid[row][col] = '*';
                    }
                    break;
                case "s":
                    if (row < maxRow) {
                        grid[row][col] = ' ';
                        row++;
                        grid[row][col] = '*';
                    }
                    break;
                case "e":
                    if (col < maxRow) {
                        grid[row][col] = ' ';
                        col++;
                        grid[row][col] = '*';
                    }
                    break;
                case "w":
                    if (col > minCol) {
                        grid[row][col] = ' ';
                        col--;
                        grid[row][col] = '*';
                    }
                    break;
                default:
                    System.out.println("Invalid direction.");
                    break;
            }
        }
    }

    private static void initializeGrid(char[][] grid) {
        for (int row = minRow; row <= maxRow; row++) {
            for (int col = minCol; col <= maxCol; col++) {
                    grid[row][col] = ' '; // set all other cells to empty space
            }
        }
    }

    private static void printGrid(char[][] grid) {
        for (int row = minRow-1; row <= maxRow+1; row++) {
            for (int col = minCol-1; col <= maxCol+1; col++) {
                if (row == minRow-1 || row == maxRow+1 || col == minCol-1 || col == maxCol+1) {
                    System.out.print("# "); // set boundary cells to #
                } else {
                    System.out.print(grid[row][col] + " "); // set all other cells to empty space
                }
            }
            System.out.println();
        }
    }
}

