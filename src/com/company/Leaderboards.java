package com.company;

import com.sun.glass.ui.Size;

import java.io.*;
import java.util.ArrayList;

public class Leaderboards {

    private static Leaderboards lBoard;
    private String filePath;
    private String highScores;

    // All time Leaderboards
    private ArrayList<Integer> topScores;
    private ArrayList<Integer> topTiles;
    private ArrayList<Long> topTimes;

    private Leaderboards() {
        filePath = new File("").getAbsolutePath();
        highScores = "Scores";

        topScores = new ArrayList<Integer>();
        topTiles = new ArrayList<Integer>();
        topTimes = new ArrayList<Long>();
    }

    public static Leaderboards getInstance() {
        if (lBoard == null) {
            lBoard = new Leaderboards();
        }
        return lBoard;
    }

    public void addScore(int score) {
        for (int i = 0; i < topScores.size(); i++) {
            if (score >= topScores.get(i)) {
                topScores.add(i, score);
                topScores.remove(topScores.size() - 1);
                return;
            }

        }

    }

    public void addTile(int tileValue) {
        for (int i = 0; i < topTiles.size(); i++) {
            if (tileValue >= topTiles.get(i)) {
                topTiles.add(i, tileValue);
                topTiles.remove(topTiles.size() - 1);
                return;

            }
        }
    }

    public void addTime(long millis) {
        for (int i = 0; i < topTimes.size(); i++) {
            if (millis >= topTimes.get(i)) {
                topTimes.add(i, millis);
                topTimes.remove(topTimes.size() - 1);
                return;
            }

        }
    }

    public void loadScores() {
        try {
            File f = new File(filePath, highScores);
            if (!f.isFile()) {
                //createSaveData();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));

            topScores.clear();
            topTiles.clear();
            topTimes.clear();

            String[] scores = reader.readLine().split("-");
            String[] tiles = reader.readLine().split("-");
            String[] times = reader.readLine().split("-");

            for (int i = 0; i < scores.length; i++) {
                topScores.add(Integer.parseInt(scores[i]));
            }

            for (int i = 0; i < tiles.length; i++) {
                topTiles.add(Integer.parseInt(tiles[i]));
            }

            for (int i = 0; i < times.length; i++) {
                topTimes.add(Long.parseLong(times[i]));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveScores(){
        FileWriter output = null;

        try {
            File f = new File(filePath, highScores);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write(topScores.get(0) + "-" + topScores.get(1) + "-" + topScores.get(2) + "-" + topScores.get(3) + "-" + topScores.get(4));
            writer.newLine();
            writer.write(topTiles.get(0) + "-" + topTiles.get(1) + "-" + topTiles.get(2) + "-" + topTiles.get(3) + "-" + topTiles.get(4));
            writer.newLine();
            writer.write(topTimes.get(0) + "-" + topTimes.get(1) + "-" + topTimes.get(2) + "-" + topTimes.get(3) + "-" + topTimes.get(4));
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

