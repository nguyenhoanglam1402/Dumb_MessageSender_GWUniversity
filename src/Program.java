import java.io.PrintStream;
import java.util.Scanner;

public class Program {
  PrintStream out = System.out;
  Scanner scanner = new Scanner(System.in);

  Client sender = new Client();
  Client receiver = new Client();

  public void run() {
    while (!sender.isBufferFull()) {
      enterMessage();
    }
    showMessage();
  }

  public void enterMessage() {
    out.println("Enter message you wanna send:");
    String message = scanner.nextLine();
    sender.setMessage(message);
    sendMessage();
  }

  public void sendMessage() {
    if (sender.isBufferFull()) {
      receiver.setRecievingBuffer(sender.getSendingBuffer());
    }
  }

  public void showMessage() {
    out.println("Recieved: " + receiver.getMessage());
  }
}