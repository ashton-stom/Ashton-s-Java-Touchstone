/**
 * Temperature Converter Program
 * 
 * To run this program:
 * 1. Compile the program: javac TemperatureConverter.java
 * 2. Run the program: java TemperatureConverter
 * 
 * Follow the on-screen menu to convert temperatures between Celsius, Fahrenheit, and Kelvin.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while loop to keep the program running until the user wants to exit
        while (true) {
            System.out.println("\nTemperature Converter");
            //Conversion Options
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            
            System.out.print("\nEnter your choice (1-7): ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number between 1 and 7.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            scanner.nextLine(); // Clear the buffer after reading the choice
            
            if (choice == 7) {
                System.out.println("Thank you for using the Temperature Converter!");
                break;
            }
            
            if (choice < 1 || choice > 7) {
                System.out.println("Error: Please enter a number between 1 and 7.");
                continue;
            }
            
            System.out.print("Enter the temperature: ");
            double temperature;
            try {
                temperature = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number for temperature.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }
            scanner.nextLine(); // Clear the buffer after reading the temperature
            
            double result = 0;
            String fromUnit = "";
            String toUnit = "";
            
            switch (choice) {
                case 1:
                    result = celsiusToFahrenheit(temperature);
                    fromUnit = "Celsius";
                    toUnit = "Fahrenheit";
                    break;
                case 2:
                    result = fahrenheitToCelsius(temperature);
                    fromUnit = "Fahrenheit";
                    toUnit = "Celsius";
                    break;
                case 3:
                    result = celsiusToKelvin(temperature);
                    fromUnit = "Celsius";
                    toUnit = "Kelvin";
                    break;
                case 4:
                    result = kelvinToCelsius(temperature);
                    fromUnit = "Kelvin";
                    toUnit = "Celsius";
                    break;
                case 5:
                    result = fahrenheitToKelvin(temperature);
                    fromUnit = "Fahrenheit";
                    toUnit = "Kelvin";
                    break;
                case 6:
                    result = kelvinToFahrenheit(temperature);
                    fromUnit = "Kelvin";
                    toUnit = "Fahrenheit";
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }
            
            System.out.println(); // Add extra line break for better readability of result
            System.out.printf("%.2f°%s = %.2f°%s%n", temperature, fromUnit, result, toUnit);
            System.out.println(); // Add extra line break before continue prompt
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }
        
        scanner.close();
    }
    
    // Conversion methods
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    
    public static double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }
    
    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }
} 