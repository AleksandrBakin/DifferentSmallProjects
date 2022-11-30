package masa.java.homework.advanced.election;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class VotingSystem {
    private static Voting currentVoting;
    private static List<User> users;

    private static User currentUser;

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int len = "Goldberg-Rozenblum-Rubenshtejn Aleksandr".length();
//        System.out.println(len);
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Vova"));
        candidates.get(0).addVoice();
        candidates.get(0).addVoice();
        candidates.add(new Candidate("Maria"));
        candidates.get(0).addVoice();

        currentVoting = new Voting("123",candidates);
        users = new ArrayList<>();
        users.add(new User("Vanya", "123", "123"));
        users.add(new User("Katya", "12345", "12345"));
        save();
    }

    private static User addUser(String name, String login, String password, String repeation) {
        // name != null, login != null, password != null, repeation != null
        // check name split " " size must be more than 2
        // check name letters contain only english letters and "-", no numbers or other symbols
        // login.len > LOGIN_MIN_LEN , login.len < LOGIN_MAX_LEN
        // login is unique
        // pass.len > PASS_MIN_LEN , pass.len < PASS_MAX_LEN
        // 2+ Upper case symbols, 2+ lower case symbols, 2+ Super symbols, 2+ numbers
        // pass and repeation are equal
        // add to usersList
        // return newUser
        return null;
    }

    private static User findUser(String login, String password) {
        for (User user: users) {
            if (user.login.equals(login) && user.password.equals(password)){
                return user;
            }
        }
        return null;
    }

    private static void save() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss", Locale.ENGLISH);
        String fileName = currentVoting.title + "-" + sdf.format(new Date());
        //FileWriter fileSaver = new FileWriter(fileName);
        //currentVoting.saveMyselfToFile(fileSaver);
        //for (User user: users) {
        //}

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream oos = null;

        try {

            fileOutputStream = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(currentVoting);
            for (User user: users) {
                oos.writeObject(user);
            }

            System.out.println("Done");

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
