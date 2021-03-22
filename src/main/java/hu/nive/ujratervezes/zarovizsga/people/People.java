package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    public int getNumberOfMales(String path) {
        int sum = 0;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            sum = readFromFile(sum, reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot open file", ioe);
        }
        return sum;
    }

    private int readFromFile(int sum, BufferedReader reader) throws IOException {
        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] tmp = line.split(",");
            if (tmp[4].equals("Male")) {
                sum++;
            }
        }
        return sum;
    }
}
