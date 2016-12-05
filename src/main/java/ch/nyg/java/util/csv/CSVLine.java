package ch.nyg.java.util.csv;

import java.util.Arrays;

public class CSVLine {

    private static final String SEPARATOR = ";";
    private static final String QUOTE = "\"";

    private String[] cells;

    public CSVLine(String line) {
        cells = line.split(SEPARATOR);
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].startsWith(QUOTE) && cells[i].endsWith(QUOTE)) {
                cells[i] = cells[i].substring(1, cells[i].length() - 1);
            }
        }
    }

    public String get(int index) {
        return cells[index];
    }

    public String[] cells() {
        return cells;
    }

    public double[] cellsToDouble(int fromIndex) {
        double[] cellsDouble = new double[cells.length - fromIndex];
        for (int i = fromIndex; i < cells.length; i++) {
            cellsDouble[i - fromIndex] = Double.parseDouble(cells[i]);
        }
        return cellsDouble;
    }

    public int size() {
        return cells.length;
    }

    @Override
    public String toString() {
        return "CSVLine [" + Arrays.toString(cells) + "]";
    }
}
