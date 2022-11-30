package masa.java.homework.advanced.election;

import java.io.FileWriter;
import java.io.IOException;

public interface Savable {
    void saveMyselfToFile(FileWriter fileSaver) throws IOException;
}
