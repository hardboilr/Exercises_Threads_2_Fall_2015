package Exercise1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Tobias Jacobsen
 */
public class LoadImage implements Runnable {
    
    private String url;
    private int byteSum;
    
    public LoadImage(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        byte [] byteArray = getBytesFromUrl(url);
        for (byte b : byteArray) {
            byteSum += b;
        }
    }

    protected byte[] getBytesFromUrl(String url) {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }

    public int getByteSum() {
        return byteSum;
    }
}
