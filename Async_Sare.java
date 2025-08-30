import java.util.Scanner;

public class Async_Sare {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean pinCorrect = false; // loop 
        double startinBalance = 1000; // starting balance of account
        String a, b; // transaction variable 

        // loop if incorrect answer
        while (!pinCorrect) {
            System.out.print("Please Enter Your Pin: ");
            String pinInput = input.nextLine(); // read as string 

            try {
                int pinPassword = Integer.parseInt(pinInput); // convert to Int
                switch (pinPassword) {
                    case 123456:
                        System.out.println("Welcome to SIT Bank!");
                        pinCorrect = true;
                        break;
                    default:
                        System.out.println("Incorrect PIN. Please Try Again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }

        // transaction selection
        boolean validTransaction = false;

        while (!validTransaction) {
            System.out.println("Please Select Your Transaction");
            System.out.println("[A] Deposit");
            System.out.println("[B] Withdrawal");
            System.out.print("Select Transaction: ");

            String userTransaction = input.nextLine().trim().toUpperCase(); // read input safely

            switch (userTransaction) {
                case "A": // deposit case 
                    System.out.println("You have Selected: Deposit");
                    double newDeposit = 0;
                    boolean validDeposit = false;

                    while (!validDeposit) {
                        System.out.print("Enter amount for deposit: ");
                        String depositInput = input.nextLine();
                        try { //to run but user input maybe different and out of option. Without try catch the code crashes 
                            newDeposit = Double.parseDouble(depositInput);
                            if (newDeposit <= 0) {
                                System.out.println("Amount must be greater than 0. Please Try again.");
                        } else {
                                validDeposit = true;
                            }
                     } catch (NumberFormatException e) { // if error happens 
                            System.out.println("Invalid input. Enter a valid number.");
                        }
                    }

                    startinBalance += newDeposit;
                    System.out.println("New Balance: " + startinBalance);
                    validTransaction = true; // exit loop
                    break;

                case "B": // withdrawal case 
                    System.out.println("You have Selected: Withdrawal");
                    double newWithdraw = 0;
                    boolean validWithdraw = false;

                    while (!validWithdraw) {
                        System.out.print("Enter Withdrawal Amount: ");
                        String withdrawInput = input.nextLine();
                        try { //to run but user input maybe different and out of option. Without try catch the code crashes 
                            newWithdraw = Double.parseDouble(withdrawInput);
                         if (newWithdraw <= 0) {
                                System.out.println("Amount must be greater than 0. Try again.");
                         } else if (newWithdraw > startinBalance) {
                                System.out.println("Your withdrawal amount is higher than your account balance. Please try again!");
                        } else {
                                validWithdraw = true;
                            }
                        } catch (NumberFormatException e) {  // if error happens
                            System.out.println("Invalid input. Enter a valid number.");
                        }
                    }
                    //output and subtract transaction 
                    startinBalance -= newWithdraw;
                    System.out.println("You have Withdrawn: " + newWithdraw);
                    System.out.println("Your updated balance is: " + startinBalance);
                    validTransaction = true; // exit loop
                    break;

                default:
                    System.out.println("Invalid option! Please select either [A] Deposit or [B] Withdrawal.");
                    // loop continues
            }
        }

        input.close();
    }
}
