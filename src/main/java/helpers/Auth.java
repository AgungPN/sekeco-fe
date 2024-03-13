package helpers;


import dtos.auth.LoginResponse;

public class Auth {

    private static String role = "";
    private static LoginResponse login;

    public static LoginResponse getLogin() {
        return login;
    }

    public static void setLogin(LoginResponse login) {
        Auth.login = login;
    }

    public static void setRole(String newRole) {
        role = newRole;
    }

    public static boolean isAdmin() {
        return role.equals("ROLE_ADMIN");
    }

    public static boolean isCashier() {
        return role.equals("ROLE_CASHIER");
    }

    public static boolean logout() {
        return Message.confirm("Apakah anda yakin ingin keluar?", "Logout") == 0;
    }
}
