package masa.java.homework.fileCopyMaker;

import java.io.*;

public class FileCopyMaker {
    File inputFile;
    File outputFile;

    FileCopyMaker(String inputFileName, String outputFileName){
        this.inputFile = new File(inputFileName);
        this.outputFile = new File(outputFileName);
    }

    void makeTextFileCopy() throws IOException {
        FileReader reader = new FileReader(inputFile);
        FileWriter writer = new FileWriter(outputFile);
        while (reader.ready()) {
            int c = reader.read();
            writer.write(c);
        }
        reader.close();
        writer.close();
    }
}
