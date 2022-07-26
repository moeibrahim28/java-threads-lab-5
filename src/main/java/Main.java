import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SavingsAccount sa1 = new SavingsAccount();
        Thread thread1 = new Thread(() -> {
            sa1.deposit(2000);
            sa1.withdraw(3000);
        });

        Thread thread2 = new Thread(() -> {
            sa1.deposit(1000);
            sa1.deposit(1000);
            sa1.withdraw(4000);
        });

        Thread thread3 = new Thread(() -> {
            sa1.withdraw(5000);
            sa1.deposit(10000);
            sa1.withdraw(5000);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(sa1);
    }
}
