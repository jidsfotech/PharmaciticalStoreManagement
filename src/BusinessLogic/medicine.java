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
 * @author MAJEED SHUAIB
 */
public class medicine {

    private static Statement st = null;
    private static ResultSet rs = null;

    public static ResultSet getAllMedicine() {
        String SQLstatement = "select medicine.idMedicine,"
                + "medicine.MedicineName,"
                + "medicine.QuantityInStore,"
                + "medicine.SalePrice,"
                + "medicine.InterestRate,"
                + "medicine.Manufacturer,"
                + "medCategory.Category,"
                + "medgroup.medGroup" + " "
                + "FROM medicine" + " "
                + "JOIN medgroup ON medicine.idMedGroup = medgroup.idMedGroup" + " "
                + "JOIN medcategory ON medicine.idMedCategory = medcategory.idMedCategory";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Data retrived succesfully");
        return rs;
    }

    public static ArrayList<String> getSelcectedMedicine(String selectedMedName) {
        ArrayList<String> selectedMedData = new ArrayList<String>();
        String SQLstatement = "select * From medicine Where MedicineName = '" + selectedMedName + "'";

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);
            while (rs.next()) {
                selectedMedData.add(rs.getString("MedicineName"));
                selectedMedData.add(rs.getString("QuantityInStore"));
                selectedMedData.add(rs.getString("SalePrice"));
                selectedMedData.add(rs.getString("InterestRate"));
                selectedMedData.add(rs.getString("Manufacturer"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return selectedMedData;
    }

    public static int getMedicineID(String medName) {

        int medID = 0;

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            String getMedIDSQLstatement = "select medicine.idMedicine from medicine where MedicineName = '" + medName + "'";
            rs = st.executeQuery(getMedIDSQLstatement);
            while (rs.next()) {
                medID = rs.getInt("idMedicine");
            }
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medID;
    }

    public static void updateMedicine(ArrayList<String> MedToUpdateData) {
        String medName = MedToUpdateData.get(0);
        String medCurrentQuantity = MedToUpdateData.get(1);
        String medNewPurchaseQuantity = MedToUpdateData.get(2);
        String medPurchasePrice = MedToUpdateData.get(3);
        String salesPrice = MedToUpdateData.get(4);
        String medIntRate = MedToUpdateData.get(5);
        String currentDate = MedToUpdateData.get(6);
        String manufacturedDate = MedToUpdateData.get(7);
        String expireDate = MedToUpdateData.get(8);

        int med_CurrentQty = Integer.parseInt(medCurrentQuantity);
        int med_NewPurchaseQuantity = Integer.parseInt(medNewPurchaseQuantity);
        int totalMedQuantity = med_CurrentQty + med_NewPurchaseQuantity;
        System.out.println("Totalqunatity quantity = " + totalMedQuantity);

        int medID = getMedicineID(medName);
        int idUser = users.IDuser;

        String updatetMedicineSQLquery = "UPDATE pharmaciticalstoredb.medicine SET QuantityInStore='" + totalMedQuantity + "', "
                + "SalePrice='" + salesPrice + "', InterestRate='" + medIntRate + "' "
                + "WHERE MedicineName = '" + medName + "' ";

        String updatetInventorySQLquery = "insert into inventory(idMedicine, MedicineName, QuantityInStore,"
                + " QuantityNewPurchase, PurchasedPrice, SalePrice, InterestRate, dateAdded, ManufDate, ExpDate, idUser)"
                + " value('" + medID + "', '" + medName + "', '" + medCurrentQuantity + "', '" + medNewPurchaseQuantity + "', "
                + "'" + medPurchasePrice + "', '" + salesPrice + "', '" + medIntRate + "', '" + currentDate + "',"
                + "'" + manufacturedDate + "', '" + expireDate + "','" + idUser + "')";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(updatetMedicineSQLquery);
            
            System.out.println("medicine table upddated successfully ");
            JOptionPane.showMessageDialog(null, "Medicine table updated successfully", "Update Successful",
                    JOptionPane.INFORMATION_MESSAGE);
            
            st.execute(updatetInventorySQLquery);
            System.out.println("inventory table upddated successfully ");
            JOptionPane.showMessageDialog(null, "Inventory table updated successfully", "Update Successful",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            System.out.println("fail to update inventory ");
        }
    }

    public static void addNewMedicine(ArrayList<String> newMedicineToAdd) {
        String medName = newMedicineToAdd.get(0);
        String medManufacturer = newMedicineToAdd.get(1);
        String quantity = newMedicineToAdd.get(2);
        String purchasePrice = newMedicineToAdd.get(3);
        String salesPrice = newMedicineToAdd.get(4);
        String medInterest = newMedicineToAdd.get(5);
        String medGroup = newMedicineToAdd.get(6);
        String medCategory = newMedicineToAdd.get(7);
        String currentDate = newMedicineToAdd.get(8);
        String manufacturedDate = newMedicineToAdd.get(9);
        String expireDate = newMedicineToAdd.get(10);

        int groupID = group.getMedGroupID(medGroup);
        int categoryID = category.getMedCategoryID(medCategory);
       
        String addNewMedicineSQLQuery = "insert into medicine(MedicineName, QuantityInStore, SalePrice,"
                + "InterestRate, Manufacturer, idMedCategory, idMedGroup) "
                + "value('" + medName + "','" + quantity + "', '" + salesPrice + "',"
                + "'" + medInterest + "', '" + medManufacturer + "','" + categoryID + "',"
                + "'" + groupID + "')";
        System.out.println(addNewMedicineSQLQuery);

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(addNewMedicineSQLQuery);
            System.out.println("medicine sucessfully added");
            JOptionPane.showMessageDialog(null, "Medicine table updated successfully", "Update Successful",
                JOptionPane.INFORMATION_MESSAGE);
            
            int medID = getMedicineID(medName);
            int idUser = users.IDuser;
            
            String updatetInventorySQLquery = "insert into inventory(idMedicine, MedicineName, QuantityInStore,"
                    + " QuantityNewPurchase, PurchasedPrice, SalePrice, InterestRate, dateAdded, ManufDate, ExpDate, idUser)"
                    + " value('" + medID + "', '" + medName + "', '" + quantity + "', '" + quantity + "', "
                    + "'" + purchasePrice + "', '" + salesPrice + "', '" + medInterest + "', '" + currentDate + "',"
                    + "'" + manufacturedDate + "', '" + expireDate + "','"+ idUser + "')";

            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(updatetInventorySQLquery);
            System.out.println("inventory table updated sucessfully");
            JOptionPane.showMessageDialog(null, "Inventory table updated successfully", "Update Successful",
                JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fail to update inventory table ");
        }
    }
    
    public static void updateMedicineQuantity(String medName, int newQuantity){
        String updatetMedicineQtySQLquery = "UPDATE pharmaciticalstoredb.medicine SET QuantityInStore  = '" +newQuantity+ "' where MedicineName = '" +medName+ "'";
        
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(updatetMedicineQtySQLquery);
            System.out.println("quantity in store updated");
            
         
        } catch (SQLException ex) {
            System.out.println("fail to update quantity ");
        }        
    }
    
    public static void deleteMedicine(int medicineID){
        String deleteMedicineSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`medicine` WHERE `idMedicine`='"+medicineID+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteMedicineSQLStatement);
            JOptionPane.showMessageDialog(null, "Medicine deleted successfully", "Medicine deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete medicine ", "Medicine not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
