import java.io.PrintStream;
import java.util.Scanner;

public class Program {
  PrintStream out = System.out;
  Scanner scanner = new Scanner(System.in);

  Client sender = new Client();
  Client receiver = new Client();

  public void run() {
    int count = 0;
    out.print("Enter message here: ");
    enterMessage();
    while (sender.index < sender.message.length()) {
      sender.setMessageToSendingBuffer();
      sendMessage();
      count++;
    }
    showMessage();
    out.printf("Used buffer: %d time(s)", +count);
  }

  public void enterMessage() {
    String message = scanner.nextLine();
    sender.setMessage(message);
  }

  public void sendMessage() {
    int size = sender.getLengthSendingBuffer();
    for (int index = 0; index < size; index++) {
      char letter = sender.getSendingBuffer();
      receiver.setRecievingBuffer(letter);
    }
  }

  public void showMessage() {
    String message = "";
    while (receiver.getRecievingBufferSize() != 0) {
      message += receiver.getRecievingBuffer();
    }
    out.println("Reciever Message: " + message);
  }

}