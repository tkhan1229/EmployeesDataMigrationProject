package org.sparta.tk.FileHandler;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteToFile {
    private static final Logger logger = LogManager.getLogger();
    public static BufferedWriter createInvalidTextFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/InvalidData.txt"));
        logger.info("InvalidData.txt file created");
        return bufferedWriter;
    }

    public static void writeToInvalidDataFile(String[] invalidRow, BufferedWriter bufferedWriter){
        try{
            bufferedWriter.newLine();
            bufferedWriter.append(Arrays.toString(invalidRow));
        }catch (Exception e){//Catch exception if any
            logger.error("Cannot write to InvalidData.txt");
        }
    }

    public static BufferedWriter createValidTextFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/ValidData.txt"));
        logger.info("ValidData.txt file created");
        return bufferedWriter;
    }

    public static void writeToValidDataFile(String[] validRow, BufferedWriter bufferedWriter){
        try{
            bufferedWriter.newLine();
            bufferedWriter.append(Arrays.toString(validRow));
        }catch (Exception e){//Catch exception if any
            logger.error("Cannot write to ValidData.txt");
        }
    }
}
