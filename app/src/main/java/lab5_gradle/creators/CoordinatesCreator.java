package lab5_gradle.creators;

import lab5_gradle.coordinates.Coordinates;
import lab5_gradle.exceptions.CoordinateWrongValueException;
import lab5_gradle.exceptions.EmptyValueException;
import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.utility.ConsoleHandler;

public class CoordinatesCreator {
    private ConsoleHandler consoleManager = new ConsoleHandler();
    private Coordinates coordinates;

    public CoordinatesCreator() {
        this.coordinates = new Coordinates();
    }

    public void askCoordX() {
        boolean passFlag = false;
        String currentInput = null;
        do {
            try {
                System.out.print("Введите координату Х (Х > -852)\n-> ");
                currentInput = this.consoleManager.getInputString().trim();
                if (currentInput.isEmpty()) {
                    throw new EmptyValueException();
                }
                if (currentInput.matches("^-?\\d+$") == false) {
                    throw new IncorrectIntegerValueException();
                }
                this.coordinates.setX(Long.parseLong(currentInput));
                passFlag = true;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectIntegerValueException e) {
                System.out.println(e.getMessage());
            } catch (NullValueException e) {
                System.out.println(e.getMessage());
            } catch (CoordinateWrongValueException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: число слишком большое для данного типа");
            }
        } while (false == passFlag);
    }

    public void askCoordY() {
        boolean passFlag = false;
        String currentInput = null;
        do {
            try {
                System.out.print("Введите координату Y\n-> ");
                currentInput = this.consoleManager.getInputString().trim();
                if (currentInput.isEmpty()) {
                    throw new EmptyValueException();
                }
                if (currentInput.matches("^-?\\d+$") == false) {
                    throw new IncorrectIntegerValueException();
                }
                this.coordinates.setY(Integer.parseInt(currentInput));
                passFlag = true;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectIntegerValueException e) {
                System.out.println(e.getMessage());
            } catch (NullValueException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: число слишком большое для данного типа");
            }
        } while (false == passFlag);
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}
