import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static String firstMassage = "Let's make a bit of order."
            + "\nI know it's an enjoyable engagement, but please specify a s stop word \n"
            + "type it when you want to exit";
    private static String requestMatrix = "May you please specify the line"
            + " I should use to build the matrix";
    private static String noticeMassage = "One more thing, the line has to consist "
            + "of letters only and be of a size n^2";
    private static String errorMassage = "Something has crashed \n";
    private static String anotherRunMassage = "Perfect teamwork, would you like more?";
    private static String successMassage = "Well done! Here is the chain you requested";
    private static String matrixMassage = "Here is the matrix";
    private static String anotherTryMassage = "Try again";
    private static String wordMassage = "Now we need a word, you are my last hope here";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstMassage);
        String stopWord = scanner.nextLine().toUpperCase();
        String request = "";
    
        int run = 0;
        while (!request.equals(stopWord)) {
            request = run(scanner, stopWord, run);
            run++;
        }
    }
    
    private static String run(Scanner scanner, String stopWord, int run) {
        System.out.println(requestMatrix);
        if (run == 0) {
            System.out.println(noticeMassage);
        }
        String matrix = firstParamInput(scanner, stopWord);
        String word = secondParamInput(scanner, stopWord, matrix);
        System.out.println(successMassage);
        
        try {
            System.out.println(MatrixAndWord.getChain(matrix, word));
        } catch (IOException e) {
            System.out.println(errorMassage + e.getMessage());
        }
        System.out.println(anotherRunMassage);
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
            System.out.println(anotherTryMassage);
            firstParamInput(scanner, stopWord);
        }
        System.out.println(matrixMassage);
        System.out.println(Arrays.deepToString(MatrixAndWord.getMatrix(matrix)));
        return matrix;
    }
    
    private static String secondParamInput(Scanner scanner, String stopWord, String matrix) {
        System.out.println(wordMassage);
        String word = scanner.nextLine().toUpperCase();
        if (word.equals(stopWord)) {
            System.exit(0);
        }
        try {
            MatrixAndWord.validateSecondParam(word, matrix);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(anotherTryMassage);
            secondParamInput(scanner, stopWord, matrix);
        }
        return word;
    }
}
