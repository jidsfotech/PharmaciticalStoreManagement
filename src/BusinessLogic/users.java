/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
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
public class users {

    public static String userStatus = "";
    public static int IDuser = 0;

    public static void addUsers(ArrayList newUserData) {
        FileInputStream fis = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String username = (String) newUserData.get(0);
        String firstname = (String) newUserData.get(1);
        String lastname = (String) newUserData.get(2);
        String email = (String) newUserData.get(3);
        String password = (String) newUserData.get(4);
        String status = (String) newUserData.get(5);
        File userProfileImage = (File) newUserData.get(6);
        try {
            fis = new FileInputStream(userProfileImage);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(userProfileImage);

        String SQLstatement = "insert into user(Username, Firstname, Lastname, Email, Password, Status, ProfilePictures) values(?,?,?,?,?,?,?)";
        try {
            pst = PharmacyStoreDbaseConConfig.getDbaseConnection().prepareStatement(SQLstatement);
            pst.setString(1, username);
            pst.setString(2, firstname);
            pst.setString(3, lastname);
            pst.setString(4, email);
            pst.setString(5, password);
            pst.setString(6, status);
            pst.setBlob(7, fis);
            pst.executeUpdate();
            
            System.out.println("User added succesfully");
            JOptionPane.showMessageDialog(null, "User added succesfully", "User added Successfully",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "fail to add new user ", "Error adding user",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("fail to add new user");
        }

    }

    public static boolean authenticateUser(String userName, String password) {
        Statement st = null;
        ResultSet rs = null;
        boolean authenticated = false;

        String findUserSQLStatement = "select idUser, Username, Password, Status from user where Username = '" + userName + "' and Password = '" + password + "' ";

        System.out.println(userName + " " + password);
        System.out.println(findUserSQLStatement);

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(findUserSQLStatement);

            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "Authentication Fail, please try again", "Fail to login!..",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println("fail to login");

            } else {
                authenticated = true;
                userStatus = rs.getString("Status");
                IDuser = rs.getInt("idUser");

                System.out.println("Authentication successfull");
                System.out.println(userStatus);
                System.out.println(IDuser);
            }

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error occured during login, please try again", "Login Error!..",
                    JOptionPane.ERROR_MESSAGE);
        }
        return authenticated;
    }

    public static ResultSet getAllUser() {
        Statement st = null;
        ResultSet rs = null;
        String getUserSQLStatement = "SELECT * FROM user";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getUserSQLStatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Data retrived succesfully");
        return rs;
    }

    public static ResultSet getAUser(int userID) {
        Statement st = null;
        ResultSet rs = null;
        String getUserSQLStatement = "SELECT * FROM user where idUser = '" + userID + "'";
        System.out.println(getUserSQLStatement);
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getUserSQLStatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("user retrived succesfully");
        return rs;
    }

    public static void updateUserData(ArrayList userDataToUpdate) {
        Statement st = null;
        ResultSet rs = null;
        int ID = (int) userDataToUpdate.get(0);
        String userName = (String) userDataToUpdate.get(1);
        String firstName = (String) userDataToUpdate.get(2);
        String lastName = (String) userDataToUpdate.get(3);
        String email = (String) userDataToUpdate.get(4);
        String password = (String) userDataToUpdate.get(5);
        String status = (String) userDataToUpdate.get(6);

        String updatetUserSQLquery = "UPDATE pharmaciticalstoredb.user SET Username='" + userName + "', "
                + "Firstname='" + firstName + "', Lastname='" + lastName + "',  Email='" + email + "',"
                + "Password='" + password + "', Status='" + status + "'"
                + "WHERE idUser = '" + ID + "' ";
        System.out.println(updatetUserSQLquery);

        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(updatetUserSQLquery);

            System.out.println("User table upddated successfully ");
            JOptionPane.showMessageDialog(null, "user information updated successfully", "Update Successful",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            System.out.println("fail to update User ");
        }
    }
    public static ResultSet getProfileImage(int userID){
        Statement st = null;
        ResultSet rs = null;
        String getUserSQLStatement = "SELECT ProfilePictures FROM user where idUser = '"+userID +"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            rs = st.executeQuery(getUserSQLStatement);

        } catch (SQLException ex) {
            Logger.getLogger(medicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
    public static void deleteUser(String userID){
        Statement st = null;
        ResultSet rs = null;
        String deleteMedicineSQLStatement = "DELETE FROM `pharmaciticalstoredb`.`user` WHERE `idUser`='"+userID+"'";
        try {
            st = PharmacyStoreDbaseConConfig.getDbaseConnection().createStatement();
            st.execute(deleteMedicineSQLStatement);
            JOptionPane.showMessageDialog(null, "User deleted successfully", "User deleted",
                JOptionPane.INFORMATION_MESSAGE);
            
         
        } catch (SQLException ex) {
            System.out.println("fail to delete medicine ");
            JOptionPane.showMessageDialog(null, "Fail to delete User ", "User not deleted",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
