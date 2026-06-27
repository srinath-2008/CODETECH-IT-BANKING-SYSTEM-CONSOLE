import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private long accountNumber;
    private double balance;

    public BankAccount(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayDetails() {
        System.out.println("\nAccount Details");
        System.out.println("Holder Name : " + accountHolder);
        System.out.println("Account No  : " + accountNumber);
        System.out.println("Balance     : ₹" + balance);
    }
}
class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== BANKING SYSTEM ===");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, accNo, balance);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
