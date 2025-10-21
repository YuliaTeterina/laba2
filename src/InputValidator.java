import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getValidInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // очистка буфера
                return value;
            } catch (Exception e) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine(); // очистка неверного ввода
            }
        }
    }

    public int getValidIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = getValidInt(prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Ошибка! Число должно быть от " + min + " до " + max + ".");
        }
    }

    public double getValidDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); // очистка буфера
                return value;
            } catch (Exception e) {
                System.out.println("Ошибка! Введите число.");
                scanner.nextLine(); // очистка неверного ввода
            }
        }
    }

    public String getNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Ошибка! Ввод не может быть пустым.");
        }
    }

    public int getValidChoice() {
        return getValidIntInRange("Выберите задачу (0-6): ", 0, 6);
    }
}