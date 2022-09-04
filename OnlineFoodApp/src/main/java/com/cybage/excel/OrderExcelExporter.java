//package com.cybage.excel;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.cybage.model.User;
//import com.cybage.model.UserOrder;
// 
//public class OrderExcelExporter {
//    private XSSFWorkbook workbook;
//    private XSSFSheet sheet;
//    private List<UserOrder> listOrder;
//     
//    public OrderExcelExporter(List<UserOrder> listOrder) {
//        this.listOrder = listOrder;
//        workbook = new XSSFWorkbook();
//    }
// 
// 
//    private void writeHeaderLine() {
//        sheet = workbook.createSheet("Order");
//         
//        Row row = sheet.createRow(0);
//         
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setFontHeight(16);
//        style.setFont(font);
//         
//        createCell(row, 0, "orderId", style);      
//       // createCell(row, 1, "Time", style);       
//        //createCell(row, 2, "userPassword", style);    
//        createCell(row, 2, "Total", style);
//        createCell(row, 3, "Restaurant Name", style);
//       // createCell(row, 4, "address.addressId", style);
//        createCell(row, 4, "User Name", style);
////        createCell(row, 5, "Street", style);
////        createCell(row, 6, "Pincode", style);
//     
//         
//    }
//     
//    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
//        sheet.autoSizeColumn(columnCount);
//        Cell cell = row.createCell(columnCount);
//        if (value instanceof Integer) {
//            cell.setCellValue((Integer) value);
//        } else if (value instanceof Boolean) {
//            cell.setCellValue((Boolean) value);
//        }else {
//            cell.setCellValue((String) value);
//        }
//        cell.setCellStyle(style);
//    }
//     
//    private void writeDataLines() {
//        int rowCount = 1;
// 
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setFontHeight(14);
//        style.setFont(font);
//                 
//        for (UserOrder userOrder : listOrder) {
//            Row row = sheet.createRow(rowCount++);
//            int columnCount = 0;
//            
//            createCell(row, columnCount++, userOrder.getOrderId(), style);
//           // createCell(row, columnCount++, userOrder.getOrderTime(), style);
//           // createCell(row, columnCount++, user.getUserPassword(), style);
//            createCell(row, columnCount++, userOrder.getTotal(), style);
//            createCell(row, columnCount++, userOrder.getRestaurant().getRestaurantName(), style);
//          
//            //createCell(row, columnCount++, user.getAddress().getAddressId(), style);
//            createCell(row, columnCount++, userOrder.getUser().getUserName(), style);
////            createCell(row, columnCount++, user.getAddress().getStreet(), style);
////            createCell(row, columnCount++, user.getAddress().getPincode(), style);
//
//             
//        }
//    }
//     
//    public void export(HttpServletResponse response) throws IOException {
//        writeHeaderLine();
//        writeDataLines();
//         
//        ServletOutputStream outputStream = response.getOutputStream();
//        workbook.write(outputStream);
//        workbook.close();
//         
//        outputStream.close();
//         
//    }
//}