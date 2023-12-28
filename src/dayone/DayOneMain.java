package dayone;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOneMain {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/dayone/day_one.txt"))) {
            String line;
            Pattern pattern = Pattern.compile("\\d");
            ArrayList<Integer> numberOfEachLine = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                numberOfEachLine.add(matchAndReturnNumber(line, pattern));
            }

            int result = addNumbers(numberOfEachLine);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Integer matchAndReturnNumber(String line, Pattern pattern) {
        Matcher matcher = pattern.matcher(line);
        Integer firstNumber = null;
        Integer lastNumber = null;

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());

            if (firstNumber == null) {
                firstNumber = number;
            }

            lastNumber = number;
        }
        if (firstNumber != null) {
            return Integer.parseInt(firstNumber.toString() + lastNumber.toString());
        }
        return null;
    }

    private static int addNumbers(ArrayList<Integer> listOfNumbers) {
        return listOfNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
