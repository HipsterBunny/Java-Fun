import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Fibfin implements Runnable
{
  private int counter;  // How far the thread has executed
  private int limit;    // Where counter will stop
  private final CountDownLatch done; // used to watch thread

  // Constructor
  private Fibfin(int countTo, CountDownLatch done)
  {
    counter = 1;
    limit = countTo; // limit set to user input number
    this.done = done;
  }
	
  // When run() finishes, the thread teminates
  public void run()
  {
      // while counter is <= user input number, run the 
      // fibonacci function with the counter value
      for (counter=1; counter <= limit; counter++)
      {
        // if the counter is at the end, print a line (formatting)
        if (counter == limit) 
          System.out.println(fib(counter));
        // if not just insert a comma & space between numbers
        else
          System.out.print(fib(counter) +", ");
      }
      done.countDown();
      System.out.println("Child Thread Terminated");
    
  }

  // Use recursion to find fibonacci sequence
  public static int fib(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        return fib(number-1) + fib(number -2); // Recursive call
    }

  // The main method: Executed when the program is started
  public static void main(String[] args)
  {
    // Input to print Fibonacci series up to that many numbers
    System.out.print("Enter number of Fibonacci series to print: ");
    int number = new Scanner(System.in).nextInt();
      
    System.out.println("Fibonacci series to " + number +" numbers: ");

    // create to watch the threads and see when it's done
    CountDownLatch done = new CountDownLatch(1);
    // Create fib calculating thread
    Thread childThread = new Thread(new Fibfin(number, done));

    childThread.start();
    
    try{
        done.await(); // Will wait for done.countDown() to be called once
    }
    catch (InterruptedException ex) {
        System.out.println("Error occured waiting for child thread to Terminate.");
    }
    System.out.println("Parent Thread Terminated");
  }
}
