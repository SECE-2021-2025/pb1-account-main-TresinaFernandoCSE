import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //IOExceptions handled by JVM

        //Difference between i/o stream &  reader , writer classes
        //Reader, Writer - input, output as Character (requires 2 bytes)
        //InputStream, OutputStream - input, output as Byte (requires 1 byte)
        //Memory optimization

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String id;
        String name;
        int balance;
        Account acc;
        int choice;
        int accNo;
        int amount;

        System.out.println("Enter no. of Account");
        n = Integer.parseInt(br.readLine());

        Account[] accArr = new Account[n];
        
        /*
         * Primitive |  size    | size in  | range
         * data types|          | in bits  |
         * 
         * byte       - 1 byte  - 8 bits  - (-2^7  to 2^7  - 1)
         * int        - 4 bytes - 32 bits - (-2^31 to 2^31 - 1)
         * long       - 8 bytes - 64 bits - (-2^63 to 2^63 - 1)
         * float      - 4 bytes - 32 bits - (-2^31 to 2^31 - 1)
         * double     - 8 bytes - 64 bits - (-2^63 to 2^63 - 1)
         * char       - 2 bytes - 16 bits - (-2^15 to 2^15 - 1)
         * boolean    - 1 bit (true / false)
         */

        //Java is not a pure OOP language, so wrapper classes were introduced

        /*
         * byte       - Byte
         * int        - Integer
         * long       - Long
         * float      - Float
         * double     - Double
         * char       - Character
         * boolean    - Boolean  
         * BigInteger
         * BigDecimal
         */

         //int a = 10; (a.equals(b)) not possible
         //Integer a = 10; (a.equals(b)) possible

         //Wrapper Classes - to access everything with objects , makes it purely object oriented

        for(int i = 0; i < n; i++) {
            System.out.println("Enter the Account id : ");
            id = br.readLine();

            System.out.println("Enter the Account holder name : ");
            name = br.readLine();

            System.out.println("Enter the balance : ");
            balance = Integer.parseInt(br.readLine());

            acc = new Account(id, name, balance);
            accArr[i] = acc;
        }
        do {
            System.out.println("1.Credit");
            System.out.println("2.Debit");
            System.out.println("3.Amount Transfer");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1 : 
                    display(accArr);
                    System.out.println("Enter Account No :");
                    accNo = Integer.parseInt(br.readLine());
                    acc = accArr[accNo - 1];
                    System.out.println("Enter amount to deposit :");
                    amount = Integer.parseInt(br.readLine());
                    System.out.println("Account credited with " + amount);
                    System.out.println("The balance is " + acc.credit(amount));
                    break;
                
                case 2 :
                    display(accArr);
                    System.out.println("Enter Account No :");
                    accNo = Integer.parseInt(br.readLine());
                    acc = accArr[accNo - 1];
                    System.out.println("Enter amount to withdraw:");
                    amount = Integer.parseInt(br.readLine());
                    Integer updatedBalance = acc.debit(amount);
                    if(updatedBalance != null) {
                        System.out.println("Balance after withdrawal : " + acc.getBalance());
                    }
                    else {
                        System.out.println("ERROR ! : Withdrawal amount exceeds balance");
                        System.out.println("The current balance is " + acc.getBalance());
                    }
                    break;
                
                case 3 :
                    display(accArr);
                    System.out.println("Enter your account no. ");
                    

            }

        }while(choice >= 1 && choice <= 3);
        // for(int i = 0; i < n; i++) {
        //     System.out.println("Acc : " + accArr[i].toString());
        // }
        // System.out.println("Balance before deposit : " + accArr[0].getBalance()); 
        // System.out.println("Balance after deposit : " + accArr[0].credit(500));
        // System.out.println("Balance before withdrawal : " + accArr[0].getBalance());
        // Integer UpdatedBalance = accArr[0].debit(500);
        // if(UpdatedBalance != null) {
        //     System.out.println("Balance after deposit : " + accArr[0].getBalance());
        // }
        // else {
        //     System.out.println("Withdrawal amount exceeds balance");
        // }
         
    }
    public static void display(Account[] accArr) {
        for(int i = 0; i < accArr.length; i++) {
            System.out.println("Acc : " + (i + 1) + " " + accArr[i].toString());
        }
    }
}
