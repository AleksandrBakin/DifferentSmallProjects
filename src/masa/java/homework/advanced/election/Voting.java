package masa.java.homework.advanced.election;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Voting implements Savable, Serializable {
    protected String title;
    protected List<Candidate> candidates;

    Voting(String title, List<Candidate> candidates) {
        this.title = title;
        this.candidates = new ArrayList<>(candidates);
    }

    @Override
    public void saveMyselfToFile(FileWriter fileSaver) throws IOException {
        StringBuilder saveSB = new StringBuilder();
        saveSB.append("title").append(":");
        saveSB.append("[").append(title).append("]").append("\n");
        saveSB.append("candidates").append(":");
        fileSaver.write(saveSB.toString());
        for (Candidate candidate : candidates) {
            candidate.saveMyselfToFile(fileSaver);
        }
    }
}
