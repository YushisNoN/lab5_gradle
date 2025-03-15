package lab5_gradle.utility;

import java.util.Scanner;

import lab5_gradle.interfaces.Console;

public class ConsoleHandler implements Console {

    private Scanner inputScanner;

    public ConsoleHandler() {
        this.inputScanner = new Scanner(System.in);
    }

    @Override
    public String getInputString() {
        return this.inputScanner.nextLine();
    }

    public Scanner getInputStream() {
        return this.inputScanner;
    }

    @Override
    public void printString(String outputString) {
        System.out.print(outputString);
    }

    @Override
    public String toString() {
        return "Console";
    }

    @Override
    public void printStringln(String outputString) {
        System.out.println(outputString);
    }
}
