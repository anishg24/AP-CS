package Bank_Account_Lab;

public class BankAccount {
    private String password;
    private double balance;
    private int attempts;

    BankAccount(){
        this.password = "0zero1one2";
        this.balance = 0;
        this.attempts = 0;
    }

    BankAccount(String pw, double balance){
        this.password = pw;
        this.balance = balance;
    }

    private boolean check_PW(String pw){
        return this.password.equals(pw);
    }

    private boolean check_all(String pw){
        return (check_PW(pw) && attempts < 3);
    }

    public int getAttempts() {
        return attempts;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(String pw, double amt){
        boolean result = false;
        if(check_all(pw)){
            if (balance - amt >= 0){
                balance -= amt;
                attempts = 0;
                result = true;
            } else {
                attempts ++;
            }
        }
        return result;
    }

    public void reset_PW(String old_PW, String new_PW){
        if (check_all(old_PW)){
            password = new_PW;
            attempts = 0;
        } else {
            attempts ++;
        }
    }

    public void deposit(String pw, double amt){
        if (check_all(pw)){
            balance += amt;
        } else {
            attempts ++;
        }
    }

}
