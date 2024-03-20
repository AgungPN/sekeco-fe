package helpers;


import javax.swing.*;
import java.util.List;

public class Message {
    public static void information(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void errors(List<String> errors) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error:\n");
        if(errors == null){
            return;
        }
        for (int i = 0; i < errors.size(); i++) {
            stringBuilder.append(i + 1).append(". ").append(errors.get(i)).append("\n");
        }
        Message.error(stringBuilder.toString(), "Error");
    }

    public static int confirm(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

}