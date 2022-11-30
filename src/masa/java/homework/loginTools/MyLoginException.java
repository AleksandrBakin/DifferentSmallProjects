package masa.java.homework.loginTools;

public class MyLoginException extends Exception {
    MyLoginException() { }
    MyLoginException(String massage) { super(massage); }
}

class WrongPasswordException extends MyLoginException {
    WrongPasswordException() { }
    WrongPasswordException(String massage) { super(massage); }
}

class WrongLoginException extends MyLoginException {
    WrongLoginException() { }
    WrongLoginException(String massage){
        super(massage);
    }
}