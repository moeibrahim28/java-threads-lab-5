import java.util.concurrent.locks.ReentrantLock;

public class SavingsAccount {

    private long total = 0;
    private final int accountNumber;
    private ReentrantLock mutex=new ReentrantLock();

    public SavingsAccount() {
        accountNumber = hashCode();
    }

    public boolean withdraw(long amount) {
        mutex.lock();
        if (total >= amount) {
            total -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber + ". New balance is $" + total);
            mutex.unlock();
            return true;
        } else {
            System.out.println("Could not withdraw $" + amount + " since the balance of account " + accountNumber+ " is $" + total);
            mutex.unlock();
            return false;
        }

    }

    public void deposit(long amount) {
        mutex.lock();
        total += amount;
        System.out.println("Deposited $" + amount + ". New account balance for " + accountNumber + " is $" + total);
        mutex.unlock();
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                "," + "total=$" + total +
                '}';
    }
}