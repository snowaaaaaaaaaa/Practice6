package com.mycompany.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Menu {
    private final ArrayList<ConsoleCommand> commands;
    private final Stack<ConsoleCommand> commandHistory;

    private static Menu instance;

    private Menu() {
        commands = new ArrayList<>();
        commandHistory = new Stack<>();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void addCommand(ConsoleCommand command) {
        commands.add(command);
    }

    public void executeCommand(int choice) {
        boolean commandFound = false;
        for (ConsoleCommand command : commands) {
            if (command.getKey() == choice) {
                command.execute();
                commandHistory.push(command); 
                commandFound = true;
                break;
            }
        }
        if (!commandFound) {
            System.out.println("Invalid command.");
        }
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            ConsoleCommand lastCommand = commandHistory.pop(); 
            lastCommand.undo(); 
        } else {
            System.out.println("No commands to undo.");
        }
    }

   public void executeLastCommand() {
    if (!commandHistory.isEmpty()) {
        ConsoleCommand lastCommand = commandHistory.pop();
        lastCommand.execute();
        if (lastCommand instanceof MinCommand) {
            MinCommand minMaxCommand = (MinCommand) lastCommand;
            double min = minMaxCommand.getMin();
            double max = minMaxCommand.getMax();
            int itemsFound = minMaxCommand.getItemsFound();
            double average = minMaxCommand.getAverage();
            String result = minMaxCommand.getResult();
            System.out.println("MinMax: " + min + ", " + max);
            System.out.println("Item # found: " + itemsFound);
            System.out.println("Average: " + average);
            System.out.println("Result: " + result);
        } else if (lastCommand instanceof MaxCommand) {
            MaxCommand maxCommand = (MaxCommand) lastCommand;
        } else if (lastCommand instanceof AvgCommand) {
            AvgCommand avgCommand = (AvgCommand) lastCommand;
        } else {
            System.out.println("Unknown command type.");
        }
    } else {
        System.out.println("No commands to execute.");
    }
}

    public void displayMenu() {
        System.out.println("Choose an action:");
        System.out.println(" 'v'iew, 'g'enerate, 's'ave, 'r'estore, 'c'hange, 'u'ndo, 'e'xecute, 'q'uit");
    }
}
