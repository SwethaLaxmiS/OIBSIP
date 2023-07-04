package AutomatedTellerMachine;

import java.util.Scanner;

public class Mainclass {
        public static void main(String[] args) {

            ATMInterface op=new ATMImp();
            int atmnumber= 6546;
            int atmpin = 123;
            Scanner in=new Scanner(System.in);
            System.out.println("Bank of XYZ");
            System.out.println("Enter ATM Number : ");
            int atmNumber=in.nextInt();
            System.out.print("Enter Pin : ");
            int pin=in.nextInt();
            if((atmnumber==atmNumber)&&(atmpin==pin)) {
                System.out.println("Registration Successful");
                while (true) {
                    System.out.println("1.Available Balance\n2.Withdraw\n3.Deposit\n4.Transaction History\n5.Transfer\n6.Quit");
                    System.out.println("Enter Your Choice : ");
                    int ch = in.nextInt();
                    if(ch==1){
                        op.viewBalance();

                    }
                    else if(ch==2){
                        System.out.println("Enter the Amount to be withdrawed :");
                        double withdrawAmt=in.nextDouble();
                        op.withdrawAmt(withdrawAmt);


                    }
                    else if(ch==3){
                        System.out.println("Enter the Amount to be deposited :");
                        double depositAmt=in.nextDouble(); //4000
                        op.depositAmt(depositAmt);

                    }
                    else if(ch==4){
                        op.viewTransactionHistory();
                    }

                    else if(ch==5){
                        System.out.println("Enter the amount to be tranferred: ");
                        double transferAmt=in.nextDouble();
                        System.out.println("Enter the recipient name: ");
                        String recipient= in.next();
                        if (transferAmt <= op.getbalance()) {
                            op.transferAmount(transferAmt, recipient);
                        } else {
                            System.out.println("Insufficient balance. Transfer amount exceeding the available balance.");
                        }
                    }
                    else if(ch==6) {
                        System.out.println("Collect your ATM card\n Thank You For Using");
                        System.exit(0);
                    }
                    else {
                        System.out.println("Enter the correct choice");
                    }
                }
            }
            else{
                System.out.println("Incorrect Credentials");
                System.exit(0);
            }
    }
}
