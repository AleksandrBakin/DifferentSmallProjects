package masa.java.homework.fileCopyMaker;

import java.io.FileWriter;
import java.io.IOException;

public class FileCopyMakerApp {
    public static void main(String[] args) throws IOException {
        String inputFileName = "/Users/aleksandrbakin/Java/files/inputFile";
        //FileCopyMaker fcm = new FileCopyMaker(inputFileName, inputFileName + " copy");
        //fcm.makeTextFileCopy();
        FileByBuffCopyMaker fbbcm = new FileByBuffCopyMaker(inputFileName, inputFileName + " copy");
        fbbcm.makeTextFileCopyByBuff();
    }
}
