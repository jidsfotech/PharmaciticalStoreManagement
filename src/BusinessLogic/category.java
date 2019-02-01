/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 

/**
 *
 * @author MAJEED
 */
public class category {
    private static Statement st = null;
    private static ResultSet rs = null;
    
    
    public static ResultSet getAllMedicineCategory(){
        String SQLstatement = "SELECT * FROM medcategory";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("medicine category Data retrived succesfully");
        return rs;
    }
    
    
    public static int getMedCategoryID(String MedCategory) {
        int categoryID = 55;
        String SQLstatement = "SELECT medcategory.idMedCategory from medcategory where Category = '" + MedCategory + "'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);
            while (rs.next()) {
                categoryID = rs.getInt("idMedCategory");
            }
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryID;
    }
    
    
    public void addMedicineCategory(ArrayList<String> categoryData ){
       String medCategory = categoryData.get(0);
       String medDescription = categoryData.get(1);
       String SQLstatement = "insert into medcategory(Category, Description)" 
                + "values('"+medCategory+"', '"+medDescription+"')";
       System.out.println(SQLstatement);
       
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(SQLstatement);
            System.out.println("medicine category successfully updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fail to add new medicine category ");
        }  
    }
    
    public static void deleteMedCategory(String medCategory){
        String deleteTransactionSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`medcategory` WHERE `Category`='"+medCategory+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteTransactionSQLStatement);
            JOptionPane.showMessageDialog(null, "Medicine category deleted successfully", "Medicine category deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete Medicine category", "Medicine category not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
