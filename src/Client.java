import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Client {
  private ArrayList<Character> sendingBuffer = new ArrayList<>();
  private Queue<Character> recievingBuffer = new LinkedList<>();

  public String message = "";
  public int index = 0;
  public int bufferSize = 10;

  public void setMessage(String data) {
    index = 0;
    message = data;
  }

  public void setMessageToSendingBuffer() {
    while (sendingBuffer.size() < bufferSize && index < message.length()) {
      sendingBuffer.add(message.charAt(index));
      index++;
    }
  }

  public int getLengthSendingBuffer() {
    return sendingBuffer.size();
  }

  public char getSendingBuffer() {
    char letter = sendingBuffer.get(0);
    sendingBuffer.remove(0);
    return letter;
  }

  public void setRecievingBuffer(Character letter) {
    recievingBuffer.add(letter);
  }

  public int getRecievingBufferSize() {
    return recievingBuffer.size();
  }

  public char getRecievingBuffer() {
    return recievingBuffer.poll();
  }

}
