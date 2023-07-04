package AutomatedTellerMachine;

public interface ATMInterface {
    public void viewBalance();
    public void withdrawAmt(double withdrawAmt);
    public void depositAmt(double DepositAmt);
    public void viewTransactionHistory();
    public void transferAmount(double transferAmt,String recipient);
    double getbalance();

}
