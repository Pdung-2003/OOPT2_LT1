package controller;

import connectors.GeneralConnector;
import models.TodayNFTNews;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachBlogController {
    private final GeneralConnector generalConnector;

    public DanhSachBlogController() {
        this.generalConnector = new GeneralConnector();
    }

    public List<String[]> titleTodayNFTNewsData() {
        List<TodayNFTNews> todayNFTNewsList;
        try {
            todayNFTNewsList = generalConnector.getTodayNFTNews();
        } catch (Exception e) {
            System.out.println("Dữ liệu news trống!");
            return Collections.emptyList();
        }

        List<String[]> data = new ArrayList<>();
        for (TodayNFTNews news : todayNFTNewsList) {
            data.add(new String[]{news.getTitle()});
        }
        return data;
    }
    public void addDataToTableNews(List<String[]> data, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        //model.setRowCount(0);

        for (String[] rowData : data) {
            model.addRow(rowData);
        }
    }
    public TodayNFTNews searchByTitle(String searchTerm) {
        List<TodayNFTNews> todayNFTNewsList;
        try {
            todayNFTNewsList = generalConnector.getTodayNFTNews();
        } catch (Exception e) {
            System.out.println("Dữ liệu news trống!");
            return (TodayNFTNews) Collections.emptyList();
        }
        for (TodayNFTNews news : todayNFTNewsList) {
            if (news.getTitle().equals(searchTerm)) {
                return news;
            }
        }
        return null;
    }
}
