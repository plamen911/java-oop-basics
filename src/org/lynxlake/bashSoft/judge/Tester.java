package org.lynxlake.bashSoft.judge;

import org.lynxlake.bashSoft.io.OutputWriter;
import org.lynxlake.bashSoft.staticData.ExceptionMessages;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public void compareContent(String actualOutput, String expectedOutput) {
        try {

            OutputWriter.writeMessageOnNewLine("Reading files...");
            String mismatchPath = getMismatchPath(expectedOutput);

            List<String> actualOutputString = readTextFile(actualOutput);
            List<String> expectedOutputString = readTextFile(expectedOutput);

            boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchPath);

            if (mismatch) {
                List<String> mismatchString = readTextFile(mismatchPath);
                mismatchString.forEach(OutputWriter::writeMessageOnNewLine);
            } else {
                OutputWriter.writeMessageOnNewLine("Files are identical. There are no mismatches.");
            }
        } catch (IOException ioe) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
        }
    }

    private List<String> readTextFile(String filePath) throws IOException {
        List<String> text = new ArrayList<>();

        File file = new File(filePath);

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        while (line != null) {
            text.add(line);
            line = reader.readLine();
        }

        reader.close();

        return text;
    }

    private String getMismatchPath(String expectedOutput) {
        int index = expectedOutput.lastIndexOf('\\');
        String directoryPath = expectedOutput.substring(0, index);
        return directoryPath + "\\mismatch.txt";
    }

    private void printOutput(String mismatchPath, boolean isMismatch) throws IOException {
        if (isMismatch)
        {
            List<String> mismatchStrings = Files.readAllLines(Paths.get(mismatchPath));
            mismatchStrings.forEach(OutputWriter::writeMessageOnNewLine);
            return;
        }

        OutputWriter.writeMessageOnNewLine("Files are identical. There are no mismatches.");
    }

    private boolean compareStrings(
            List<String> actualOutputString,
            List<String> expectedOutputString,
            String mismatchPath)
    {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;

        try {
            FileWriter fileWriter = new FileWriter(mismatchPath);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            int maxLength = Math.max(actualOutputString.size(), expectedOutputString.size());

            for (int i = 0; i < maxLength; i++) {
                String actualLine = actualOutputString.get(i);
                String expectedLine = expectedOutputString.get(i);

                if (!actualLine.equals(expectedLine)) {
                    output = String.format("mismatch -> expected{%s}, actual{%s}%n", expectedLine, actualLine);
                    isMismatch = true;
                } else {
                    output = String.format("line match -> %s%n", actualLine);
                }

                writer.write(output);
            }

            writer.close();
        } catch (IOException ioe) {
            isMismatch = true;
            OutputWriter.displayException(ExceptionMessages.CANNOT_ACCESS_FILE);
        } catch (IndexOutOfBoundsException ioobe) {
            isMismatch = true;
            OutputWriter.displayException(ExceptionMessages.INVALID_OUTPUT_LENGTH);
        }

        return isMismatch;
    }
}