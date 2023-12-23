package controller;

import connectors.GeneralConnector;
import models.Binance;
import models.NiftyGateway;
import models.Opensea;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ThongKeController {
    private final GeneralConnector generalConnector;

    public ThongKeController() {
        this.generalConnector = new GeneralConnector();
    }

    public List<String> getAllNFTTitles() {
        List<String> allTitles = new ArrayList<>();

        try {
            List<NiftyGateway> niftyData = generalConnector.getNiftyGatewayData();
            for (NiftyGateway data : niftyData) {
                allTitles.add(data.getCollection().getNiftyTitle());
            }

            List<Binance> binanceData = generalConnector.getBinanceData();
            for (Binance data : binanceData) {
                allTitles.add(data.getTitle());
            }

            List<Opensea> openseaData = generalConnector.getOpenseaData();
            for (Opensea data : openseaData) {
                allTitles.add(data.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allTitles;
    }

    public void addNFTTitlesToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnCount(1);

        List<String> allTitles = getAllNFTTitles();

        for (String title : allTitles) {
            Object[] rowData = {title};
            model.addRow(rowData);
        }
    }

    public List<String> searchNFTTitles(String inputSearch) {
        List<String> allTitles = new ArrayList<>();

        try {
            List<NiftyGateway> niftyData = generalConnector.getNiftyGatewayData();
            for (NiftyGateway data : niftyData) {
                if (data.getCollection().getNiftyTitle().contains(inputSearch)) {
                    allTitles.add(data.getCollection().getNiftyTitle());
                }
            }

            List<Binance> binanceData = generalConnector.getBinanceData();
            for (Binance data : binanceData) {
                if (data.getTitle().contains(inputSearch)){
                    allTitles.add(data.getTitle());
                }
            }

            List<Opensea> openseaData = generalConnector.getOpenseaData();
            for (Opensea data : openseaData) {
                if (data.getTitle().contains(inputSearch)){
                    allTitles.add(data.getTitle());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allTitles;
    }
    public void addInfoSearch(JTable table, List<String> info) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setColumnCount(1);

        for (String title : info) {
            Object[] rowData = {title};
            model.addRow(rowData);
        }
    }
}
