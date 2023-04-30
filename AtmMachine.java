import java.util.*;
 class ATM {
     float Balance;
     int PIN = 5674;

     public void checkPin() {
         System.out.println("Enter Your Pin");
         Scanner sc = new Scanner(System.in);
         int enterPin = sc.nextInt();
         if (enterPin == PIN) {
             menu();
         } else {
             System.out.println("Enter a valid Pin");
         }
     }

     public void menu() {
         System.out.println("Enter Your Choice");
         System.out.println("1, Check A/C Balance");
         System.out.println("2, Withdraw Money");
         System.out.println("3, Deposit Money");
         System.out.println("4, EXIT");
         Scanner sc = new Scanner(System.in);
         int opt = sc.nextInt();
         if (opt == 1) {
             checkBalace();
         } else if (opt == 2) {
             withdrawMoney();
         } else if (opt == 3) {
             depositMoney();
         } else if (opt == 4) {
           return;
         } else {
             System.out.println("Enter a valid choice");
         }
     }

     public void checkBalace() {
         System.out.println("Balance: " + Balance);
         menu();
     }
  public void withdrawMoney(){
      System.out.println("Enter Amount to Withdraw: ");
      Scanner sc = new Scanner(System.in);
      float amount = sc.nextInt();
      if(amount>Balance) {
          System.out.println("Insufficient Balance");
      }else {
          Balance = Balance - amount;
          System.out.println("Money Withdrawl Successful");
      }
      menu();
      }
      public void depositMoney(){
          System.out.println("Enter the Amount: ");
          Scanner sc = new Scanner(System.in);
          float amount = sc.nextFloat();
          Balance = Balance + amount;
          System.out.println("Money Deposit Successfully");
                 menu();
          }
 }
public class AtmMachine {
     public static void main(String[] args) {
      ATM obj = new ATM();
      obj.checkPin();

    }
    }

