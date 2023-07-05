package org.example;
import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Scanner;



class User {
    String fullName;
    int age;
    char gender;

    public User(String fullName, int age, char gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        String initials = getInitials(fullName);
        return fullName + " " + initials + ". " + age + " " + gender;
    }

    private String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            if (!name.isEmpty()) {
                initials.append(name.charAt(0)).append(".");
            }
        }
        return initials.toString();
    }
}

public class UserManagement {
    private User[] users;
    private int size;

    public UserManagement() {
        users = new User[100];
        size = 0;
    }

    public void addUser(User user) {
        if (size < 100) {
            users[size] = user;
            size++;
            System.out.println("User added successfully.");
        } else {
            System.out.println("User limit reached. Cannot add more users.");
        }
    }

    public void displayUsers() {
        System.out.println("List of Users:");
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public void sortByAge() {
        int[] indices = new int[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (users[indices[j]].age > users[indices[j + 1]].age) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }
        System.out.println("Users sorted by age:");
        for (int i = 0; i < size; i++) {
            System.out.println(users[indices[i]]);
        }
    }

    public void sortByAgeAndGender() {
        int[] indices = new int[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (users[indices[j]].age > users[indices[j + 1]].age ||
                        (users[indices[j]].age == users[indices[j + 1]].age &&
                                users[indices[j]].gender > users[indices[j + 1]].gender)) {
                    int temp = indices[j];
                    indices[j] = indices[j + 1];
                    indices[j + 1] = temp;
                }
            }
        }
        System.out.println("Users sorted by age and gender:");
        for (int i = 0; i < size; i++) {
            System.out.println(users[indices[i]]);
        }
    }

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a user");
            System.out.println("2. Display users");
            System.out.println("3. Sort by age");
            System.out.println("4. Sort by age and gender");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter full name: ");
                    scanner.nextLine();  // Consume newline character
                    String fullName = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter gender (M/F): ");
                    char gender = scanner.next().charAt(0);
                    User user = new User(fullName, age, gender);
                    userManagement.addUser(user);
                    break;
                case 2:
                    userManagement.displayUsers();
                    break;
                case 3:
                    userManagement.sortByAge();
                    break;
                case 4:
                    userManagement.sortByAgeAndGender();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
