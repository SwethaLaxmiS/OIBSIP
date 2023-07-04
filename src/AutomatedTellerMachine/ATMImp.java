package AutomatedTellerMachine;

import java.util.HashMap;
import java.util.Map;

public class ATMImp implements ATMInterface{
    ATM atm=new ATM();
    Map<Double,String> TransactionHistory=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance : " +atm.getBalance());
    }
    @Override
    public void withdrawAmt(double withdrawAmt) {
        if(withdrawAmt%500==0) {
            if (withdrawAmt <= atm.getBalance()) {
                TransactionHistory.put(withdrawAmt, ": Withdraw");
                System.out.println("Amount of Rupee " + withdrawAmt + " to be collected");
                atm.setBalance(atm.getBalance() - withdrawAmt);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance");
            }
        }
        else{
            System.out.println("Enter in multiples of 500");
        }

    }
    @Override
    public void depositAmt(double DepositAmt) {
        TransactionHistory.put(DepositAmt, ":Deposit");
        System.out.println("Amount of Rupee " +DepositAmt+ " Deposited Successfully");
        atm.setBalance(atm.getBalance()+DepositAmt);
        viewBalance();

    }

    @Override
    public void viewTransactionHistory() {
        for(Map.Entry<Double,String> m:TransactionHistory.entrySet()){
            System.out.println(m.getKey()+ ""+m.getValue());
        }

    }

    @Override
    public void transferAmount(double transferAmt, String recipient) {
        if (transferAmt <= atm.getBalance()) {
            TransactionHistory.put(transferAmt, ": Transfer to " + recipient);
            System.out.println("Amount of Rupee " + transferAmt + " transferred to " + recipient);
            atm.setBalance(atm.getBalance() - transferAmt);
            viewBalance();
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public double getbalance() {
        return atm.getBalance();
    }
}
