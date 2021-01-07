package com.sparta.output;

import com.sparta.model.ReportPack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The class FileExporter.java will export the report as .txt to the filePath specified.
 */
public class FileExporter {

    /**
     * Write {@code reportPack} to file getting the lines from {@link ReportPack#getLines()}
     * @param reportPack report to be written.
     * @param filePath the file path where the report is being written to.
     * @throws IOException if an IO problem of some sort happened.
     */
    public static void writeReportToFile(ReportPack reportPack, String filePath) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        for (String line : reportPack.getLines()) {
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
    }
}
