package com.company;

public class Main {

    public static void main(String[] args) throws Exception,IllegalBalance {
        //Creating an array of BankAccount pointers, each "pair" points to a different object (using polymorphism)
        BankAccount[] accountTypes = new BankAccount[10];
        accountTypes[0] = new ServiceChargeChecking("1234","Shahar", "123456", 10000);
        accountTypes[1] = new ServiceChargeChecking("1234","Shahar", "123456", 10000,10);
        accountTypes[2] = new NoServiceChargeChecking("8910","Niria", "456789", 10000);
        accountTypes[3] = new NoServiceChargeChecking("3791","Orly", "456132", 10000, 3000);
        accountTypes[4] = new InterestChecking("1112","Dani", "963852", 10000);
        accountTypes[5] = new InterestChecking("1213","Noa", "741852", 10000, 6000, 2);
        accountTypes[6] = new SavingsAccount("1426","Guy", "456852", 10000);
        accountTypes[7] = new SavingsAccount("7894","Dor", "456725", 10000, 3);
        accountTypes[8] = new HighInterestSavings("6486","Omer", "159753", 10000);
        accountTypes[9] = new HighInterestSavings("6482","Linor", "456951", 10000, 4, 1000);

        //Printing the accounts details
       System.out.println("****************Printing the accounts details******************");
       for (int i = 0; i < accountTypes.length; i++) {
           String accountDetails = "********************************\n";
           accountDetails  += accountTypes[i].getClass().toString();
           accountDetails = accountDetails.replaceAll("(.)([A-Z])", "$1 $2");
           accountDetails = accountDetails.replace("class", "Account Type:");
           accountDetails += "\n" + accountTypes[i].toString();
           System.out.println(accountDetails);
        }

        //Printing the accounts details after an arbitrary deposit
        System.out.println("*************Printing the accounts details after an arbitrary deposit************");
       for (int i = 0; i < accountTypes.length; i++) {
           accountTypes[i].addToBalance(461);
           String accountDetails = "********************************\n";
           accountDetails += accountTypes[i].getClass().toString();
           accountDetails = accountDetails.replaceAll("(.)([A-Z])", "$1 $2");
           accountDetails = accountDetails.replace("class", "Account Type:");
           accountDetails += "\nAccount details after deposit:\n" + accountTypes[i].toString();
           System.out.println(accountDetails);
        }

        //Printing the accounts details after withdrawing the deposited amount
        System.out.println("***************Printing the accounts details after withdrawing the deposited amount***************");
        for (int i = 0; i < accountTypes.length; i++) {
            accountTypes[i].withdraw(461);
            String accountDetails = "********************************\n";
            accountDetails += accountTypes[i].getClass().toString();
            accountDetails = accountDetails.replaceAll("(.)([A-Z])", "$1 $2");
            accountDetails = accountDetails.replace("class", "Account Type:");
            accountDetails +=  "\nAccount details after withdrawal:\n" + accountTypes[i].toString();
            System.out.println(accountDetails);
        }

        //Printing the accounts details after withdrawing the deposited amountt (note: in NoServiceCheckingAccount monthly management
        //does nothing, as there's neither commission nor interest that can affect the balance
       System.out.println("*******************Printing the accounts details after withdrawing the deposited amount**************");
       for (int i = 0; i < accountTypes.length; i++) {
            accountTypes[i].monthlyManage();
           String accountDetails = "********************************\n";
           accountDetails += accountTypes[i].getClass().toString();
           accountDetails = accountDetails.replaceAll("(.)([A-Z])", "$1 $2");
           accountDetails = accountDetails.replace("class", "Account Type:");
           accountDetails = accountDetails + "\nAccount details after monthly management:\n" + accountTypes[i].toString();
            System.out.println(accountDetails);
        }

        //Demonstrating the equals method
        System.out.println("*************Checking equals methods********");
        System.out.print(accountTypes[0].equals(accountTypes[1]));
        System.out.println("\n");

        //Demonstrating the exception:
        System.out.println("*************Checking Exeptions methods********");
        accountTypes[0].withdraw(15000);
    }

}
