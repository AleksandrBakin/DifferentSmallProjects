package masa.java.homework.loginTools;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;

public class LoginApp {
    static final int LOGIN_MAX_LEN = 19;
    static final int PASS_MAX_LEN = 19;
    static int usersNumber = 0;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String login = "", pass = "", repeat = "";
//        String login = "2L84U2RUN_?";
//        String pass = "1213njnsdcsdbceuqb";
//        //String repeat = "1213njnsdcsdbceuqb";
//        String repeat = "123";
        while(true) {
            try {
                System.out.println("Enter login:");
                login = reader.readLine();
                System.out.println("Enter pass:");
                pass = reader.readLine();
                System.out.println("Enter repeat pass one more time:");
                repeat = reader.readLine();
                if (signUp(login, pass, repeat)) {
                    break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("New User with id = " + usersNumber + " signed up successfully!");
    }

//    static boolean login(String login, String password){
//        return true;
//    }

    static boolean signUp(String login, String password, String confirmPassword) {
        try{
            loginFormatIsCorrect(login);
            passwordFormatIsCorrect(password);
            if(!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password and Password conformation must be equal!");
            }
            usersNumber++;
            return true;
        } catch (MyLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    static void loginFormatIsCorrect(String login) throws WrongLoginException {
        if(login.length() > LOGIN_MAX_LEN) throw new WrongLoginException("Login must be less than 20 symbols!");
        String availableSymbols = availableSymbols();
        for (int i = 0; i < login.length(); i++) {
            if (!availableSymbols.contains("" + login.charAt(i))) {
                throw new WrongLoginException("Login must contain only symbols 'A-Z', 'a-z', '0-9' and '_'!");
            }
        }
        // check if login is unique
    }

    static void passwordFormatIsCorrect(String password) throws WrongPasswordException {
        if(password.length() > PASS_MAX_LEN) throw new WrongPasswordException("Password must be less than 20 symbols!");
        String availableSymbols = availableSymbols();
        for (int i = 0; i < password.length(); i++) {
            if (!availableSymbols.contains("" + password.charAt(i))) {
                throw new WrongPasswordException("Password must contain only symbols 'A-Z', 'a-z', '0-9' and '_'!");
            }
        }
    }

    static String availableSymbols(){
        StringBuilder sb = new StringBuilder();
        sb.append("_");
        for (int i = 0; i < ((int)'Z' - (int)'A')+1; i++) {
            sb.append((char) ((int)'A' + i));
            sb.append((char) ((int)'a' + i));
        }
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

}