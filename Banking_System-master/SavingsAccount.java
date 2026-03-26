class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(int accountNumber,String customerName, double balance, double interestRate){
        super(accountNumber, customerName, balance);
        this.interestRate = interestRate;
    }
    
    public double getInterestRate(){
        return interestRate;
    }
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest(){
        return getBalance()*interestRate/100;
    }
}
