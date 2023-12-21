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

    public void addDataToTableNifty(List<NiftyGateway> niftyData, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới

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

    public void addDataToTableBinance(List<Binance> binanceData, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới

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

    public void addDataToTableOpensea(List<Opensea> openseaData, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ trước khi thêm mới

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
