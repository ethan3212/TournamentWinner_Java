package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> competition1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions, results));
    }

    // O(competitions) time | O(teams) space
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        String currentBestTeam = " ";
        HashMap<String, Integer> scoreBoard = new HashMap<>();      // O(teams) space
        scoreBoard.put(currentBestTeam, 0);
        for(int i = 0; i < competitions.size(); i++) {      // O(competitions) time
            ArrayList<String> currentMatch = competitions.get(i);
            String homeTeam = currentMatch.get(0);
            String awayTeam = currentMatch.get(1);
            int matchResult = results.get(i);
            String matchWinner = (matchResult == 1) ? homeTeam : awayTeam;
            updateScoreBoard(scoreBoard, matchWinner);      // O(1) time | O(1) space
            if(scoreBoard.get(matchWinner) > scoreBoard.get(currentBestTeam)) {
                currentBestTeam = matchWinner;
            }
        }
        return currentBestTeam;
    }

    // O(1) time | O(1) space
    public static void updateScoreBoard(HashMap<String, Integer> scoreBoard, String team) {
        if(!scoreBoard.containsKey(team)) {
            scoreBoard.put(team, 0);
        }
        scoreBoard.put(team, scoreBoard.get(team) + 1);
    }
}