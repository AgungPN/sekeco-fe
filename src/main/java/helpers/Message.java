package helpers;

import javax.swing.*;

public class Message {
    public static void information(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static int confirm(String message, String title) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
    }

}