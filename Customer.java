package ATM_Machine;
import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.concurrent.Callable;

public class Customer {
    // 3 usages
    private String acc_no;
    // 3 usages
    private String pin;
    // 3 usages
    private double balance;

    // 1 usage
    public Customer(String acc_no, String pin, double balance) {
        super();
        this.acc_no = acc_no;
        this.pin = pin;
        this.balance = balance;
    }

    // 1 usage
    public String getAccountNo() {
        return acc_no;
    }

    public void setAccountNo(String acc_no) {
        this.acc_no = acc_no;
    }

    // 1 usage
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    // 7 usages
    public double getBalance() {
        return balance;
    }

    // 2 usages
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
// 4 usages 2 inheritors
class StandardAtm {
    // 3 usages
    private Customer cust1;
    Boolean accesssed = false;

    // constructor
    // 3 usages
    public StandardAtm(Customer customer) {

        this.cust1 = customer;
    }

    // 2 usages
    public boolean accessAcc(String acc_no1, String pin1) {
        if (cust1.getAccountNo().equals(acc_no1) && cust1.getPin().equals(pin1)) {
            return true;
        } else {
            return false;
        }
    }
}
// 4 usages
  class WithDrawsAtm extends StandardAtm {
    // 5 usages
    private Customer cust1;
    // 2 usages
    private double balance;

    // 2 usages
    public WithDrawsAtm(Customer customer) {
        super(customer);
        this.cust1 = customer;
        this.balance = balance;
    }

    // 2 usages
    public void withdrawCash(int amount1) {
        if (amount1 <= cust1.getBalance()) {
            cust1.setBalance(cust1.getBalance() - amount1);
            System.out.println("Withdrawn Completed. New Balance is : " + cust1.getBalance());
        } else {
            System.out.println("Transaction Cancelled due to insufficient balance.");
        }
    }
}
// 4 usages
class DepositAtm extends StandardAtm {
    // 4 usages
    private Customer cust1;
    // 2 usages
    private double balance;

    // constructor
    // 2 usages
    public DepositAtm(Customer customer) {
        super(customer);
        this.cust1 = customer;
        this.balance = balance;
    }

    // 2 usages
    public void depositCash(int amount) {
        if (amount > 0 && amount <= 1000) {
            cust1.setBalance(cust1.getBalance() + amount);
            System.out.println("Deposit Completed. New Balance: " + cust1.getBalance());
        } else {
            System.out.println("Transaction Cancelled due to insufficient balance. Please retry.");
        }
    }
}
 class ATM2 {
    public static void main(String[] args) {
        Customer cust1 = new Customer("123456", "1234", 10000);
        StandardAtm SA = new StandardAtm(cust1);
        boolean isDisabled = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        String acc_no1 = sc.next();
        System.out.print("Enter PIN Number : ");
        String pin1 = sc.next();
        if (SA.accessAcc(acc_no1, pin1) == true) {
            System.out.println("Welcome, Your Account Balance is : " + cust1.getBalance());
                    /* for deposit money press 1.
                    for withdrawl money press 2.
                    for change PIN press 3.
                      */
            System.out.println("Pleasse select any one.\n" +
                    "1. Deposit Money.\n" +
                    "2. Withdrawl Money.\n" +
                    "3. Change PIN.\n");

            int press = sc.nextInt();
            if (press == 1) {
                System.out.println("Enter Deposit Amount : ");
                int amount = sc.nextInt();
                DepositAtm DA = new DepositAtm(cust1);
                DA.depositCash(amount);
            } else if (press == 2) {
                System.out.println("Enter withdrawl Amount : ");
                int amount1 = sc.nextInt();
                WithDrawsAtm WA = new WithDrawsAtm(cust1);
                WA.withdrawCash(amount1);

            } else if (press == 3) {
                System.out.print("Enter new PIN : ");
                String newPIN = sc.next();
                System.out.print("Confirm PIN : ");
                String confirm_PIN = sc.next();
                if (newPIN.equals(confirm_PIN)) {
                    System.out.println("New PIN is set !");
                    pin1 = newPIN;
                    System.out.println("New PIN : " + pin1);
                } else {
                    System.out.println("Wrong Confirmation PIN, Please again do change PIN Process !");
                }
            } else {
                System.out.println("Wrong Input !");
            }
        } else {
            System.out.println("Invalid Account Number & PIN !");
            for(int count = 0; count < 2; count++){
                System.out.println("Enter account number : ");
                acc_no1 = sc.next();
                System.out.println("Enter PIN number : ");
                pin1 = sc.next();
                if(SA.accessAcc(acc_no1 , pin1) == true) {
                    System.out.println("Welcome, Your Account is : " + cust1.getBalance());

                    /*
                    for deposit money press 1.
                    for withdrawl money press 2.
                    for change pin press 3.
                     */
                    System.out.println("Pleasse select any one.\n" +
                            "1. Deposit Money.\n" +
                            "2. Withdrawl Money.\n" +
                            "3. Change PIN.\n");

                    int press = sc.nextInt();
                    if (press == 1) {
                        System.out.println("Enter Deposit Amount : ");
                        int amount = sc.nextInt();
                        DepositAtm DA = new DepositAtm(cust1);
                        DA.depositCash(amount);
                    } else if (press == 2) {
                        System.out.println("Enter withdrawl Amount : ");
                        int amount1 = sc.nextInt();
                        WithDrawsAtm WA = new WithDrawsAtm(cust1);
                        WA.withdrawCash(amount1);
                    } else if (press == 3) {
                        System.out.print("Enter new PIN : ");
                        String newPIN = sc.next();
                        System.out.print("Confirm PIN : ");
                        String confirm_PIN = sc.next();
                        if (newPIN.equals(confirm_PIN)) {
                            System.out.println("New PIN is set !");
                            pin1 = newPIN;
                            System.out.println("New PIN : " + pin1);
                        } else {
                            System.out.println("Wrong Confirmation PIN, Please again do change PIN Process !");
                        }
                    } else {
                        System.out.println("Wrong Input !");
                    }
                    break;
                }else{
                    System.out.println("Invalid Account Number & PIN !");
                    isDisabled = true;
        }
        }
    if(isDisabled){
        System.out.println("Your account is disabled !");
    }
}
}
}
