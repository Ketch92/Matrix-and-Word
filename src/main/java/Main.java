import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's make a bit of order."
                + "\n I know it's an enjoyable engagement, but please specify a s stop word \n"
                + "type it when you want to exit");
        String stopWord = scanner.nextLine().toUpperCase();
        String request = "";
        while (!request.equals(stopWord)) {
            request = run(scanner, stopWord);
        }
    }
    
    private static String run(Scanner scanner, String stopWord) {
        System.out.println("May you please specify the line I should use to build the matrix");
        System.out.println("One more thing, the line has to consist of letters only and be of a size n^2");
        String matrix = firstParamInput(scanner, stopWord);
        String word = secondParamInput(scanner, stopWord, matrix);
        System.out.println("Well done! Here is the chain you requested");
    
        try {
            System.out.println(MatrixAndWord.getChain(matrix, word));
        } catch (IOException e) {
            System.out.println("Something has crashed \n"
                    + e.getMessage());
        }
    
        System.out.println("That was nice, would you like more?");
        return scanner.nextLine();
    }
    private static String firstParamInput(Scanner scanner, String stopWord) {
        String matrix = scanner.nextLine().toUpperCase();
        if (matrix.equals(stopWord)) {
            System.exit(0);
        }
        try {
            MatrixAndWord.validateFirstParam(matrix);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Try again");
            firstParamInput(scanner, stopWord);
        }
        System.out.println("Here is the matrix");
        System.out.println(Arrays.deepToString(MatrixAndWord.getMatrix(matrix)));
        return matrix;
    }
    
    private static String secondParamInput(Scanner scanner, String stopWord, String matrix) {
        String word = scanner.nextLine().toUpperCase();
        if (word.equals(stopWord)) {
            System.exit(0);
        }
        try {
            MatrixAndWord.validateSecondParam(word, matrix);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Try again");
            secondParamInput(scanner, stopWord, matrix);
        }
        return word;
    }
}
