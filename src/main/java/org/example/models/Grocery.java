package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;
        do {
            System.out.println("0: quit, 1: add items, 2: remove items");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz:");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz:");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
            }
        } while (choice != 0);
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}