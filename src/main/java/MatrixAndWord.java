public class MatrixAndWord {
    private String matrixDimension;
    private String word;
    
    public MatrixAndWord(String matrixDimension, String word) {
        this.matrixDimension = isValidInput(matrixDimension);
        this.word = isValidInput(word);
    }
    
    public String getMatrixDimension() {
        return matrixDimension;
    }
    
    public void setMatrixDimension(String matrixDimension) {
        this.matrixDimension = matrixDimension;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    private String isValidInput(String input) {
        if (input == null) {
            throw new RuntimeException("The input values shouldn't be null");
        }
        return input;
    }
}
