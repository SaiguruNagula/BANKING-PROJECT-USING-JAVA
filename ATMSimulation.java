import java.util.*;
public class ATMSimulation {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a sample account
        Account account = new Account(10378, "Labdhi Shah", 10000000.00, "2604");
        Account otherAccount = new Account(10360, "SaiGuru Nagula", 50000.00, "1801");


        System.out.println("                     ************************************");
        System.out.println("                     *            WELCOME               *");
        System.out.println("                     ************************************");
        System.out.println("                     *         SWISS BANK               *");
        System.out.println("                     ************************************");
        System.out.println("                     ************************************");
       

        System.out.println("enter account no");
        int acc = scanner.nextInt();

        if(acc==10378){
        System.out.print("Enter PIN to access your account: ");
        String inputPin = scanner.next();
      
        if (!account.validatePin(inputPin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        account.displayAccountInfo();
    

    

        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transfer Money");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.next();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.next();
                    account.changePin(oldPin, newPin);
                    break;
                case 5:
                    account.displayMiniStatement();
                    break;
                case 6:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(otherAccount, transferAmount);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    else if(acc==10360){
        System.out.print("Enter PIN to access your account: ");
        String inputPin = scanner.next();
      
        if (!otherAccount.validatePin(inputPin)) {
            System.out.println("Invalid PIN. Access denied.");
            return;
        }

        otherAccount.displayAccountInfo();
    

    

        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Mini Statement");
            System.out.println("6. Transfer Money");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    otherAccount.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    otherAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    otherAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.next();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.next();
                    otherAccount.changePin(oldPin, newPin);
                    break;
                case 5:
                    otherAccount.displayMiniStatement();
                    otherAccount.checkBalance();
                    break;
                case 6:
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    otherAccount.transfer(account, transferAmount);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
    else{
        System.out.println("Invalid choice. Please try again.");
    }

    }
    
}
