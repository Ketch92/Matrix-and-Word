import java.io.IOException;
import java.util.Arrays;

public class MatrixAndWord {
    public static String getChain(String matrix, String word) throws IOException {
        validateFirstParam(matrix);
        validateSecondParam(word, matrix);
        
        matrix = matrix.toUpperCase();
        word = word.toUpperCase();
        int matrixDimensions = matrix.length();
        int chainIndex = 0;
        String tempMatrix = matrix;
        String[] chain = new String[word.length()];
        
        for (String wordChar : word.split("")) {
            int index = tempMatrix.indexOf(wordChar);
            chain[chainIndex++] = String.format("[%d,%d]", index / matrixDimensions, index % matrixDimensions);
            tempMatrix = tempMatrix.replaceFirst(wordChar, " ");
        }
        return String.join("->", chain);
    }
    
    public static char[][] getMatrix(String matrix) throws IOException {
        validateFirstParam(matrix);
        char[][] matrixArray = new char[matrix.length()][];
        char[] matrixChars = matrix.toUpperCase().toCharArray();
        for (int i = 0; i < matrix.length(); i++) {
            matrixArray[i] = Arrays.copyOfRange(matrixChars,
                    i * matrix.length(), (i + 1) * matrix.length());
        }
        return matrixArray;
    }
    
    private static void validateFirstParam(String matrix) throws IOException {
        isNotNullAndNotEmpty(matrix);
        consistsOfLetter(matrix);
        if (Math.sqrt(matrix.length()) % 1 != 0) {
            throw new IOException("Can't create square matrix of " + matrix
                    + "\n please provide proper input");
        }
    }
    
    private static void validateSecondParam(String word, String matrix) throws IOException {
        isNotNullAndNotEmpty(word);
        word = word.toUpperCase();
        consistsOfLetter(word);
        if (word.length() > matrix.length()) {
            throw new IOException("It isn't possible to give a proper"
                    + "output with given input parameters");
        }
        String actualMatrix = matrix;
        for (String character : word.split("")) {
            actualMatrix = actualMatrix.replaceFirst(character, "");
        }
        int actual = actualMatrix.length();
        int expected = matrix.length() - word.length();
        if (actual != expected) {
            throw new IOException("It isn't possible to give a proper"
                    + "output with given input parameters");
        }
    }
    
    private static void isNotNullAndNotEmpty(String param) throws IOException {
        if (param == null || param.isEmpty()) {
            throw new IOException("The input values shouldn't be null or empty");
        }
    }
    
    private static void consistsOfLetter(String param) throws IOException {
        if (!param.replaceAll("[a-zA-Z]", "").isEmpty()) {
            throw new IOException("Input parameters should contain only letter characters");
        }
    }
}
