package helpers;


public class Auth {

    private static String role = "";
//    private static Account account = new Account("", "");
//
//    public static Account getAccount() {
//        return account;
//    }
//
//    public static void setAccount(Account account) {
//        Auth.account = account;
//    }
//
    public static void setRole(String newRole) {
        role = newRole;
    }

    public static boolean isAdmin() {
        return role.equals("admin");
    }

    public static boolean isCashier() {
        return role.equals("cashier");
    }

    public static boolean logout() {
        return Message.confirm("Apakah anda yakin ingin keluar?", "Logout") == 0;
    }
}
