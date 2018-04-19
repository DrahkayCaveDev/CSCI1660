import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


class CheckingAccount {
    // create a fair mutex
    private Semaphore permits = new Semaphore(1, true);
    private int balance;

    public CheckingAccount(int initialBalance)
    {
        balance = initialBalance;
    }

    synchronized public int withdraw(Object amount)
    {
        try {
            permits.acquire();
        } catch (InterruptedException e) {
            // exception prevented acquiring a permit
            return balance;
        }
        if (Integer.parseInt(String.valueOf(amount)) <= balance)
        {
            try {
                Thread.sleep((int) (Math.random()*200));
            }
            catch (InterruptedException ie) {
            }

            balance -= Integer.parseInt(String.valueOf(amount));
        }

        if(balance>0){
            permits.release();
        }

        return balance;
    }
}

class AccountHolder implements Runnable {
    private String name;
    private CheckingAccount account;

    AccountHolder(String name, CheckingAccount account) {
        this.name = name;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " tries to withdraw $10, balance: " +
                    account.withdraw(10));
        }

    }
}

public class Main {
    public static void main(String[] args) {
        CheckingAccount account = new CheckingAccount(100);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new AccountHolder("Actual Owner", account));
        executor.submit(new AccountHolder("Moocher", account));
        executor.submit(new AccountHolder("Thief", account));
        executor.submit(new AccountHolder("Tentacle Monster", account));

    }
}
