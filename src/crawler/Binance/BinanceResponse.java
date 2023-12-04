package OOP.Binance;

import java.util.List;

class BinanceResponse {
    private BinanceResponse.Data data;

    public void setData(BinanceResponse.Data data) {
        this.data = data;
    }

    public BinanceResponse.Data getData() {
        return data;
    }

    static class Data {
        private List<CollectionItem> rows;

        public List<CollectionItem> getRows() {
            return rows;
        }

        public void setRows(List<CollectionItem> rows) {
            this.rows = rows;
        }
    }
}
