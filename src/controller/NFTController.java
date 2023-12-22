package controller;

import connectors.GeneralConnector;
import models.Binance;
import models.NiftyGateway;
import models.Opensea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;
import java.util.List;

public class NFTController {
    private final GeneralConnector generalConnector;

    public NFTController() {
        this.generalConnector = new GeneralConnector();
    }

    public List<Binance> getBinanceData() throws Exception {
        return generalConnector.getBinanceData();
    }

    public List<NiftyGateway> getNiftyGatewayData() throws Exception {
        return generalConnector.getNiftyGatewayData();
    }

    public List<Opensea> getOpenseaData() throws Exception {
        return generalConnector.getOpenseaData();
    }

    public void addDataToTableNifty(JTable table, List<NiftyGateway> niftyData) throws Exception {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới

        Object[][] rowData = new Object[niftyData.size()][];
        int i = 0;
        for (NiftyGateway data : niftyData) {
            rowData[i++] = createNiftyRowData(data);
        }
        addRowsToTableModel(model, rowData);
    }

    private Object[] createNiftyRowData(NiftyGateway data) {
        return new Object[]{
                data.getCollection().getNiftyTitle(),
                data.getCollection().getNiftyDisplayImage(),
                data.getAvgSalePrice(),
                data.getTotalNumPrimarySales(),
                data.getTotalVolume(),
                data.getCollection().getNiftyType(),
                data.getFloorPrice()
        };
    }

    private void addRowsToTableModel(DefaultTableModel model, Object[][] rows) {
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    public void addDataToTableBinance(JTable table, List<Binance> binanceData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        Object[][] rowData = new Object[binanceData.size()][];
        int i = 0;
        for (Binance data : binanceData) {
            rowData[i++] = createBinanceRowData(data);
        }
        addRowsToTableModel(model, rowData);
    }

    private Object[] createBinanceRowData(Binance data) {
        return new Object[]{
                data.getTitle(),
                data.getCollectionId(),
                data.getCoverUrl(),
                data.getOwnersCount(),
                data.getItemsCount(),
                data.getFloorPrice(),
                data.getFloorPriceRate(),
                data.getVolume()
        };
    }

    public void addDataToTableOpensea(JTable table, List<Opensea> openseaData) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        Object[][] rowData = new Object[openseaData.size()][];
        int i = 0;
        for (Opensea data : openseaData) {
            rowData[i++] = createOpenseaRowData(data);
        }
        addRowsToTableModel(model, rowData);
    }

    private Object[] createOpenseaRowData(Opensea data) {
        return new Object[]{
                data.getTitle(),
                data.getImage(),
                data.getDiscount(),
                data.getSales(),
                data.getVolume(),
                data.getFloorPrice()
        };
    }

    public void sortTableByName(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(0, Comparator.naturalOrder()); // 0 là chỉ số cột cần sắp xếp
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Sắp xếp theo cột đầu tiên
        sorter.setSortKeys(sortKeys);
    }

    public void sortTableByCollectionOwner(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(1, Comparator.naturalOrder()); // 1 là chỉ số cột cần sắp xếp
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(1, SortOrder.ASCENDING)); // Sắp xếp theo cột thứ hai
        sorter.setSortKeys(sortKeys);
    }

    public void sortTableByCreationDate(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(0, Comparator.naturalOrder()); // 0 là chỉ số cột cần sắp xếp
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)); // Sắp xếp theo cột đầu tiên
        sorter.setSortKeys(sortKeys);
    }

    public void sortTableByPrice(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(1, Comparator.naturalOrder()); // 1 là chỉ số cột cần sắp xếp
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(1, SortOrder.ASCENDING)); // Sắp xếp theo cột thứ hai
        sorter.setSortKeys(sortKeys);
    }
}
