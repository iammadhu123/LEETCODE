import java.util.Scanner;
public class Solutions {
    // public static void main(String[] args) { //1
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter a distance(in meters): ");
    //     float distance = sc.nextInt();
    //     float feet = distance * 3.28084f;
    //     // System.out.format("%.2f", feet);
    //     System.out.printf("Distance in feet: %.2f", feet);
    //     // System.out.printf("Distance in feet: %.2f%n", feet);
    //     sc.close();
    // }

    // 
    // public static void main(String[] args) { //3
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter a single character : ");
    //     char ch = sc.next().charAt(0);
    //     ch  = Character.toLowerCase(ch);
    //     if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    //         System.out.println("Vowel");
    //     }else if(ch >= 'a' && ch <= 'z'){
    //         System.out.println("Consonant");
    //     }else{
    //         System.out.println("Invalid Input");
    //     }
    // }

    // public static void main(String[] args) { //4
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter your weight in pounds: ");
    //     float weight = sc.nextFloat();
    //     float weightInkgs = weight * 0.45359237f;
    //     System.out.println("Enter your height in inches: ");
    //     float height = sc.nextFloat();
    //     float heightInMeter = height * 0.0254f;

    //     float BMI = weightInkgs / (heightInMeter * heightInMeter);
    //     System.out.println("Your BMI is: " + BMI);
        
    // }

    // public static void main(String[] args) { //6
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter your five-digit integer:");
    //     float num = sc.nextInt();
    //     // if (num >= 10000 && num <= 99999) {
    //     //     System.out.println("Valid five-digit number: " + num);
    //     // }else{
    //     //     System.out.println("Invalid input! Please enter a five-digit integer.");
    //     //     return;
    //     // }

    //     if (num < 10000 || num > 99999) {
    //         System.out.println("Invalid input! Please enter a five-digit integer.");
    //         return;
    //     }

    //     // String str = Integer.toString(num);
    //     // String result = "";
    //     // for(float i = 0; i<str.length(); i++) {
    //     //     char ch = str.charAt(i);
    //     //     if (ch == '9') {
    //     //         result += '0';
    //     //         continue;
    //     //     }
    //     //     float digit = Character.getNumericValue(ch);
    //     //     digit = digit + 1;
    //     //     result += Integer.toString(digit);

    //     // }

    //     String str = String.valueOf(num);
    //     String result = "";
    //     for(float i = 0; i<str.length(); i++) {
    //         float digit = str.charAt(i) - '0'; // char to float
    //         digit = (digit + 1) % 10;
    //         result += digit;
    //     }
    //     // float newNum = Integer.parseInt(result);

    //     System.out.println("New number after adding one in each digit: " + result);
    // }

    // public static void main(String[] args) { //7
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter the lengths of three sides of a triangle: ");
    //     float a = sc.nextInt();
    //     float b = sc.nextInt();
    //     float c = sc.nextInt();
    
    //     double area = 0;
    //     double s = (a + b + c) / 2.0;
    //     if (a+b > c || b + c > a || c + a > b) {
    //         area = (float)Math.sqrt(s * (s - a) * (s - b) * (s - c));
    //     }else{
    //         System.out.println("Invalid triangle sides!");
    //         return;
    //     }
    //     System.out.println("Area of the triangle is:"+ area);
    // }

    public static void main(String[] args) { //5 //BY USING GREEDY ALGO
        // Scanner sc = new Scanner(System.in);
        // Simulate a simple ATM or cashier. Given an integer amount to be dispensed (e.g., 787), 
        // calculate and display the minimum number of currency notes of denominations 100, 50, 10, 
        // 5, 2, and 1 that would be given to the user. 
        // System.out.println("Enter an integer amount to be dispensed: ");
        // int amount = sc.nextInt();
        // int[] denominations = {100, 50, 10, 5, 2, 1};

        // int total = 0;
        // for(int i = 0; i<denominations.length; i++){
        //     int noteCount = amount/denominations[i];
        //     System.out.println(denominations[i] + " : " + noteCount);
        //     amount = amount - (noteCount * denominations[i]);
        //     total += noteCount;
        // }
        // System.out.println("Total notes: " + total);


        //8
        // Write a Java program that accepts two numbers as command-line arguments. Convert these 
        // arguments to appropriate numeric types (e.g., int or double), perform a simple calculation 
        // (e.g., sum or product), and print the result to the console. 

        // if (args.length < 2) {
        //     System.out.println("Please provide two numbers as command-line arguments.");
        //     return;
        // }
        // try {
        //     // Convert command-line arguments to double
        //     double num1 = Double.parseDouble(args[0]);
        //     double num2 = Double.parseDouble(args[1]);

        //     // Perform sum
        //     double sum = num1 + num2;

        //     // Print the result
        //     System.out.println("First number: " + num1);
        //     System.out.println("Second number: " + num2);
        //     System.out.println("Sum: " + sum);

        // }  catch (NumberFormatException e) {
        //     System.out.println("Invalid input. Please provide valid numbers as command-line arguments.");
        // }


        // PS C:\Users\myada\OneDrive\Desktop\Leetcode> javac Solutions.java
        // >> java Solutions 12.5 7.3
        // >>
        // First number: 12.5
        // Second number: 7.3
        // Sum: 19.8


        //2 => Cramer's Rule: D=ad−bc, Dx=ed−bf, Dy=af−ce, x=Dx/D, y=Dy/D 
        // Write a Java program to solve a system of two linear equations with two variables (e.g., ax 
        // + by = e and cx + dy = f). Prompt the user to enter the coefficients a, b, c, d, e, f. Calculate 
        // and display the values of x and y using Cramer's rule. Include error handling for cases where 
        // the denominator is zero.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coefficients a, b, c, d, e, f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        double D = (a * d) - (b * c);
        double Dx = (e * d) - (b * f);
        double Dy = (a * f) - (c * e);

        try {
            double x = Dx/D;
            double y = Dy/D;
            System.out.println("Value of x: " + x);
            System.out.println("Value of y: " + y);
        } catch (ArithmeticException ex) {
            // TODO: handle exception
            System.out.println("Denominator is zero.");
            return;
        }
    }
}
