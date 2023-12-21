package controller;

import connectors.GeneralConnector;
import models.Binance;
import models.NiftyGateway;
import models.Opensea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    public void addDataToTableNifty(JTable table) throws Exception {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới
        List<NiftyGateway> niftyData = getNiftyGatewayData();

        for (NiftyGateway data : niftyData) {
            Object[] rowData = {
                    data.getCollection().getNiftyTitle(),
                    data.getCollection().getNiftyDisplayImage(),
                    data.getAvgSalePrice(),
                    data.getTotalNumPrimarySales(),
                    data.getTotalVolume(),
                    data.getCollection().getNiftyType(),
                    data.getFloorPrice()
            };
            model.addRow(rowData);
        }
    }

    public void addDataToTableBinance(JTable table) throws Exception{
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới
        List<Binance> binanceData = getBinanceData();

        for (Binance data : binanceData) {
            Object[] rowData = {
                    data.getTitle(),
                    data.getCollectionId(),
                    data.getCoverUrl(),
                    data.getOwnersCount(),
                    data.getItemsCount(),
                    data.getFloorPrice(),
                    data.getFloorPriceRate(),
                    data.getVolume()
            };
            model.addRow(rowData);
        }
    }

    public void addDataToTableOpensea(JTable table) throws Exception{
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới
        List<Opensea> openseaData = getOpenseaData();

        for (Opensea data : openseaData) {
            Object[] rowData = {
                    data.getTitle(),
                    data.getImage(),
                    data.getDiscount(),
                    data.getSales(),
                    data.getVolume(),
                    data.getFloorPrice()
            };
            model.addRow(rowData);
        }
    }
}
