import java.io.IOException;
import java.util.Arrays;

public class MatrixAndWord {
    public static String getChain(String matrix, String word) throws IOException {
        matrix = validateFirstParam(matrix);
        word = validateSecondParam(word, matrix);
        
        String format = "[%d,%d]";
        String delimiter = "->";
        String space = " ";
        int matrixDimensions = (int) Math.sqrt(matrix.length());
        int chainIndex = 0;
        String tempMatrix = matrix;
        String[] chain = new String[word.length()];
        
        for (String wordChar : word.split("")) {
            int index = tempMatrix.indexOf(wordChar);
            chain[chainIndex++] = String.format(format, index / matrixDimensions, index % matrixDimensions);
            tempMatrix = tempMatrix.replaceFirst(wordChar, space);
        }
        return String.join(delimiter, chain);
    }
    
    public static char[][] getMatrix(String matrix) {
        try {
            validateFirstParam(matrix);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with given value");
        }
    
        int length = (int) Math.sqrt(matrix.length());
        char[][] matrixArray = new char[length][];
        char[] matrixChars = matrix.toUpperCase().toCharArray();
        
        for (int i = 0; i < length; i++) {
            matrixArray[i] = Arrays.copyOfRange(matrixChars,
                    i * length, (i + 1) * length);
        }
        return matrixArray;
    }
    
    public static String validateFirstParam(String matrix) throws IOException {
        isNotNullAndNotEmpty(matrix);
        consistsOfLetter(matrix);
        
        matrix = matrix.toUpperCase();
        if (Math.sqrt(matrix.length()) % 1 != 0) {
            throw new IOException("Can't create square matrix of " + matrix
                    + "\nplease provide proper input");
        }
        return matrix;
    }
    
    public static String validateSecondParam(String word, String matrix) throws IOException {
        isNotNullAndNotEmpty(word);
        consistsOfLetter(word);
        validateFirstParam(matrix);
        
        word = word.toUpperCase();
        matrix = matrix.toUpperCase();
        String errorMassage = "It isn't possible to give a proper "
                + "output with given input parameters";
        
        if (word.length() > matrix.length()) {
            throw new IOException(errorMassage);
        }
        
        String actualMatrix = matrix;
        for (String character : word.split("")) {
            actualMatrix = actualMatrix.replaceFirst(character, "");
        }
        int actual = actualMatrix.length();
        int expected = matrix.length() - word.length();
        if (actual != expected) {
            throw new IOException(errorMassage);
        }
        return word;
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
