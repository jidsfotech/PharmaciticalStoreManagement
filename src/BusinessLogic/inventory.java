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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class inventory {

    private static Statement st = null;
    private static ResultSet rs = null;

    public static ResultSet getInventoryRecord() {
        String getInventoryRecordSQLStatement = "SELECT * FROM pharmaciticalstoredb.inventory;";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getInventoryRecordSQLStatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Inventory record retrived succesfully");
        return rs;
    }

    public static void generateInventoryReport(String fromThisDate, String toThisDate) {
        String reportSQLStatement = "select *from inventory where dateAdded between '" + fromThisDate + "' and '" + toThisDate + "'";
        System.out.println(reportSQLStatement);
        Connection con = PharmacyStoreDbaseConConfig.getDbaseConnection();

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Medicine Name", "MedicineName", DataTypes.stringType()).setWidth(350),
                        Columns.column("Available quantity before update", "QuantityInStore", DataTypes.stringType()),
                        Columns.column("Quantity purchased", "QuantityNewPurchase", DataTypes.stringType()),
                        Columns.column("Purchased price", "PurchasedPrice", DataTypes.stringType()),
                        Columns.column("Sales price", "SalePrice", DataTypes.stringType()),
                        Columns.column("Int rate", "InterestRate", DataTypes.stringType()),
                        Columns.column("Date added", "dateAdded", DataTypes.stringType()).setWidth(130),
                        Columns.column("Manufactured date", "ManufDate", DataTypes.stringType()),
                        Columns.column("Expired date", "ExpDate", DataTypes.stringType()))
                .title(Components.text("Inventory Report From  "+fromThisDate+"  To  "+toThisDate+" ")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource(reportSQLStatement, con);
        try {
            //show the report
            report.show();
            //export the report to a pdf file
            //report.toPdf(new FileOutputStream("C:\\Users\\MAJEED\\report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
            //} catch (FileNotFoundException e) {
            //   e.printStackTrace();
        }
    }
    
    public static void deleteexpiredMeds(int medicineID){
        String deleteExPiredMedicineSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`inventory` WHERE `idInventory`='"+medicineID+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteExPiredMedicineSQLStatement);
            JOptionPane.showMessageDialog(null, "Medicine deleted successfully", "Medicine deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete medicine ", "Medicine not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

}

