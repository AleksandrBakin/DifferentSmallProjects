package masa.java.homework.fileCopyMaker;

import java.io.*;

public class FileByBuffCopyMaker {
    File inputFile;
    File outputFile;

    FileByBuffCopyMaker(String inputFileName, String outputFileName){
        this.inputFile = new File(inputFileName);
        this.outputFile = new File(outputFileName);
    }

    void makeTextFileCopyByBuff() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
//        while (reader.ready()) {
//            String str = reader.readLine();
//            writer.write(str  + "\n");
//            writer.flush();
//        }
        while (reader.ready()) {
            char[] buffer = new char[10];
            int n = reader.read(buffer);
            writer.write(buffer,0,n);
            writer.flush();
        }
        reader.close();
        writer.close();
    }
}
