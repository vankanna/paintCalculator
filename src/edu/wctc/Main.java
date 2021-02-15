package edu.wctc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Main {

    final static Scanner sIn = new Scanner(System.in); //user input
    static PaintCalculator pc = new PaintCalculator();
    static boolean run = true;

    public static void main(String[] args) {
        while(run) {
            printMenu();
            int userChoice = Integer.parseInt(sIn.nextLine());

            switch (userChoice) {
                case 1 -> createRoom();
                case 2 -> System.out.println(pc.toString());
                case 3 -> readFile();
                case 4 -> writeFile();
                case 5 -> run = false;
                default -> System.out.println("please type a number that correlates to the menu options");
            }
        }
    }

    private static void printMenu() {
        System.out.println(" 1 - Add room");
        System.out.println(" 2 - View room");
        System.out.println(" 3 - Read rooms from file");
        System.out.println(" 4 - Write rooms to file");
        System.out.println(" 5 - Exit program");
    }

    private static double promptForDimension(String dimensionName) {
        System.out.println("Please enter " + dimensionName + ":");
        return Double.parseDouble(sIn.nextLine());

    }

    private static void createRoom() {
        double l = promptForDimension("length");
        double w = promptForDimension("width");
        double h = promptForDimension("height");
        pc.addRoom(l, w, h);
    }

    private static void readFile() {
        try {
            FileInputStream file = new FileInputStream(new File("paintCalculator.txt"));
            ObjectInputStream input = new ObjectInputStream(file);
            pc = (PaintCalculator) input.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void writeFile() {
        try {
            FileOutputStream file = new FileOutputStream(new File("paintCalculator.txt"));
            ObjectOutputStream output = new ObjectOutputStream(file);
            output.writeObject(pc);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }
}
