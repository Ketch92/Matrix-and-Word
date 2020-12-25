import java.io.IOException;
import java.util.Arrays;

public class MatrixAndWord {
    private String matrix;
    private String word;
    private int matrixDimensions;
    
    public MatrixAndWord() {
    
    }
    
    public MatrixAndWord(String matrix, String word) throws IOException {
        this.matrix = validateFirstParam(matrix);
        this.word = validateSecondParam(word, this.matrix);
        matrixDimensions = (int) Math.sqrt(matrix.length());
    }
    
    public String getChain() {
        return "";
    }
    
    public char[][] getMatrix() {
        char[][] matrix = new char[matrixDimensions][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.copyOfRange(this.matrix.toCharArray(),
                    i * matrixDimensions, (i + 1) * matrixDimensions);
        }
        return matrix;
    }
    
    public String getMatrixParam() {
        return matrix;
    }
    
    public void setMatrix(String matrix) {
        try {
            this.matrix = validateFirstParam(matrix);
        } catch (IOException e) {
            throw new RuntimeException("Can't set " + matrix + " as parameter", e);
        }
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        try {
            this.word = validateSecondParam(word, matrix);
        } catch (IOException e) {
            throw new RuntimeException("Can't set " + word + " as parameter", e);
        }
    }
    
    private String validateFirstParam(String matrix) throws IOException {
        isNotNullAndNotEmpty(matrix);
        consistsOfLetter(matrix);
        if (Math.sqrt(matrix.length()) % 1 != 0) {
            throw new IOException("Can't create square matrix of " + matrix
                    + "\n please provide proper input");
        }
        return matrix.toUpperCase();
    }
    
    private String validateSecondParam(String word, String matrix) throws IOException {
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
        return word;
    }
    
    private void isNotNullAndNotEmpty(String param) throws IOException {
        if (param == null || param.isEmpty()) {
            throw new IOException("The input values shouldn't be null or empty");
        }
    }
    
    private void consistsOfLetter(String param) throws IOException {
        if (!param.replaceAll("[a-zA-Z]", "").isEmpty()) {
            throw new IOException("Input parameters should contain only letter characters");
        }
    }
}
