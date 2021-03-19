package morse;

import utils.CounterSymbol;
import utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Coder {

    private String operation;
    private Map<String, String> codeMap;
    private BufferedReader inFileStream;
    private PrintStream outFileStream;
    private PrintStream outStatStream;
    private Set<CounterSymbol> charSet;

    public Coder(String operation, String filename, String lang) {
        this.operation = operation;
        this.codeMap = new Converter(lang).getMap(operation);
        this.inFileStream = new FileUtils(filename).getFileReader();
        this.outFileStream = new FileUtils("output.txt").getFileOutStream();
        this.outStatStream = new FileUtils("statistic.txt").getFileOutStream();
        this.charSet = new HashSet<>();
    }
    private boolean isCoding() {
        return operation.equals("code");
    }
    public void code() {
        try {
            StringBuilder encryptedLine = new StringBuilder();
            StringBuilder r = new StringBuilder();
            while (true) {
                String line = inFileStream.readLine();
                if (line == null) break;
                String[] lineWords = line.split(isCoding() ? " " : "\\s{4}");
                for (String word : lineWords) {
                    String[] wordChars = word.split(isCoding() ? "" : " ");
                    for (String ch : wordChars) {
                        r.append(ch);
                        String tmp = codeMap.get(r.toString().toUpperCase());
                        if (tmp != null) {
                            encryptedLine.append(tmp);
                            encryptedLine.append(isCoding() ? " " : "");
                            r.setLength(0);
                        }
                        charSet.add(new CounterSymbol(ch.charAt(0)));
                    }
                    encryptedLine.append(isCoding() ? "   " : " ");
                }
                outFileStream.println(encryptedLine);
                encryptedLine.setLength(0);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeStatistic() {
        List<CounterSymbol> charList = new ArrayList<>(charSet);
        Collections.sort(charList);
        for (CounterSymbol ch : charList) {
            outStatStream.println(ch.getValue() + ": " + ch.getOccurrence());
        }
    }
}
