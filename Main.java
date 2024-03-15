import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data separated by spaces (Last Name First Name Middle Name Birth Date Phone Number Gender):");
        String input = scanner.nextLine();
        String[] inputData = input.split(" ");

        try {
            Person person = new Person(inputData);
            String fileName = person.getLastName() + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(person.toString());
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Data successfully written to file.");
        } catch (InvalidDataFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
