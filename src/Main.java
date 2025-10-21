import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputValidator validator = new InputValidator(scanner);

        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("1 - Задача 1.3: Имена");
            System.out.println("2 - Задача 2.2: Человек с именем");
            System.out.println("3 - Задача 2.3: Человек с родителем");
            System.out.println("4 - Задача 3.2: Ломаная");
            System.out.println("5 - Задача 4.9: Создаем Ломаную");
            System.out.println("6 - Задача 5.7: Длина Ломаной");
            System.out.println("0 - Выход");

            int choice = validator.getValidChoice();

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (choice) {
                //ЗАДАНИЕ 1
                case 1:
                    System.out.println("\n=== ЗАДАЧА 1.3 - ИМЕНА ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int nameChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (nameChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");
                        Name cleopatra = new Name("Клеопатра");
                        Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
                        Name mayakovskiy = new Name("Маяковский", "Владимир");

                        System.out.println(cleopatra);
                        System.out.println(pushkin);
                        System.out.println(mayakovskiy);
                    } else {
                        System.out.println("\nСоздание имен с вводом данных:");

                        System.out.println("\n1. Создание имени (только личное имя):");
                        String firstNameOnly = validator.getNonEmptyString("Введите личное имя: ");
                        Name nameOnly = new Name(firstNameOnly);
                        System.out.println("Результат: " + nameOnly);

                        System.out.println("\n2. Создание имени (фамилия и имя):");
                        String lastNameFirst = validator.getNonEmptyString("Введите фамилию: ");
                        String firstNameFirst = validator.getNonEmptyString("Введите личное имя: ");
                        Name nameFirstLast = new Name(lastNameFirst, firstNameFirst);
                        System.out.println("Результат: " + nameFirstLast);

                        System.out.println("\n3. Создание полного имени:");
                        String lastNameFull = validator.getNonEmptyString("Введите фамилию: ");
                        String firstNameFull = validator.getNonEmptyString("Введите личное имя: ");
                        String middleNameFull = validator.getNonEmptyString("Введите отчество: ");
                        Name nameFull = new Name(lastNameFull, firstNameFull, middleNameFull);
                        System.out.println("Результат: " + nameFull);
                    }
                    break;

                //ЗАДАНИЕ 2
                case 2:
                    System.out.println("\n=== ЗАДАЧА 2.2 - ЧЕЛОВЕК С ИМЕНЕМ ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int personChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (personChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");
                        Person cleopatraPerson = new Person(new Name("Клеопатра"), 152);
                        Person pushkinPerson = new Person(new Name("Пушкин", "Александр", "Сергеевич"), 167);
                        Person mayakovskiyPerson = new Person(new Name("Маяковский", "Владимир"), 189);

                        System.out.println(cleopatraPerson);
                        System.out.println(pushkinPerson);
                        System.out.println(mayakovskiyPerson);
                    } else {
                        System.out.println("\nСоздание человека с объектом Имя:");

                        System.out.println("\n1. Создание имени для человека:");
                        System.out.println("Выберите тип имени:");
                        System.out.println("1 - Только имя");
                        System.out.println("2 - Фамилия и имя");
                        System.out.println("3 - Полное имя (ФИО)");
                        int nameType = validator.getValidIntInRange("Ваш выбор: ", 1, 3);

                        Name personName = null;

                        switch (nameType) {
                            case 1:
                                String firstName = validator.getNonEmptyString("Введите имя: ");
                                personName = new Name(firstName);
                                break;
                            case 2:
                                String lastName = validator.getNonEmptyString("Введите фамилию: ");
                                String firstName2 = validator.getNonEmptyString("Введите имя: ");
                                personName = new Name(lastName, firstName2);
                                break;
                            case 3:
                                String lastName3 = validator.getNonEmptyString("Введите фамилию: ");
                                String firstName3 = validator.getNonEmptyString("Введите имя: ");
                                String middleName = validator.getNonEmptyString("Введите отчество: ");
                                personName = new Name(lastName3, firstName3, middleName);
                                break;
                        }

                        int personHeight = validator.getValidIntInRange("Введите рост (см): ", 50, 250);
                        Person person = new Person(personName, personHeight);

                        System.out.println("\n--- Результат ---");
                        System.out.println(person);
                    }
                    break;

                //ЗАДАНИЕ 3
                case 3:
                    System.out.println("\n=== ЗАДАЧА 2.3 - ЧЕЛОВЕК С РОДИТЕЛЕМ ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int parentChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (parentChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");

                        Person ivan = new Person(new Name("Чудов", "Иван"), 175);
                        Person petr = new Person(new Name("Чудов", "Петр"), 180);
                        Person boris = new Person(new Name("Борис"), 185);

                        /*System.out.println("До установки отцов:");
                        System.out.println("Иван: " + ivan);
                        System.out.println("Петр: " + petr);
                        System.out.println("Борис: " + boris);*/

                        petr.setFather(ivan);
                        boris.setFather(petr);

                        System.out.println("\nПосле установки отцов:");
                        System.out.println("Иван: " + ivan);
                        System.out.println("Петр: " + petr);
                        System.out.println("Борис: " + boris);
                    } else {
                        System.out.println("\nСоздание семьи с вводом данных:");

                        System.out.println("\n=== СОЗДАНИЕ ОТЦА ===");
                        String fatherLastName = validator.getNonEmptyString("Введите фамилию отца: ");
                        String fatherFirstName = validator.getNonEmptyString("Введите имя отца: ");
                        int fatherHeight = validator.getValidIntInRange("Введите рост отца (см): ", 50, 250);
                        Person fatherPerson = new Person(new Name(fatherLastName, fatherFirstName), fatherHeight);

                        System.out.println("\n=== СОЗДАНИЕ СЫНА ===");
                        System.out.println("Фамилия будет унаследована автоматически");
                        String sonFirstName = validator.getNonEmptyString("Введите имя сына: ");
                        int sonHeight = validator.getValidIntInRange("Введите рост сына (см): ", 50, 250);
                        Person sonPerson = new Person(new Name(sonFirstName), sonHeight);

                        System.out.println("\n=== СОЗДАНИЕ ВНУКА ===");
                        System.out.println("Фамилия и отчество будут унаследованы автоматически");
                        String grandsonFirstName = validator.getNonEmptyString("Введите имя внука: ");
                        int grandsonHeight = validator.getValidIntInRange("Введите рост внука (см): ", 50, 250);
                        Person grandsonPerson = new Person(new Name(grandsonFirstName), grandsonHeight);

                        /*System.out.println("\n--- До установки родственных связей ---");
                        System.out.println("Отец: " + fatherPerson);
                        System.out.println("Сын: " + sonPerson);
                        System.out.println("Внук: " + grandsonPerson);*/

                        sonPerson.setFather(fatherPerson);
                        grandsonPerson.setFather(sonPerson);

                        System.out.println("\n--- После установки родственных связей ---");
                        System.out.println("Отец: " + fatherPerson);
                        System.out.println("Сын: " + sonPerson);
                        System.out.println("Внук: " + grandsonPerson);
                    }
                    break;

                //ЗАДАНИЕ 4
                case 4:
                    System.out.println("\n=== ЗАДАЧА 3.2 - ЛОМАНАЯ ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int polylineChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (polylineChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");

                        Point p1 = new Point(1, 5);
                        Point p2 = new Point(2, 8);
                        Point p3 = new Point(5, 3);
                        Point p4 = new Point(2, -5);
                        Point p5 = new Point(4, -8);

                        Polyline exampleLine1 = new Polyline();
                        exampleLine1.addPoint(p1);
                        exampleLine1.addPoint(p2);
                        exampleLine1.addPoint(p3);
                        System.out.println("Первая ломаная: " + exampleLine1);

                        Polyline exampleLine2 = new Polyline();
                        exampleLine2.addPoint(p1);
                        exampleLine2.addPoint(p4);
                        exampleLine2.addPoint(p5);
                        exampleLine2.addPoint(p3);
                        System.out.println("Вторая ломаная: " + exampleLine2);

                        System.out.println("\nСдвигаем первую точку на (3, 2):");
                        p1.move(3, 2);
                        System.out.println("Первая ломаная после сдвига: " + exampleLine1);
                        System.out.println("Вторая ломаная после сдвига: " + exampleLine2);
                    } else {
                        System.out.println("\nСоздание двух ломаных с общими точками:");

                        System.out.println("\n=== СОЗДАНИЕ ПЕРВОЙ ЛОМАНОЙ ===");
                        Polyline line1 = new Polyline();

                        int pointsCount1 = validator.getValidIntInRange("Сколько точек в первой ломаной? ", 2, 10);
                        for (int i = 0; i < pointsCount1; i++) {
                            System.out.println("\nТочка " + (i + 1) + " для первой ломаной:");
                            double x = validator.getValidDouble("Введите координату X: ");
                            double y = validator.getValidDouble("Введите координату Y: ");
                            line1.addPoint(new Point(x, y));
                        }

                        System.out.println("\nПервая ломаная: " + line1);

                        System.out.println("\n=== СОЗДАНИЕ ВТОРОЙ ЛОМАНОЙ ===");
                        Polyline line2 = new Polyline();

                        Point firstPoint = line1.getFirstPoint();
                        line2.addPoint(firstPoint);
                        System.out.println("Добавлена первая точка из первой ломаной: " + firstPoint);

                        int middlePoints = validator.getValidIntInRange("Сколько промежуточных точек для второй ломаной? ", 1, 5);
                        for (int i = 0; i < middlePoints; i++) {
                            System.out.println("\nПромежуточная точка " + (i + 1) + " для второй ломаной:");
                            double x = validator.getValidDouble("Введите координату X: ");
                            double y = validator.getValidDouble("Введите координату Y: ");
                            line2.addPoint(new Point(x, y));
                        }

                        Point lastPoint = line1.getLastPoint();
                        line2.addPoint(lastPoint);
                        System.out.println("Добавлена последняя точка из первой ломаной: " + lastPoint);

                        System.out.println("\nВторая ломаная: " + line2);

                        System.out.println("\n=== СДВИГ НАЧАЛА ЛОМАНЫХ ===");
                        double dx = validator.getValidDouble("Введите смещение по X: ");
                        double dy = validator.getValidDouble("Введите смещение по Y: ");

                        System.out.println("Сдвигаем первую точку на (" + dx + ", " + dy + ")");
                        firstPoint.move(dx, dy);

                        System.out.println("\nРезультат после сдвига:");
                        System.out.println("Первая ломаная: " + line1);
                        System.out.println("Вторая ломаная: " + line2);
                    }
                    break;

                //ЗАДАНИЕ 5
                case 5:
                    System.out.println("\n=== ЗАДАЧА 4.9 - СОЗДАЕМ ЛОМАНУЮ ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int createChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (createChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");
                        System.out.println("Примеры создания ломаных разными способами:");

                        System.out.println("\n1. Создание без параметров:");
                        Polyline example1 = new Polyline();
                        System.out.println("Пустая ломаная: " + example1);
                        example1.addPoint(new Point(0, 0));
                        example1.addPoint(new Point(1, 1));
                        example1.addPoint(new Point(2, 0));
                        System.out.println("После добавления точек: " + example1);

                        System.out.println("\n2. Создание с набором точек:");
                        java.util.List<Point> examplePoints = java.util.Arrays.asList(
                                new Point(10, 10),
                                new Point(15, 20),
                                new Point(20, 15),
                                new Point(25, 25)
                        );
                        Polyline example2 = new Polyline(examplePoints);
                        System.out.println("Ломаная с предустановленными точками: " + example2);

                        System.out.println("\n--- Объяснение ---");
                        System.out.println("Ломаная может быть создана:");
                        System.out.println("- Без параметров (пустая)");
                        System.out.println("- С готовым набором точек");
                    } else {
                        System.out.println("1. Создание пустой ломаной и добавление точек:");
                        Polyline emptyLine = new Polyline();
                        System.out.println("Пустая ломаная: " + emptyLine);

                        int pointsToAdd = validator.getValidIntInRange("Сколько точек добавить в пустую ломаную? ", 1, 10);
                        for (int i = 0; i < pointsToAdd; i++) {
                            System.out.println("\nТочка " + (i + 1) + ":");
                            double x = validator.getValidDouble("Введите X: ");
                            double y = validator.getValidDouble("Введите Y: ");
                            emptyLine.addPoint(x, y);
                        }
                        System.out.println("Ломаная после добавления: " + emptyLine);

                        System.out.println("\n2. Создание ломаной с готовым набором точек:");
                        int predefinedPointsCount = validator.getValidIntInRange("Сколько точек создать для готовой ломаной? ", 2, 10);
                        java.util.List<Point> predefinedPoints = new java.util.ArrayList<>();

                        for (int i = 0; i < predefinedPointsCount; i++) {
                            System.out.println("\nТочка " + (i + 1) + " для готовой ломаной:");
                            double x = validator.getValidDouble("Введите X: ");
                            double y = validator.getValidDouble("Введите Y: ");
                            predefinedPoints.add(new Point(x, y));
                        }

                        Polyline predefinedLine = new Polyline(predefinedPoints);
                        System.out.println("Ломаная с предустановленными точками: " + predefinedLine);
                    }
                    break;

                //ЗАДАНИЕ 6
                case 6:
                    System.out.println("\n=== ЗАДАЧА 5.7 - ДЛИНА ЛОМАНОЙ ===");
                    System.out.println("1 - Запустить пример из задания");
                    System.out.println("2 - Ввести данные с клавиатуры");
                    int lengthChoice = validator.getValidIntInRange("Выберите вариант: ", 1, 2);

                    if (lengthChoice == 1) {
                        System.out.println("\n--- Примеры из задания ---");

                        PolylineWithLength exampleLine = new PolylineWithLength();
                        exampleLine.addPoint(1, 5);
                        exampleLine.addPoint(2, 8);
                        exampleLine.addPoint(5, 3);

                        System.out.println("1. Ломаная: " + exampleLine);
                        System.out.println("   Длина: " + String.format("%.2f", exampleLine.getLength()));

                        // Добавляем точки: {5;15}, {8;10}
                        System.out.println("\n2. Добавляем точки {5;15}, {8;10}");
                        exampleLine.addPoints(
                                new Point(5, 15),
                                new Point(8, 10)
                        );

                        System.out.println("   Ломаная после добавления: " + exampleLine);
                        System.out.println("   Новая длина: " + String.format("%.2f", exampleLine.getLength()));
                    } else {
                        System.out.println("Создание ломаной и вычисление её длины:");

                        PolylineWithLength line = new PolylineWithLength();

                        System.out.println("Создание начальной ломаной:");
                        int initialPoints = validator.getValidIntInRange("Сколько точек в начальной ломаной? ", 2, 10);

                        for (int i = 0; i < initialPoints; i++) {
                            System.out.println("\nТочка " + (i + 1) + ":");
                            double x = validator.getValidDouble("Введите X: ");
                            double y = validator.getValidDouble("Введите Y: ");
                            line.addPoint(x, y);
                        }

                        System.out.println("\nЛоманая: " + line);
                        System.out.println("Длина ломаной: " + String.format("%.2f", line.getLength()));

                        System.out.println("\nДобавление новых точек:");
                        int additionalPoints = validator.getValidIntInRange("Сколько дополнительных точек добавить? ", 1, 5);

                        for (int i = 0; i < additionalPoints; i++) {
                            System.out.println("\nДополнительная точка " + (i + 1) + ":");
                            double x = validator.getValidDouble("Введите X: ");
                            double y = validator.getValidDouble("Введите Y: ");
                            line.addPoint(x, y);
                        }

                        System.out.println("\nЛоманая после добавления: " + line);
                        System.out.println("Новая длина ломаной: " + String.format("%.2f", line.getLength()));
                    }
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
        scanner.close();
    }
}