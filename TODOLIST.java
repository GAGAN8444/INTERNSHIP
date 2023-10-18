import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private ArrayList<String> tasks = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void display() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void add(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void remove(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index. Task not removed.");
        }
    }

    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display To-Do List");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            choice = app.input.nextInt();
            app.input.nextLine();

            switch (choice) {
                case 1:
                    app.display();
                    break;
                case 2:
                    System.out.print("Enter the task to add: ");
                    String task = app.input.nextLine();
                    app.add(task);
                    break;
                case 3:
                    app.display();
                    System.out.print("Enter the task index to remove: ");
                    int indexToRemove = app.input.nextInt();
                    app.remove(indexToRemove - 1);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        app.input.close();
    }
}