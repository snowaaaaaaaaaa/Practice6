package com.mycompany.ex02;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DUCHKA {

    private final View view;
    private final Menu menu;

    public DUCHKA(View view) {
        this.view = view;
        this.menu = Menu.getInstance();
    }

    public void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore, 'c'hange, 'e'xecute: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    view.viewShow();
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 's':
                    System.out.println("Save current.");
                    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("items.bin"))) {
                        os.writeObject(view);
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    view.viewShow();
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    // Add functionality for restoring last saved view
                    break;
                case 'c':
                    System.out.println("Change item: scale factor");
                    System.out.print("Enter scale factor: ");
                    double scaleFactor;
                    try {
                        scaleFactor = Double.parseDouble(in.readLine());
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid scale factor.");
                        break;
                    }

                    List<Item2d> itemsFromView = (List<Item2d>) view.getItems();
                    ArrayList<Item2d> items = new ArrayList<>(itemsFromView);

                    if (!items.isEmpty()) {
                        Item2d item = items.get(0);
                        double newX = item.getX() * scaleFactor;
                        double newY = item.getY() * scaleFactor;
                        item.setXY(newX, newY);
                        view.viewShow();
                    } else {
                        System.out.println("No items to change.");
                    }
                    break;
                case 'e':
                    System.out.println("Execute last command.");
                    menu.executeLastCommand();
                    break;
                default:
                    System.out.println("Wrong command.");
                    break;
            }
        } while (s.charAt(0) != 'q');
    }

    public static void main(String[] args) {
        DUCHKA duchka = new DUCHKA(new ViewResult());
        duchka.menu();
    }
}
