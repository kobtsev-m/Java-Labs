package controllers;

import globals.Globals;
import views.*;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Vector;

public class ScoresController {

    private final ScoreTableView view;
    private final ScoresComparator scoresComparator;

    public ScoresController(WindowController windowController) {
        view = new ScoreTableView(windowController, this);
        scoresComparator = new ScoresComparator();
    }
    public ScoreTableView getView() {
        return view;
    }
    public void recreateScoreTable() {
        view.repaint();
    }
    static class ScoresComparator implements Comparator<Vector<String>> {
        public int compare(Vector<String> score1, Vector<String> score2) {
            return -Double.compare(
                Double.parseDouble(score1.get(1)),
                Double.parseDouble(score2.get(1))
            );
        }
    }
    private void sortScores(Vector<Vector<String>> scoresData) {
        scoresData.sort(scoresComparator);
    }
    public Vector<Vector<String>> getScores() {
        Vector<Vector<String>> scoresData = new Vector<>();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(Globals.SCORES_FILE_PATH);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                scoresData.add(new Vector<>(Arrays.asList(line.split("\\s+"))));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fr != null) fr.close();
                if (br != null) br.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        sortScores(scoresData);
        return scoresData;
    }
    public void saveScore(String nickname, double score) {
        FileWriter fw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter(Globals.SCORES_FILE_PATH, true);
            out = new PrintWriter(fw);
            out.println(nickname + " " + String.format(Locale.US, "%.1f", score));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (fw != null) fw.close();
                if (out != null) out.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
