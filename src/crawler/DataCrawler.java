package OOP;
import java.io.IOException;

public interface DataCrawler {
    void fetchData() throws IOException, InterruptedException;
    void processData();
    void saveData(String filename) throws IOException;
}
