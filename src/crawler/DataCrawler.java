package crawler;
import java.io.IOException;

public interface DataCrawler {
    void fetchData() throws IOException, InterruptedException;
    void saveData(String filename) throws IOException;

    void run() throws IOException, InterruptedException;
}
