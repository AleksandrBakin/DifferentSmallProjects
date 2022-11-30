package masa.java.homework.password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Напишите метод Java, чтобы проверить, является ли строка допустимым паролем.
 * Правила пароля:
 * - Пароль должен содержать не менее десяти символов.
 * - Пароль состоит только из букв и цифр.
 * - Пароль должен содержать не менее двух цифр.
 * Ожидаемый результат:
 * 1. A password must have at least eight characters.
 * 2. A password consists of only letters and digits.
 * 3. A password must contain at least two digits
 * Input a password (You are agreeing to the above Terms and Conditions.):
 * abcd1234
 * Password is valid: abcd1234
 *
 *
 *
 */

public class PasswordApp {
    public static void main(String[] args) throws InterruptedException, IOException {
        PasswordKeeper newSafePassword = new PasswordKeeper();
    }

    public static class PasswordKeeper {
        private String safePassword;
        private static final int RANDOM_SAFE_PASSWORD_LENGTH = 16;
        private static final int MINIMUM_SAFE_PASSWORD_LENGTH = 8;
        private static final int MINIMUM_SAFE_PASSWORD_DIGITS_NUMBER = 2;
        private static final String POSSIBLE_CHARS_FOR_PASSWORD = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        private static final String POSSIBLE_DIGITS_FOR_PASSWORD = "0123456789";

        public PasswordKeeper() throws InterruptedException, IOException {
            typeString("Hello! I am yor personal safe password helper!");
            Thread.sleep(1000L);
            typeString("I am ready to get your new safe password!");
            System.out.println();
            Thread.sleep(1000L);
            typeString("Attention:");
            Thread.sleep(1000L);
            typeString("1. Your safe password must have at least eight characters.");
            Thread.sleep(1000L);
            typeString("2. Your safe password must consist of only letters and digits.");
            Thread.sleep(1000L);
            typeString("3. Your safe password must contain at least two digits.");
            Thread.sleep(1000L);
            typeString("4. Saving your password, you accept our Terms and Conditions.");
            System.out.println();
            Thread.sleep(3000L);
            String randomPassword = generateSafePassword();
            typeString("Safe password example:");
            System.out.println(randomPassword + "\n");
            Thread.sleep(1000L);
            typeString("Do you want to save our example password, or enter your own?");
            typeString("Press ( 1 ) if you want to save example password");
            typeString("Press ( 2 ) if you want to enter yor own");
            String consoleLineGetter = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!consoleLineGetter.equals("1") && !consoleLineGetter.equalsIgnoreCase("2")) {
                    consoleLineGetter = reader.readLine();
                }
            }
            if (consoleLineGetter.equals("1")) {
                typeString("OK. You have chosen saving example password option!");
                this.safePassword = randomPassword;
            } else if (consoleLineGetter.equals("2")) {
                typeString("OK. You have chosen entering your own password option!");
                typeString("Enter your password:");
                this.safePassword = getPasswordAndCheck();
            } else {
                typeString("Incorrect input. I will save example password then...");
            }
            typeString("Your new password was saved!");
            typeString("Thank you, and bye :)");
        }

        public static String generateSafePassword() {
            ArrayList<Character> randomSafePasswordCharsList = new ArrayList<>();
            int numberOfDigits = (int) (Math.random() * 6) + 2; // 2 - 8 digits
            for (int i = 0; i < numberOfDigits; i++) {
                int indexOfRandomDigit = (int) (Math.random() * 1000) % POSSIBLE_DIGITS_FOR_PASSWORD.length();
                randomSafePasswordCharsList.add(POSSIBLE_DIGITS_FOR_PASSWORD.charAt(indexOfRandomDigit));
            }
            int numberOfChars = RANDOM_SAFE_PASSWORD_LENGTH - numberOfDigits;
            for (int i = 0; i < numberOfChars; i++) {
                int indexOfRandomChar = (int) (Math.random() * 1000) % POSSIBLE_CHARS_FOR_PASSWORD.length();
                randomSafePasswordCharsList.add(POSSIBLE_CHARS_FOR_PASSWORD.charAt(indexOfRandomChar));
            }
            Collections.shuffle(randomSafePasswordCharsList);
            String newSafePassword = "";
            for (int i = 0; i < RANDOM_SAFE_PASSWORD_LENGTH; i++) {
                newSafePassword = newSafePassword + randomSafePasswordCharsList.get(i);
            }
            return newSafePassword;
        }

        public static void typeString(String nextString) throws InterruptedException {
            for (int i = 0; i < nextString.length(); i++) {
                System.out.print(nextString.charAt(i));
                // Thread.sleep(100L);
            }
            System.out.println();
        }

        public static String getPasswordAndCheck() throws IOException, InterruptedException {
            String userPassword = "";
            int numberOfDigits = 0;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (reader.ready()) {
                    userPassword = reader.readLine();
                    if (userPassword.length() < MINIMUM_SAFE_PASSWORD_LENGTH) {
                        typeString("Your password must have at least eight characters.");
                        continue;
                    }
                    for (int i = 0; i < userPassword.length(); i++) {
                        if (!POSSIBLE_CHARS_FOR_PASSWORD.contains(String.valueOf(userPassword.charAt(i))) &&
                                !POSSIBLE_DIGITS_FOR_PASSWORD.contains(String.valueOf(userPassword.charAt(i)))) {
                            typeString("Your password must consist of only letters and digits.");
                            continue;
                        } else if (POSSIBLE_DIGITS_FOR_PASSWORD.contains(String.valueOf(userPassword.charAt(i)))) {
                            numberOfDigits++;
                        }
                    }
                    if (numberOfDigits < MINIMUM_SAFE_PASSWORD_DIGITS_NUMBER) {
                        typeString("Your password must contain at least two digits");
                    } else {
                        break;
                    }
                }
            }
            typeString("Super! Your password is correct!");
            return userPassword;
        }

    }

}
