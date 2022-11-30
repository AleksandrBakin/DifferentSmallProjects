package masa.java.homework.advanced.election;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Candidate implements Savable, Serializable {
    protected String name;
    protected int voices = 0;

    public Candidate(String name) { this.name = name; }

    public String getName() { return name; }

    public void addVoice() { voices++; }

    public int getVoices() { return voices; }

    @Override
    public void saveMyselfToFile(FileWriter fileSaver) throws IOException {
        StringBuilder saveSB = new StringBuilder();
        saveSB.append(this.getClass().getSimpleName()).append(":");
        saveSB.append("name:").append("[").append(name).append("]").append(" ");
        saveSB.append("voices:").append("[").append(voices).append("]").append("\n");
        fileSaver.write(saveSB.toString());
    }
}
