package Bank_Account_Lab;

public class Kiosk {
    public static void main(String[] args) {
//        BankAccount checking = new BankAccount();
//        BankAccount saving = new BankAccount();
//
//        checking.reset_PW("0zero1one2", "passw0rd");
//        saving.reset_PW("0zero1one2", "passw0rd");
//
//        BankAccount spending = new BankAccount();
//        spending.reset_PW("0zero1one2", "passw0rd");
//        spending.deposit("passw0rd",400);
//
//        checking.deposit("passw0rd",4200);
//        saving.deposit("passw0rd",2500);
//
//        checking.withdraw("passw0rd", checking.getBalance());
//
//        saving.withdraw("w", checking.getBalance());
//        saving.withdraw("we", checking.getBalance());
//        saving.withdraw("The proletariat will rise again!", checking.getBalance());
//
//        System.exit(69);

        BankAccount checking = new BankAccount("passw0rd", 4200);
        BankAccount saving = new BankAccount("passw0rd", 2500);

        BankAccount spending = new BankAccount("passw0rd", 400);

        checking.withdraw("passw0rd", checking.getBalance());

        saving.withdraw("w", checking.getBalance());
        saving.withdraw("we", checking.getBalance());
        saving.withdraw("The proletariat will rise again!", checking.getBalance());

//        System.exit(69);
    }
}
