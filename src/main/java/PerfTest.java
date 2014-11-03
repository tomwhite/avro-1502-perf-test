import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.avro.examples.data.User;

public class PerfTest {
  public static void main(String[] args) throws IOException {
    User[] users = new User[10000000];
    for (int i = 0; i < users.length; i++) {
      users[i] = new User("name" + i, 1000L, "red");
    }
    long start = System.currentTimeMillis();
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bout);
    for (int i = 0; i < users.length; i++) {
      out.writeObject(users[i]);
    }
    out.close();
    long end = System.currentTimeMillis();
    long time = end - start;
    System.out.println("Time (ms): " + time);
  }
}
