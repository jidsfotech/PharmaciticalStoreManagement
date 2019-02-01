/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author MAJEED
 */
public class UserActivities {

    static int bthNum;

    public static boolean validateIntegerInput(JTextField textField, String value) {
        boolean isInputInteger = false;
        int valueToValidate = 0;
        try {
            Integer.parseInt(value);
            isInputInteger = true;

        } catch (NumberFormatException e) {
            textField.setText("");
            textField.requestFocusInWindow();
            JOptionPane.showMessageDialog(null, "Invalid iput, value must be a number", "input errorr",
                    JOptionPane.ERROR_MESSAGE);
        }
        return isInputInteger;
    }

    public static boolean validateStringInput(JTextField textField, String txt) {
        boolean isInputString = false;
        if (txt.trim().isEmpty() || txt == null) {
            textField.setText("");
            textField.requestFocus();
            JOptionPane.showMessageDialog(null, "You have an empty field please check and try again", "input errorr",
                    JOptionPane.ERROR_MESSAGE);

        } else {
            isInputString = true;
        }
        return isInputString;
    }

    public static ArrayList<String> checkEmptyInput(ArrayList<String> dataInput) {
        ArrayList<String> formatedData = new ArrayList<String>();
        String txt = "";
        int i;
        for (i = 0; i < dataInput.size(); i++) {
            txt = dataInput.get(i);
            if (txt.trim().isEmpty() || txt == null) {
                JOptionPane.showMessageDialog(null, "You have an empty field please check and try again", "input errorr",
                        JOptionPane.ERROR_MESSAGE);
                break;
            } else {
                formatedData.add(txt);
            }
        }
        return formatedData;

    }

    public static boolean validateDate(JXDatePicker datePicker) {
        boolean isDateValid = false;
        SimpleDateFormat formatCurrentDate = new SimpleDateFormat("YYY-MM-dd hh:mm:ss");
        SimpleDateFormat formatDate = new SimpleDateFormat("YYY-MM-dd");

        if (datePicker.getDate() != null) {
            isDateValid = true;

        } else {
            datePicker.requestFocusInWindow();
            JOptionPane.showMessageDialog(null, "Select a valid date", "input errorr",
                    JOptionPane.ERROR_MESSAGE);

        }
        return isDateValid;
    }

    public static boolean validateJComboBoxSelection(JComboBox<String> comboBox) {
        boolean isComboBoxSelectionValidated = false;
        if (comboBox.getSelectedIndex() == 0) {
            comboBox.requestFocusInWindow();
            JOptionPane.showMessageDialog(null, "Invalid selection", "selection errorr",
                    JOptionPane.ERROR_MESSAGE);
            isComboBoxSelectionValidated = false;
        } else {
            isComboBoxSelectionValidated = true;
        }
        return isComboBoxSelectionValidated;
    }

    public static int validateSelectedBeforeAddToCart(JLabel selectedMed) {
        int selected = 0;
        try {
            selected = Integer.parseInt(selectedMed.getText());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please select medcine to sell", "selection errorr",
                    JOptionPane.ERROR_MESSAGE);
        }

        return selected;
    }

    public static String generateTransactionReferenceNumber(int length, int spacing, char spacerChar) {
        String NUMBERS = "0123456789";
        Random rng = new SecureRandom();

        StringBuilder stringBuilder = new StringBuilder();
        int spacer = 0;
        while (length > 0) {
            char randomChar = NUMBERS.charAt(rng.nextInt(NUMBERS.length()));
            if (spacer == spacing) {
                stringBuilder.append(spacerChar);
                spacer = 0;
            }
            length--;
            spacer++;
            stringBuilder.append(randomChar);
        }
        String refrenceNumber = "StoreTrans-Ref-ID-" + stringBuilder;
        return refrenceNumber;
    }

    public static ActionListener expProductAlert(JLabel label) {
        return new java.awt.event.ActionListener() {
            private java.awt.Color cor1 = java.awt.Color.red;
            private java.awt.Color cor2 = java.awt.Color.blue;
            private int count;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count % 2 == 0) {
                    label.setForeground(cor1);
                    label.setBackground(cor1);
                } else {
                    label.setForeground(cor2);
                    label.setBackground(cor1);
                }
                count++;
            }
        };

    }

    public static boolean validateSelectedImage(File imageFile) {
        boolean isValidated = false;
        try {
            Image image = ImageIO.read(imageFile);
            if (image != null) {
                isValidated = true;
            }
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "selected file is not an image", "invalid image", JOptionPane.ERROR_MESSAGE);
System.out.print(imageFile);
        }
        return isValidated;
    }
}
