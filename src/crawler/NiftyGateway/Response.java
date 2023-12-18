package crawler.NiftyGateway;

import java.util.List;

public class Response {
    private int count;
    private String next;
    private String previous;
    private int totalPages;
    private List<Result> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<Result> getResults() {
        return results;
    }
}
