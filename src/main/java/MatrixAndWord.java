import java.io.IOException;

public class MatrixAndWord {
    private String matrix;
    private String word;
    
    public MatrixAndWord(String matrix, String word) throws IOException {
        this.matrix = validateFirstParam(matrix);
        this.word = validateSecondParam(word, matrix);
    }
    
    public String getMatrix() {
        return matrix;
    }
    
    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    private String validateFirstParam(String matrix) throws IOException {
        isNotNull(matrix);
        consistsOfLetter(matrix);
        if (Math.sqrt(matrix.length()) % 1 != 0) {
            throw new IOException("Can't create square matrix of " + getMatrix()
                    + "\n please provide proper input");
        }
        return matrix.toUpperCase();
    }
    
    private String validateSecondParam(String word, String matrix) throws IOException {
        isNotNull(word);
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
        return word.toUpperCase();
    }
    
    private void isNotNull(String param) throws IOException{
        if (param == null) {
            throw new IOException("The input values shouldn't be null");
        }
    }
    
    private void consistsOfLetter(String param) throws IOException {
        if (!param.replaceAll("[a-zA-Z]", "").isEmpty()) {
            throw new IOException("Input parameters should contain only letter characters");
        }
    }
}
