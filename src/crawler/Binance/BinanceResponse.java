package OOP.Binance;

import java.util.List;

class BinanceResponse {
    private Data data;

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
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
