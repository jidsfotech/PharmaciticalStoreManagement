/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author MAJEED
 */
public class sales {

    private static Statement st = null;
    private static ResultSet rs = null;

    public static void updateSalesRecord(JTable cartTable) {
        boolean isSalaseSuccesfull = false;
        SimpleDateFormat formatCurrentDateTime = new SimpleDateFormat("YYY-MM-dd hh:mm:ss");
        String salesDate = formatCurrentDateTime.format(new Date());

        String refrenceNumber = UserActivities.generateTransactionReferenceNumber(15, 5, '-');
        transactions.updateTransactionRecod(refrenceNumber);
        int transactionID = transactions.getTransactionID(refrenceNumber);

        int rows = cartTable.getRowCount();
        int row = 0;

        for (row = 0; row < rows; row++) {
            String medName = (String) cartTable.getValueAt(row, 0);
            int quantityInStore = (int) cartTable.getValueAt(row, 1);
            int quantityToSell = (int) cartTable.getValueAt(row, 2);
            int salesPrice = (int) cartTable.getValueAt(row, 3);
            int discount = (int) cartTable.getValueAt(row, 4);
            int medID = medicine.getMedicineID(medName);
            int idUser = users.IDuser;

            String updatetSalesRecordStatement = "insert into sales(SalesDate, SalesPrice, Quantity, Discount, IdMedicine, IdUser, MedicineName, TransactionID)"
                    + " value('" + salesDate + "', '" + salesPrice + "', '" + quantityToSell + "', '" + discount + "', "
                    + "'" + medID + "', '" + idUser + "', '" + medName + "', '" + transactionID + "')";
            
            int newQuantity = quantityInStore - quantityToSell;

            try {
                st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
                st.execute(updatetSalesRecordStatement);
                System.out.println("Sales record successfully updated");
                isSalaseSuccesfull = true;
                medicine.updateMedicineQuantity(medName, newQuantity);

            } catch (SQLException ex) {
                Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("fail to add Sales record ");
                isSalaseSuccesfull = false;
            }
        }

        if (isSalaseSuccesfull == false) {
            JOptionPane.showMessageDialog(null, "Sales failed", "salse failed",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Salse record updated successfully", "salse successfull",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static ResultSet getTransactionDetails(String transactionID) {
        String getTransactionDetails = "select *from sales where TransactionID = '" + transactionID + "'";

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getTransactionDetails);
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public static void generateSalesReport(String fromThisDate, String toThisDate) {
        String reportSQLStatement = "select *from sales where SalesDate between '" + fromThisDate + "' and '" + toThisDate + "'";
        System.out.println(reportSQLStatement);
        Connection con = PharmacyStoreDbaseConConfig.getDbaseConnection();

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Medicine Name", "MedicineName", DataTypes.stringType()).setWidth(350),
                        Columns.column("Quantity Sold", "Quantity", DataTypes.stringType()),
                        Columns.column("Sales Price", "SalesPrice", DataTypes.stringType()),
                        Columns.column("Int %", "Discount", DataTypes.stringType()),
                        Columns.column("Sales Date", "SalesDate", DataTypes.stringType()))
                .title(Components.text("Sales Report From  " + fromThisDate + "  To  " + toThisDate + " ")
                        .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(reportSQLStatement, con);
        try {
            //show the report
            report.show(false);
           
            //export the report to a pdf file
            //report.toPdf(new FileOutputStream("C:\\Users\\MAJEED\\report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
            //} catch (FileNotFoundException e) {
            //   e.printStackTrace();
        }
    }
}
