package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Students students = new Students();
        Scanner scanner;
        scanner = new Scanner(System.in);
        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Добро пожаловать! Выберите действие и впишите в консоль:");
            System.out.println("1. Добавить нового студента в базу данных");
            System.out.println("2. Изменить информацию о студенте по его ID");
            System.out.println("3. Удаление студента из базы данных по его ID");
            System.out.println("4. Поиск студента по его ID и вывод информации о нем");
            System.out.println("5. Вывод списка всех студентов в базе данных");
            System.out.println("6. Вывести список всех студентов от низкого до высокого среднего балла");
            System.out.println("7. Вывести список всех студентов по алфавиту имени");
            System.out.println("8. Exit");
            int chooseInput = scanner.nextInt();
            scanner.nextLine();
            switch (chooseInput){
                case 1:
                    System.out.println("Введите имя студента: ");
                    String firstName = scanner.next();
                    System.out.println("Введите фамилию студента: ");
                    String secondName = scanner.next();
                    System.out.println("Введите возраст студента: ");
                    int age = scanner.nextInt();
                    System.out.println("(Введите через запятую(пример: 3,7)) Введите средний балл студента: ");
                    double averageScore = scanner.nextDouble();
                    System.out.println("Студент " + firstName + " был успешно добавлен в базу данных!");
                    students.addStudent(firstName, secondName, age, averageScore);
                    break;
                case 2:
                    System.out.println("Введите идентификатор студента: ");
                    int id = scanner.nextInt();
                    System.out.println("На какое имя поменять: ");
                    String firstEditName = scanner.next();
                    System.out.println("На какую фамилию поменять: ");
                    String secondEditName = scanner.next();
                    System.out.println("На какой возраст поменять: ");
                    int ageEdit = scanner.nextInt();
                    System.out.println("(Введите через запятую(пример: 3,7)) На какой средний балл поменять: ");
                    double averageEditScore = scanner.nextDouble();
                    students.editStudent(id, firstEditName, secondEditName, ageEdit, averageEditScore);
                    break;
                case 3:
                    System.out.println("Введите идентификатор студента: ");
                    int removeID = scanner.nextInt();
                    students.removeStudent(removeID);
                    break;
                case 4:
                    System.out.println("Введите идентификатор студента: ");
                    int foundID = scanner.nextInt();
                    students.foundStudent(foundID);
                    break;
                case 5:
                    students.listStudent();
                    break;
                case 6:
                    students.sortingStudentAverage();
                    break;
                case 7:
                    students.sortingStudentfirstName();
                    break;
                case 8:
                    System.out.println("Succesful!");
                    return;
                default:
                    System.err.println("Неверный ввод, попробуйте еще раз!");
            }
        }
    }
}
