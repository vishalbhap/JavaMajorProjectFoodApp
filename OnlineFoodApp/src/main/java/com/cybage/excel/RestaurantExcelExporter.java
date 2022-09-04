package com.cybage.excel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cybage.model.Restaurant;
import com.cybage.model.User;
 
public class RestaurantExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Restaurant> listRestaurant;
     
    public RestaurantExcelExporter(List<Restaurant> listRestaurant) {
        this.listRestaurant= listRestaurant;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Restaurant");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "restId", style);      
        createCell(row, 1, "Restaurant Name", style);       
        //createCell(row, 2, "userPassword", style);    
        createCell(row, 2, "Restaurant Email", style);
        createCell(row, 3, "Restaurant UserName", style);
       // createCell(row, 4, "address.addressId", style);
        createCell(row, 4, "Area", style);
        createCell(row, 5, "Street", style);
        createCell(row, 6, "Pincode", style);
     
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Restaurant restaurant : listRestaurant) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            
            createCell(row, columnCount++, restaurant.getRestId(), style);
            createCell(row, columnCount++, restaurant.getRestaurantName(), style);
           // createCell(row, columnCount++, user.getUserPassword(), style);
            createCell(row, columnCount++, restaurant.getRestaurantEmail(), style);
            createCell(row, columnCount++, restaurant.getRestaurantUserName(), style);
          
            //createCell(row, columnCount++, user.getAddress().getAddressId(), style);
            createCell(row, columnCount++, restaurant.getAddress().getArea(), style);
            createCell(row, columnCount++, restaurant.getAddress().getStreet(), style);
            createCell(row, columnCount++, restaurant.getAddress().getPincode(), style);

             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}