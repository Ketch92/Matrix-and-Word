public class MatrixAndWord {
    private int matrixDimension;
    private String word;
    
    public MatrixAndWord(int matrixDimension, String word) {
        this.matrixDimension = matrixDimension;
        this.word = word;
    }
    
    public int getMatrixDimension() {
        return matrixDimension;
    }
    
    public void setMatrixDimension(int matrixDimension) {
        this.matrixDimension = matrixDimension;
    }
    
    public String getWord() {
        return word;
    }
    
    public void setWord(String word) {
        this.word = word;
    }
}
