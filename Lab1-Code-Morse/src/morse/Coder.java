package morse;

import utils.CounterSymbol;
import utils.FileUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

abstract class Coder {

    protected Map<String, String> codeMap;
    protected BufferedReader inFileStream;
    protected PrintStream outFileStream;
    protected PrintStream outStatStream;
    protected Set<CounterSymbol> charSet;

    public Coder(String filename, String lang) {
        this.inFileStream = new FileUtils(filename).getFileReader();
        this.outFileStream = new FileUtils("output.txt").getFileOutStream();
        this.outStatStream = new FileUtils("statistic.txt").getFileOutStream();
        this.charSet = new HashSet<>();
    }
    private String getSpaces(int n) {
        return new String(new char[n]).replace("\0", " ");
    }
    public void code(boolean encoding) {
        try {
            StringBuilder encryptedLine = new StringBuilder();
            StringBuilder r = new StringBuilder();
            while (true) {
                String line = inFileStream.readLine();
                if (line == null) break;
                String[] words = line.split(encoding ? getSpaces(1) : getSpaces(4));
                for (String word : words) {
                    String[] wordChars = word.split(encoding ? "" : getSpaces(1));
                    for (String ch : wordChars) {
                        r.append(ch);
                        String tmp = codeMap.get(r.toString().toUpperCase());
                        if (tmp != null) {
                            encryptedLine.append(tmp);
                            encryptedLine.append(encoding ? getSpaces(1) : "");
                            r.setLength(0);
                        }
                        charSet.add(new CounterSymbol(ch.charAt(0)));
                    }
                    encryptedLine.append(encoding ? getSpaces(3) : getSpaces(1));
                }
                outFileStream.println(encryptedLine);
                encryptedLine.setLength(0);
            }
        } catch (
            IOException e) {
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
