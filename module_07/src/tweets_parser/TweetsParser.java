package tweets_parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TweetsParser {

    private final Map<String, Word> wordMap = new HashMap<>();

    public Set<String> getMostFrequentWords(String path, String stopWordsPath, int columnIndex, int n) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // first line (csv header)

            int columnsCnt = line.split(",").length;

            Set<String> stopWords = getStopWords(stopWordsPath);

            while ((line = br.readLine()) != null) processLine(line, stopWords, columnsCnt, columnIndex);
        }

        return wordMap.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .map(Word::getWord)
                .collect(Collectors.toSet());
    }

    private Set<String> getStopWords(String filePath) throws IOException {

        Set<String> stopWords = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null)
                stopWords.add(line);
        }

        return stopWords;
    }

    private void processLine(String line, Set<String> stopWords, int headerColumnsCnt, int columnIndex) {

        int missingColumnsCnt = 0;
        int i = line.length() - 1;
        while (line.charAt(i--) == ',') missingColumnsCnt++;

        int expectedColumnsCnt = headerColumnsCnt - missingColumnsCnt;

        String[] components = line.split(",");
        int extraContentColumnsCnt = components.length - expectedColumnsCnt; // > 0 when "content" column contains commas

        String content = "";

        for (i = 0; i < components.length; i++)
            if ((i >= columnIndex && i <= columnIndex + extraContentColumnsCnt))
                content += components[i];

        for (String word : content.split(" ")) {
            String cleanWord = cleanData(word);

            if (cleanWord.isEmpty() || stopWords.contains(cleanWord)) continue;

            Word wordObject = wordMap.getOrDefault(cleanWord, new Word(cleanWord, 0));
            wordObject.increaseCount();
            wordMap.put(cleanWord, wordObject);
        }
    }

    private static String cleanData(String tweet) {

        //convert tweet to lower case
        tweet = tweet.toLowerCase();

        //removes all non-letter characters
        tweet = tweet.replaceAll("[^a-zA-Z]", "");

        return tweet;
    }

    public static void main(String[] args) throws IOException {
        String path = "put here a valid csv path";
        String stopWordsPath = "put here a valid stopwords txt file path";
        TweetsParser tweetsParser = new TweetsParser();
        System.out.println(tweetsParser.getMostFrequentWords(path, stopWordsPath, 2, 10));
    }
}
