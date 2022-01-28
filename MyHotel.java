package BillApplication;

import java.util.*;
import java.util.stream.Collectors;

public class MyHotel extends BasicHotel
{
    ArrayList<Bill> al = new ArrayList<Bill>();

    Scanner sc = new Scanner(System.in);

    String itemName;
    int price,subtotal, grandTotal;
    double tax, totalAndTax;
    double tip = 0.00;
    String name, email, choice,choice2;
    int ch, quantity;
    char cho = 'Y';
    char cho2 = 'Y';

    @Override
    void displayMenu()
    {
        //can use \n to reduce lines of code
        System.out.println("****************************************");
        System.out.println("                 Menu                   ");
        System.out.println("****************************************");
        System.out.println("SlNo           Item Name           Price");
        System.out.println("****************************************");
        System.out.println(" 1               Coffee              $5 ");
        System.out.println(" 2               Tea                 $4 ");
        System.out.println(" 3               Soft Drink          $3 ");
        System.out.println(" 4               Water               $2 ");
        System.out.println("****************************************");
        System.out.println("****************************************");
    }

    @Override
    void getUserDetails() {
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter email address");
        email = sc.nextLine();
    }

    @Override
    void getUserInput()
    {
        while(cho == 'Y'){
            System.out.print("Please enter the serial no of item you want to buy: ");
            ch = sc.nextInt();
            System.out.print("Please enter the amount you want to buy: ");
            quantity = sc.nextInt();

            calculate(ch, quantity);

            //ask to continue
            System.out.print("Want to buy more items? (y/n): ");
            choice = sc.next();
            choice = choice.toUpperCase();
            cho = choice.charAt(0);
        }

        while(cho == 'N'){
            System.out.println( "Your bill is: " + grandTotal);
            System.out.println( "Your GST is: " + tax);
            System.out.println( "Would you like to tip? (y/n)");
            choice2 = sc.next();
            choice2 = choice2.toUpperCase();
            cho2 = choice2.charAt(0);
            if(cho2 == 'Y')
            {
                System.out.print( "Please enter tip amount: ");
                tip = sc.nextDouble();
            }
            break;
        }
    }

    @Override
    void calculate(int ch, int quantity)
    {
        switch(ch){
            case 1:
                itemName = "Coffee     ";
                price = 5;
                subtotal = quantity * price;
                break;
            case 2:
                itemName = "Tea        ";
                price = 4;
                subtotal = quantity * price;
                break;
            case 3:
                itemName = "Soft Drink ";
                price = 3;
                subtotal = quantity * price;
                break;
            case 4:
                itemName = "Water      ";
                price = 2;
                subtotal = quantity * price;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }

        al.add(new Bill(itemName,price,quantity,subtotal));
        grandTotal += subtotal;
        tax = grandTotal*.07;
        totalAndTax = grandTotal*1.07;

    }

    @Override
    void print()
    {
//        if(userTip > tip){
//            tip = userTip;
//        }

        System.out.println("\n\n");

        System.out.println("__________________________________________");
        System.out.println("Bill No: "  +  (Math.abs(new Random().nextInt())) );
        System.out.println("Customer Name:    " + name      );
        System.out.println("Customer Email:    " + email      );
        System.out.println("__________________________________________");
        System.out.println("Item        Price     Quantity    Subtotal");
        System.out.println("__________________________________________");
        for(Bill b : al){
                System.out.println(b);
        }
        System.out.println("__________________________________________");
        System.out.println( "Your bill is:                       " + grandTotal);
        System.out.println( "GST @ 7% :                           " + String.format("%.2f", tax));
        System.out.println("__________________________________________");
        System.out.println( "Total:                             " + String.format("%.2f", totalAndTax));
        System.out.println( "Tip amount:                             " + String.format("%.2f", tip));
    }
}
