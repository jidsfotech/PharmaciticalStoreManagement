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
public class group {

    private static Statement st = null;
    private static ResultSet rs = null;

    public static ResultSet getAllMedicineGroup() {
        String SQLstatement = "select * from medgroup";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);

        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("medicine group Data retrived succesfully");
        return rs;

    }

    
    public static int getMedGroupID(String MedGroup) {
        int groupID = 0;
        String SQLstatement = "SELECT medgroup.idMedGroup from medgroup where MedGroup = '" + MedGroup + "'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(SQLstatement);
            while (rs.next()) {
                groupID = rs.getInt("idMedGroup");
            }
        } catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return groupID;
    }

    
    
    public void addMedicineGroup(ArrayList<String> groupData) {
        String medGroup = groupData.get(0);
        String medClassification = groupData.get(1);
        String SQLstatement = "insert into medgroup(medGroup, Classification)"
                + "values('" + medGroup + "', '" + medClassification + "')";
        System.out.println(SQLstatement);

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(SQLstatement);
            System.out.println("medicine group successfully updated");

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("fail to add new group ");
        }

    }
    
    public static void deleteMedCategory(String medGroup){
        String deleteTransactionSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`medgroup` WHERE `MedGroup`='"+medGroup+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteTransactionSQLStatement);
            JOptionPane.showMessageDialog(null, "Medicine Group deleted successfully", "Medicine group deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete Medicine group", "Medicine group not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
