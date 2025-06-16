Question 1  CP - Write a Program to compute the volume of Earth in km^3 and miles^3


Solution:
public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378.0;
        double kmToMiles = 0.621371;  // 1 kilometer = 0.621371 miles

        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

       
        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.printf("The volume of earth in cubic kilometers is %.2f km³%n", volumeKm3);
        System.out.printf("The volume of earth in cubic miles is %.2f mi³%n", volumeMiles3);
    }
}


Question 2: CP - Create a Program that takes user input for Student Fee and University Discount to compute the
 discounted amount and discounted price the student will pay for the course.

Solution:import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

               System.out.print("Enter the course fee (INR): ");
        double fee = sc.nextDouble();

                System.out.print("Enter the university discount percentage: ");
        double discountPercent = sc.nextDouble();

                double discount = (discountPercent / 100.0) * fee;

                double finalFee = fee - discount;

              System.out.printf("The discount amount is INR %.2f%n", discount);
        System.out.printf("The final discounted fee is INR %.2f%n", finalFee);

        sc.close();
    }
}



Question 3: CP - Create a program to calculate the profit and loss in number and percentage based on the cost price
 of INR 129 and the selling price of INR 191

Solution: public class ProfitCalculator {
    public static void main(String[] args) {
               double costPrice = 129.0;
        double sellingPrice = 191.0;

                double profit = sellingPrice - costPrice;
        double profitPercent = (profit / costPrice) * 100;

        System.out.println(
            "The Cost Price is INR " + costPrice + " and the Selling Price is INR " + sellingPrice + "\n" +
            "The Profit is INR " + profit + " and the Profit Percentage is " + String.format("%.2f", profitPercent) + "%"
        );
    }
}


Question 4: CP - Suppose you have to divide 14 pens among 3 students equally. Write a program to find how many
 pens each student will get if the pens must be divided equally. Also, find the remaining non-distributed
 pens.
 
Solution:public class PenDistribution {
    public static void main(String[] args) {
        int totalPens = 14;
        int totalStudents = 3;

        int pensPerStudent = totalPens / totalStudents;      
        int remainingPens = totalPens % totalStudents;       
        System.out.println("The Pen Per Student is " + pensPerStudent + 
                           " and the remaining pen not distributed is " + remainingPens);
    }
}
  Ouestion 5: CP - Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent
 mark in PCM
  
Solution:  public class SamAverage {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        int totalMarks = maths + physics + chemistry;
        double average = totalMarks / 3.0;

        System.out.println("Sam’s average mark in PCM is " + average);
    }
}


Question 6: CP - Create a program to convert the distance of 10.8 kilometers to miles.

 Solution: public class KmToMilesConverter {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double conversionFactor = 1.6;

        double miles = kilometers * conversionFactor;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}


Question 7: CP - Create a program to convert distance in kilometers to miles

Solution:import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
             Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();

        double miles = km / 1.6;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km.");

        input.close();
    }
}
 Question 8: CP - Write a program to find the age of Harry if the birth year is 2000. Assume the Current Year is 2024
  

Solution: public class HarryAgeCalculator {
    public static void main(String[] args) {
        int birthYear = 2000;
        int currentYear = 2024;

        int age = currentYear - birthYear;

        System.out.println("Harry's age in 2024 is " + age);
    }
}


Question 9: CP - Write a program that takes your height in centimeters and converts it into feet and inches
    

Solution:  import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        double cm = input.nextDouble();

         double totalInches = cm / 2.54;

        int feet = (int)(totalInches / 12);
        int inches = (int)(totalInches % 12);

        System.out.println("Your height is " + feet + " feet and " + inches + " inches.");

        input.close();
    }
}



Question 10: CP - The University is charging the student a fee of INR 125000 for the course. The University is willing
 to offer a discount of 10%. Write a program to find the discounted amount and discounted price the
 student will pay for the course.


Solution:public class CourseFeeDiscount {
    public static void main(String[] args) {
        double courseFee = 125000;
        double discountRate = 10; // in percent

        
        double discountAmount = (discountRate / 100) * courseFee;

       
        double finalPrice = courseFee - discountAmount;

        System.out.println("The discount amount is INR " + discountAmount);
        System.out.println("The discounted price the student will pay is INR " + finalPrice);
    }
}


Question 11: CP - Write an IntOperation program by taking a, b, and c as input values and print the results of the
 following integer operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the
 Operator Precedence.


Solution:import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input values
        System.out.print("Enter value for a: ");
        int a = input.nextInt();

        System.out.print("Enter value for b: ");
        int b = input.nextInt();

        System.out.print("Enter value for c: ");
        int c = input.nextInt();

        int result1 = a + b * c;              
        int result2 = a * b + c;              
        int result3 = c + a / b;              
        int result4 = a % b + c;      
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        input.close();
    }
}


Question 12: CP - Write a program to input the unit price of an item and the quantity to be bought. Then, calculate the
 total purchase price.


Solution:import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input unit price
        System.out.print("Enter the unit price of the item: ");
        double unitPrice = input.nextDouble();

        // Input quantity
        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Display the result
        System.out.println("The total purchase price is: INR " + totalPrice);

        input.close();
    }
}



Question 13: CP - Write a program to find the distance in yards and miles for the distance provided by the user in feet

Solution:
import java.util.Scanner;

public class FeetToYardAndMile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        double yards = feet / 3;
        double miles = feet / 5280;

        System.out.println("Distance in yards: " + yards);
        System.out.println("Distance in miles: " + miles);

        input.close();
    }
}


Question 14: CP - Write a program to find the side of the square whose parameter you read from the use.

Solution:
import java.util.Scanner;

public class SquareSideCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the perimeter of the square: ");
        double perimeter = input.nextDouble();

        double side = perimeter / 4;

        System.out.println("The side of the square is: " + side);

        input.close();
    }
}

Question 15: CP - Write a DoubleOperation program by taking a, b, and c as input values and print the results of the
 following operations a + b *c, a * b + c, c + a / b, and a % b + c. Please also understand the Operator
 Precedence.


Solution:
import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter value for a: ");
        double a = input.nextDouble();

        System.out.print("Enter value for b: ");
        double b = input.nextDouble();

        System.out.print("Enter value for c: ");
        double c = input.nextDouble();

        
        double result1 = a + b * c;     // b * c evaluated first
        double result2 = a * b + c;     // a * b evaluated first
        double result3 = c + a / b;     // a / b evaluated first
        double result4 = a % b + c;     // a % b evaluated first

        
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        input.close();
    }
}



Question 16:CP - Write a program to create a basic calculator for addition, subtraction, multiplication, and division.
 The program should ask for two numbers (floating point) and perform all the operations.

Solution:   import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the first number: ");
        float num1 = input.nextFloat();

        System.out.print("Enter the second number: ");
        float num2 = input.nextFloat();

        
        float addition = num1 + num2;
        float subtraction = num1 - num2;
        float multiplication = num1 * num2;
        float division = num2 != 0 ? num1 / num2 : Float.NaN; // check for division by zero

        
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        if (num2 != 0) {
            System.out.println("Division: " + division);
        } else {
            System.out.println("Division: Cannot divide by zero.");
        }

        input.close();
    }
}


Question 17:  CP - Write a program that takes the base and height in cm to find the area of a triangle in square inches
 and square centimeters.

Solution:
import java.util.Scanner;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input base and height in centimeters
        System.out.print("Enter base of the triangle in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter height of the triangle in cm: ");
        double height = input.nextDouble();

        // Calculate area in square centimeters
        double areaCm = 0.5 * base * height;

        // Convert area to square inches
        double areaInch = areaCm / (2.54 * 2.54);

        // Display the results
        System.out.println("Area of the triangle:");
        System.out.println("In square centimeters: " + areaCm + " cm²");
        System.out.println("In square inches: " + areaInch + " in²");

        input.close();
    }
}


Question 18:CP - Write a program to take two numbers and print their quotient and reminder.


Solution:import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the dividend (number to divide): ");
        int dividend = input.nextInt();

        System.out.print("Enter the divisor (number to divide by): ");
        int divisor = input.nextInt();

                if (divisor != 0) {
            int quotient = dividend / divisor;
            int remainder = dividend % divisor;

            
            System.out.println("Quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }

        input.close();
    }
}
  Question 19: CP - Create a program to find the total income of a person by taking salary and bonus from the user.

Solution:import java.util.Scanner;

public class TotalIncomeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter your salary: ");
        double salary = input.nextDouble();

        
        System.out.print("Enter your bonus: ");
        double bonus = input.nextDouble();

        
        double totalIncome = salary + bonus;

        
        System.out.println("Your total income is: INR " + totalIncome);

        input.close();
    }
}

Question 20:CP - Write a TemperaturConversion program, given the temperature in Celsius as input outputs the
 temperature in Fahrenheit.


Solution:
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();

        
        double fahrenheit = (celsius * 9 / 5) + 32;

        
        System.out.println("Temperature in Fahrenheit: " + fahrenheit + "°F");

        input.close();
    }
}


Question 21: CP - Create a program to find the maximum number of handshakes among N number of students.

Solution:import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();

        
        int handshakes = n * (n - 1) / 2;

        
        System.out.println("Maximum number of handshakes: " + handshakes);

        input.close();
    }
}


Question 22:CP - Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.


Solution:
import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the Principal amount (INR): ");
        double principal = input.nextDouble();

        
        System.out.print("Enter the Rate of interest (% per annum): ");
        double rate = input.nextDouble();

        
        System.out.print("Enter the Time period (in years): ");
        double time = input.nextDouble();

        
        double simpleInterest = (principal * rate * time) / 100;

        
        System.out.println("Simple Interest is: INR " + simpleInterest);

        input.close();
    }
}

Question 23: CP - Create a program to divide N number of chocolates among M children.

Solution:import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the total number of chocolates (N): ");
        int chocolates = input.nextInt();

        
        System.out.print("Enter the number of children (M): ");
        int children = input.nextInt();

        
        if (children == 0) {
            System.out.println("Cannot divide chocolates among 0 children!");
        } else {
            int eachChildGets = chocolates / children;
            int remaining = chocolates % children;

            
            System.out.println("Each child gets: " + eachChildGets + " chocolates");
            System.out.println("Remaining chocolates: " + remaining);
        }

        input.close();
    }
}



Question 24: CP - An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete
 wants to complete a 5 km run, then how many rounds must the athlete complete.


Solution:import java.util.Scanner;

public class AthleteRunCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = input.nextDouble();

        
        double perimeter = side1 + side2 + side3;

        
        double totalDistance = 5000.0;

        
        double rounds = totalDistance / perimeter;

        
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds to run 5 km.");

        input.close();
    }
}


Question 25:P - Write a TemperaturConversion program, given the temperature in Fahrenheit as input outputs the
 temperature in Celsius.

Solution:import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        
        double celsius = (fahrenheit - 32) * 5 / 9;

        
        System.out.println("Temperature in Celsius: " + celsius + "°C");

        input.close();
    }
}


Quetion 26: CP - Rewrite the Sample Program 2 with user inputs.

Solution:import java.util.Scanner;

public class JourneyDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your From City: ");
        String fromCity = input.nextLine();
        System.out.print("Enter your Via City: ");
        String viaCity = input.nextLine();
        System.out.print("Enter your To City (Final Destination): ");
        String toCity = input.nextLine();
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();
        System.out.print("Enter time taken from " + fromCity + " to " + viaCity + " (in hours): ");
        float time1 = input.nextFloat();
        System.out.print("Enter time taken from " + viaCity + " to " + toCity + " (in hours): ");
        float time2 = input.nextFloat();
        double totalDistance = fromToVia + viaToFinalCity;
        float totalTime = time1 + time2;
        double averageSpeed = totalDistance / totalTime;
        System.out.println("\n----- Journey Summary -----");
        System.out.println("Traveler Name: " + name);
        System.out.println("Route: " + fromCity + " -> " + viaCity + " -> " + toCity);
        System.out.println("Total Distance: " + totalDistance + " miles");
        System.out.println("Total Time: " + totalTime + " hours");
        System.out.println("Average Speed: " + averageSpeed + " miles/hour");

        input.close();
    }
}



Question 27: CP - Create a program to convert weight from pounds to kilograms.


 Solution:import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();

        
        double kilograms = pounds * 0.453592;

        
        System.out.println("Weight in kilograms: " + kilograms + " kg");

        input.close();
    }
}


Question 28: CP - Create a program to swap two numbers.

Soluton:import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter first number (a): ");
        int a = input.nextInt();

        System.out.print("Enter second number (b): ");
        int b = input.nextInt();

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        
        int temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping: a = " + a + ", b = " + b);

        input.close();
    }
}









