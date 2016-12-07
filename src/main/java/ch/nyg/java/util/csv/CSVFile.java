package ch.nyg.java.util.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import ch.nyg.java.util.LogUtil;

public class CSVFile implements Iterable<CSVLine> {

    private File file;

    public CSVFile(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        if (!file.canRead()) {
            throw new FileNotFoundException("File " + filePath + " doesn't exists or can't be read");
        }
    }

    @Override
    public Iterator<CSVLine> iterator() {
        return new CSVFileIterator(file);
    }

    public Map<String, String> toMap() {

        Map<String, String> data = new LinkedHashMap<>();

        for (CSVLine line : this) {
            data.put(line.get(0).toLowerCase(), line.get(1));
        }

        return data;
    }

    private class CSVFileIterator implements Iterator<CSVLine> {

        private BufferedReader reader;
        private String currentLine;
        private boolean next;

        public CSVFileIterator(File file) {
            try {
                reader = new BufferedReader(new FileReader(file));
            }
            catch (FileNotFoundException e) {
                // Ignore, check is made above
                LogUtil.severe(e);
            }
        }

        @Override
        public boolean hasNext() {

            try {
                currentLine = reader.readLine();
                next = currentLine != null;
            }
            catch (IOException e) {
                LogUtil.severe(e);
                next = false;
            }

            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public CSVLine next() {

            if (next) {
                return new CSVLine(currentLine);
            }

            throw new NoSuchElementException();
        }
    }
}
