package baranowski.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReaderService {
    private BufferedReader bufferedReader;

    public ReaderService(String pathToFile) throws FileNotFoundException {
        bufferedReader = new BufferedReader(new FileReader(pathToFile));
    }

    public HashMap<Integer, String> getHashMapFromTxtFile() throws IOException {
        HashMap<Integer, String> rowMap = new HashMap<>();
        int rowCount = 0;
        String line = bufferedReader.readLine();
        while (line != null) {
            rowCount++;
            rowMap.put(rowCount, line);
            line = bufferedReader.readLine();
        }
        if (rowMap.isEmpty()) {
            return null;
        } else {
            return rowMap;
        }
    }
}
