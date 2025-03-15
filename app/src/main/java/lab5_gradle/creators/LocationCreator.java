package lab5_gradle.creators;

import lab5_gradle.exceptions.EmptyValueException;
import lab5_gradle.exceptions.IncorrectIntegerValueException;
import lab5_gradle.exceptions.NullValueException;
import lab5_gradle.locations.Location;
import lab5_gradle.utility.ConsoleHandler;

public class LocationCreator {
    private ConsoleHandler consoleManager = new ConsoleHandler();
    private Location location;

    public LocationCreator() {
        location = new Location();
    }

    public void askHeight() {
        boolean passFlag = false;
        String currentInput = null;
        do {
            try {
                System.out.print("Введите высоту в см (рост не может быть пустой)\n-> ");
                currentInput = this.consoleManager.getInputString();
                if (currentInput.isEmpty()) {
                    throw new EmptyValueException();
                }
                if (currentInput.matches("^-?\\d+(\\.\\d+)?$") == false) {
                    throw new IncorrectIntegerValueException();
                }
                this.location.setY(Double.parseDouble(currentInput));
                passFlag = true;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectIntegerValueException e) {
                System.out.println(e.getMessage());
            } catch (NullValueException e) {
                System.out.println(e.getMessage());
            }
        } while (false == passFlag);
    }

    public void askDepth() {
        boolean passFlag = false;
        String currentInput = null;
        do {
            try {
                System.out.print("Введите глубину в см (рост не может быть пустой)\n-> ");
                currentInput = this.consoleManager.getInputString();
                if (currentInput.isEmpty()) {
                    throw new EmptyValueException();
                }
                if (currentInput.matches("^-?\\d+(\\.\\d+)?$") == false) {
                    throw new IncorrectIntegerValueException();
                }
                this.location.setZ(Double.parseDouble(currentInput));
                passFlag = true;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectIntegerValueException e) {
                System.out.println(e.getMessage());
            }
        } while (false == passFlag);
    }

    public void askWidth() {
        boolean passFlag = false;
        String currentInput = null;
        do {
            try {
                System.out.print("Введите длину в см (рост не может быть пустой)\n-> ");
                currentInput = this.consoleManager.getInputString();
                if (currentInput.isEmpty()) {
                    throw new EmptyValueException();
                }
                if (currentInput.matches("^\\d+$") == false) {
                    throw new IncorrectIntegerValueException();
                }
                this.location.setX(Integer.parseInt(currentInput));
                passFlag = true;
            } catch (EmptyValueException e) {
                System.out.println(e.getMessage());
            } catch (IncorrectIntegerValueException e) {
                System.out.println(e.getMessage());
            }
        } while (false == passFlag);
    }

    public Location getLocation() {
        return this.location;
    }
}
