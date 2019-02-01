/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MAJEED
 */
public class transactions {

    private static Statement st = null;
    private static ResultSet rs = null;

    static String transactionRefNumber;
    static String currentDate;

    public static void updateTransactionRecod(String refNumber) {
        transactionRefNumber = refNumber;
        SimpleDateFormat formatCurrentDateTime = new SimpleDateFormat("YYY-MM-dd / hh:mm:ss");
        currentDate = formatCurrentDateTime.format(new Date());
        String updateTransactionSQLstatement = "insert into transactions(TransactionsRefNumber, DateTime) value('" + transactionRefNumber + "', '" + currentDate + "')";
        

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(updateTransactionSQLstatement);
            System.out.println("transaction updated proceed ");

        } catch (SQLException ex) {
            System.out.println("fail to update transaction table ");
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }

    public static int getTransactionID(String transactionRefNum) {
        int transactionID = 0;
        String getMedIDSQLstatement = "select transactions.TransactionID from transactions where TransactionsRefNumber = '" + transactionRefNum + "'";

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getMedIDSQLstatement);
            
            while (rs.next()) {
                transactionID = rs.getInt("TransactionID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return transactionID;
    }

    public static ResultSet getTransactions() {
        String getAllTransactionsSQLstatement = "select *from transactions";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getAllTransactionsSQLstatement);
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static void deleteTransaction(String transactionID){
        String deleteTransactionSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`transactions` WHERE `TransactionID`='"+transactionID+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteTransactionSQLStatement);
            JOptionPane.showMessageDialog(null, "Transaction refrence number deleted successfully", "Transaction deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete transaction refrence number ", "Transaction not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
