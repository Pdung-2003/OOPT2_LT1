package controller;

import connectors.GeneralConnector;
import models.Binance;
import models.NiftyGateway;
import models.Opensea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
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
                data.getFloorPrice(),
                data.getCollection().getNiftyType()
        };
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
                data.getVolume(),
                data.getFloorPrice(),
                data.getFloorPriceRate(),
                data.getItemsCount()
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

    private void addRowsToTableModel(DefaultTableModel model, Object[][] rows) {
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    public void sortTableByTitle(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(0, Comparator.comparing(o -> o.toString().toLowerCase()));
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }

    public void sortTableByVolume(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(4, Comparator.comparingDouble(o -> Double.parseDouble(o.toString())));
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(4, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }

    public void sortTableByPrice(JTable table) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        sorter.setComparator(5, Comparator.comparingDouble(o -> Double.parseDouble(o.toString())));
        table.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = List.of(new RowSorter.SortKey(5, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }



    public List<NiftyGateway> searchNiftyGateway(String selectedSearchMethod, String searchInput) {
        try {
            List<NiftyGateway> niftyData = generalConnector.getNiftyGatewayData();

            List<NiftyGateway> searchResults = new ArrayList<>();
            for (NiftyGateway item : niftyData) {
                String niftyTitle = item.getCollection().getNiftyTitle().toLowerCase();
                String searchInputLower = searchInput.toLowerCase();
                switch (selectedSearchMethod) {
                    case "Tên NFT":
                        if (niftyTitle.contains(searchInputLower)) {
                            searchResults.add(item);
                        }
                        break;
                    case "Giá bán nhỏ hơn":
                        try {
                            double searchPrice = Double.parseDouble(searchInput);
                            if (item.getAvgSalePrice() < searchPrice) {
                                searchResults.add(item);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Số lượng giao dịch nhỏ hơn":
                        try {
                            double searchQuantity = Double.parseDouble(searchInput);
                            if ( Double.parseDouble(item.getTotalVolume()) < searchQuantity) {
                                searchResults.add(item);
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
            return searchResults;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Binance> searchBinance(String selectedSearchMethod, String searchInput) {
        try {
            List<Binance> binanceData = generalConnector.getBinanceData();

            List<Binance> searchResults = new ArrayList<>();
            for (Binance item : binanceData) {
                String binanceTitle = item.getTitle().toLowerCase();
                String searchInputLower = searchInput.toLowerCase();
                switch (selectedSearchMethod) {
                    case "Tên NFT":
                        if (binanceTitle.contains(searchInputLower)) {
                            searchResults.add(item);
                        }
                        break;
                    case "Giá bán nhỏ hơn":
                        try {
                            String floorPrice = item.getFloorPrice();
                            if (floorPrice != null && searchInput != null) {
                                double floorPriceValue = Double.parseDouble(floorPrice);
                                double searchPriceValue = Double.parseDouble(searchInput);

                                if (floorPriceValue < searchPriceValue) {
                                    searchResults.add(item);
                                }
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Số lượng giao dịch nhỏ hơn":
                        try {
                            String volume = item.getVolume();
                            if (volume != null) {
                                double searchQuantity = Double.parseDouble(searchInput);
                                double itemVolume = Double.parseDouble(volume);

                                if (itemVolume < searchQuantity) {
                                    searchResults.add(item);
                                }
                            }
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
            return searchResults;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Opensea> searchOpensea(String selectedSearchMethod, String searchInput) {
        try {
            List<Opensea> openseaData = generalConnector.getOpenseaData();

            List<Opensea> searchResults = new ArrayList<>();
            for (Opensea item : openseaData) {
                String openseaTitle = item.getTitle().toLowerCase();
                String searchInputLower = searchInput.toLowerCase();
                switch (selectedSearchMethod) {
                    case "Tên NFT":
                        if (openseaTitle.contains(searchInputLower)) {
                            searchResults.add(item);
                        }
                        break;
                    case "Giá bán nhỏ hơn":
                        try {
                            String floorPrice = item.getFloorPrice();
                            if (floorPrice != null && !floorPrice.isEmpty()) {
                                String[] parts = floorPrice.split(" ");
                                double price = Double.parseDouble(parts[0]);
                                double searchPrice = Double.parseDouble(searchInput);
                                if (price < searchPrice) {
                                    searchResults.add(item);
                                }
                            }
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "Số lượng giao dịch nhỏ hơn":
                        try {
                            String volume = item.getVolume();
                            if (volume != null && !volume.isEmpty()) {
                                String[] parts = volume.split(" ");
                                double itemVolume = Double.parseDouble(parts[0]);
                                double searchQuantity = Double.parseDouble(searchInput);
                                if (itemVolume < searchQuantity) {
                                    searchResults.add(item);
                                }
                            }
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
            return searchResults;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
