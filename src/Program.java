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
    float timeStart = System.currentTimeMillis();
    while (sender.index < sender.message.length()) {
      sender.setMessageToSendingBuffer();
      sendMessage();
      count++;
    }
    showMessage();
    float timeEnd = System.currentTimeMillis();
    out.printf("Time executed %.20f\n", (timeEnd - timeStart));
    out.println("Space: " + (sender.bufferSize * 2));
    out.printf("Used buffer: %d time(s)", +count);
  }

  public void enterMessage() {
    try {
      String message = scanner.nextLine();
      if (message.length() != 0 && message.length() <= 255) {
        sender.setMessage(message);
      } else {
        out.println("The message length must be 1 to 255 charater");
        System.exit(0);
      }
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
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