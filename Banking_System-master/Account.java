class Account{

    private int accountNumber;
    private double balance;
    private String customerName;

    public Account(int accountNumber,String customerName, double balance){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getBalance(){
        return balance;
    }
    protected void setBalance(double balance){
        this.balance = balance;
    }

    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: "+amount);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -=amount;
            System.out.println("Withdrawn: "+amount);
        }
        else{
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public double calculateInterest(){
        return 0;
    }

    public void displayAccount(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Balance: "+balance);
    }
}