public class SavingsAccount {

    private long total = 0;
    private final int accountNumber;

    public SavingsAccount() {
        accountNumber = hashCode();
    }

    public synchronized boolean withdraw(long amount) {
        if (total >= amount) {
            total -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
            return true;
        } else {
            System.out.println("Could not withdraw $" + amount + " since the balance of account " + accountNumber+ " is $" + total);
            return false;
        }
    }

    public synchronized void deposit(long amount) {
        total += amount;
        System.out.println("Deposited $" + amount + ". New account balance for " + accountNumber + " is $" + total);
    }

    public synchronized long getTotal() {
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