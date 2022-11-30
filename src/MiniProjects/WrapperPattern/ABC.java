package MiniProjects.WrapperPattern;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ABC extends FileOutputStream {
    public ABC(String name, boolean append) throws FileNotFoundException {
        super(name, append);
    }
}
