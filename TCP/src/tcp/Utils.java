package tcp;

import java.io.Closeable;
import java.io.IOException;

/**
 * 工具类
 */
public class Utils {
    public static void close(Closeable... targets) {
        for (Closeable target : targets) {
            if (target != null) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
