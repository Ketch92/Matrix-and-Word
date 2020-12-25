public class MatrixAndWord {
    private String matrix;
    private String word;
    
    public MatrixAndWord(String matrix, String word) {
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
    
    private String validateFirstParam(String matrix) {
        if (matrix == null) {
            throw new RuntimeException("The input values shouldn't be null");
        }
        if (Math.sqrt(matrix.length()) % 1 != 0) {
            throw new RuntimeException("Can't create square matrix of " + getMatrix()
                    + "\n please provide proper input");
        }
        return matrix.toUpperCase();
    }
    
    private String validateSecondParam(String word, String matrix) {
        if (word == null) {
            throw new RuntimeException("The input values shouldn't be null");
        }
        if (word.length() > matrix.length()) {
            throw new RuntimeException("It isn't possible to give a proper"
                    + "output with given input parameters");
        }
        return word.toUpperCase();
    }
}
