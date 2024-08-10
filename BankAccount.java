package Task3;

import java.util.Scanner;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Deposit successful. Your Current balance : " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
    }

    public static class ATM {
        private BankAccount account;
        private Scanner sc;

        public ATM(BankAccount account) {
            this.account = account;
            this.sc = new Scanner(System.in);
        }

        public void showMenu() {
            while (true) {
                System.out.println("ATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print(" Select your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private void checkBalance() {
            System.out.println("Your current balance is: " + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter deposit amount: ");
            double amount = sc.nextDouble();
            account.deposit(amount);
        }

        private void withdraw() {
            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        }

        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000.0);
            ATM atm = new ATM(account);
            atm.showMenu();
        }
    }
}