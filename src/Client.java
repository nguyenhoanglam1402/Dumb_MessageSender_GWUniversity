import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
  private ArrayList<Character> sendingBuffer = new ArrayList<>();
  private Queue<Character> recievingBuffer = new LinkedList<>();

  public boolean isBufferFull() {
    if (sendingBuffer.size() >= 10) {
      return true;
    }
    return false;
  }

  public void setMessage(String message) {
    for (int index = 0; index < message.length(); index++) {
      if (!isBufferFull()) {
        sendingBuffer.add(message.charAt(index));
      }
    }
  }

  public ArrayList<Character> getSendingBuffer() {
    return sendingBuffer;
  }

  public void setRecievingBuffer(ArrayList<Character> message) {
    for (Character letter : message) {
      recievingBuffer.add(letter);
    }
  }

  public String getMessage() {
    String message = "";
    for (Character character : recievingBuffer) {
      message += character;
    }
    return message;
  }
}
