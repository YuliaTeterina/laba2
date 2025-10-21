import java.util.Scanner;
import java.util.Arrays;

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
                case 1:
                    System.out.println("\n=== ЗАДАЧА 1.3 - ИМЕНА ===");
                    Name cleopatra = new Name("Клеопатра");
                    Name pushkin = new Name("Пушкин", "Александр", "Сергеевич");
                    Name mayakovskiy = new Name("Маяковский", "Владимир");

                    System.out.println(cleopatra);
                    System.out.println(pushkin);
                    System.out.println(mayakovskiy);
                    break;

                case 2:
                    System.out.println("\n=== ЗАДАЧА 2.2 - ЧЕЛОВЕК С ИМЕНЕМ ===");
                    PersonSimple person1 = new PersonSimple("Клеопатра", 152);
                    PersonSimple person2 = new PersonSimple("Пушкин", 167);
                    PersonSimple person3 = new PersonSimple("Владимир", 189);

                    System.out.println(person1);
                    System.out.println(person2);
                    System.out.println(person3);
                    break;

                case 3:
                    System.out.println("\n=== ЗАДАЧА 2.3 - ЧЕЛОВЕК С РОДИТЕЛЕМ ===");

                    Person ivan = new Person(new Name("Чудов", "Иван"), 175);
                    Person petr = new Person(new Name("Чудов", "Петр"), 180);
                    Person boris = new Person(new Name("Борис"), 185);

                    System.out.println("До установки отцов:");
                    System.out.println("Иван: " + ivan);
                    System.out.println("Петр: " + petr);
                    System.out.println("Борис: " + boris);

                    petr.setFather(ivan);
                    boris.setFather(petr);

                    System.out.println("\nПосле установки отцов:");
                    System.out.println("Иван: " + ivan);
                    System.out.println("Петр: " + petr);
                    System.out.println("Борис: " + boris);
                    break;

                case 4:
                    System.out.println("\n=== ЗАДАЧА 3.2 - ЛОМАНАЯ ===");

                    Point p1 = new Point(1, 5);
                    Point p2 = new Point(2, 8);
                    Point p3 = new Point(5, 3);
                    Point p4 = new Point(2, -5);
                    Point p5 = new Point(4, -8);

                    System.out.println("Создаем точки:");
                    System.out.println("Точка 1: " + p1);
                    System.out.println("Точка 2: " + p2);
                    System.out.println("Точка 3: " + p3);
                    System.out.println("Точка 4: " + p4);
                    System.out.println("Точка 5: " + p5);

                    Polyline line1 = new Polyline();
                    line1.addPoint(p1);
                    line1.addPoint(p2);
                    line1.addPoint(p3);

                    System.out.println("\nПервая ломаная:");
                    System.out.println(line1);

                    Polyline line2 = new Polyline();
                    line2.addPoint(p1);
                    line2.addPoint(p4);
                    line2.addPoint(p5);
                    line2.addPoint(p3);

                    System.out.println("Вторая ломаная:");
                    System.out.println(line2);

                    System.out.println("\nСдвигаем начало на (3, 2):");
                    p1.move(3, 2);

                    System.out.println("Первая ломаная после сдвига:");
                    System.out.println(line1);
                    System.out.println("Вторая ломаная после сдвига:");
                    System.out.println(line2);
                    break;

                case 5:
                    System.out.println("\n=== ЗАДАЧА 4.9 - СОЗДАНИЕ ЛОМАНОЙ ===");

                    System.out.println("1. Создание ломаной без параметров:");
                    Polyline emptyLine = new Polyline();
                    System.out.println("Пустая ломаная: " + emptyLine);

                    emptyLine.addPoint(new Point(0, 0));
                    emptyLine.addPoint(new Point(1, 1));
                    emptyLine.addPoint(new Point(2, 0));
                    System.out.println("После добавления точек: " + emptyLine);

                    System.out.println("\n2. Создание ломаной с набором точек:");
                    java.util.List<Point> pointsList = Arrays.asList(
                            new Point(10, 10),
                            new Point(15, 20),
                            new Point(20, 15),
                            new Point(25, 25)
                    );
                    Polyline prebuiltLine = new Polyline(pointsList);
                    System.out.println("Ломаная с предустановленными точками: " + prebuiltLine);

                    System.out.println("\n3. Создание ломаной с добавлением точек по координатам:");
                    Polyline coordLine = new Polyline();
                    coordLine.addPoint(100, 50);
                    coordLine.addPoint(120, 80);
                    coordLine.addPoint(140, 40);
                    System.out.println("Ломаная с точками по координатам: " + coordLine);
                    break;

                case 6:
                    System.out.println("\n=== ЗАДАЧА 5.7 - ДЛИНА ЛОМАНОЙ ===");

                    System.out.println("1. Создаем ломаную через точки {1;5}, {2;8}, {5;3}");
                    PolylineWithLength lineWithLength = new PolylineWithLength(Arrays.asList(
                            new Point(1, 5),
                            new Point(2, 8),
                            new Point(5, 3)
                    ));
                    System.out.println("Ломаная: " + lineWithLength);

                    System.out.println("2. Длина ломаной: " + String.format("%.2f", lineWithLength.getLength()));

                    System.out.println("3. Добавляем точки {5;15}, {8;10}");
                    lineWithLength.addPoints(
                            new Point(5, 15),
                            new Point(8, 10)
                    );
                    System.out.println("Ломаная после добавления точек: " + lineWithLength);

                    System.out.println("4. Новая длина ломаной: " + String.format("%.2f", lineWithLength.getLength()));
                    break;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
        scanner.close();
    }
}