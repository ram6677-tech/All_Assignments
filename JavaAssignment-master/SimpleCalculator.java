import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char Choice;
        do
        {
            System.out.print("Enter First Number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter Second Number: ");
            double num2 = sc.nextDouble();

            System.out.print("Choose Operator(+,-,*,/): ");
            char operator = sc.next().charAt(0);

            if(operator=='+')
            {
                System.out.println("Result: "+(num1+num2));
            }
            else if(operator=='-')
            {
                System.out.println("Result: "+(num1-num2));
            }
            else if(operator=='*')
            {
                System.out.println("Result: "+(num1*num2));
            }
            else if(operator=='/')
                if(num2 !=0)
                {
                    System.out.println("Result: "+(num1/num2));
                }
                else
                {
                    System.out.println("Error: Division by zero is not allowed");
                }
            else
            {
                System.out.println("Invalid Operator");
            }
            System.out.print("Do you want to Continue(y/n): ");
            Choice = sc.next().charAt(0);
        }while(Choice == 'y' || Choice == 'Y');
        System.out.println("Calculator Closed");
        sc.close();
    }
}
