package masa.java.homework.advanced.election;

public class Elector extends User {
    private boolean voted;
    Elector(String name, String login, String password) {
        super(name, login, password);
        voted = false;
    }
    boolean isVoted() {
        return voted;
    }

    public void vote() { //???
        voted = true;
    }
}
