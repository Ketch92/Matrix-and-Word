import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixAndWordTest {
    private MatrixAndWord entity;
    
    @Test
    void twoNullInputValuesExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord(null, null));
    }
    
    @Test
    void twoEmptyInputValuesExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord("", ""));
    }
    
    @Test
    void firstNullValueInputExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord(null, "SOME"));
    }
    
    @Test
    void secondNullValueInputExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord("SOME", null));
    }
    
    @Test
    void invalidMatrixParamLength() {
        Assertions.assertThrows(Exception.class,
                () -> new MatrixAndWord("som", "som"));
    }
    
    @Test
    void validMatrixParamLength() throws IOException {
        entity = new MatrixAndWord("some", "som");
        String actual = entity.getMatrixParam();
        String expected = "SOME";
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void invalidWordParamLength() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord("Some", "something"));
    }
    
    @Test
    void validWordParamLength() throws IOException {
        entity = new MatrixAndWord("some", "som");
        String actual = entity.getWord();
        String expected = "SOM";
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void invalidWordCharSequence() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord("something", "smoke"));
    }
    
    @Test
    void validWordCharSequence() throws IOException {
        entity = new MatrixAndWord("something", "some");
        String actualWord = entity.getWord();
        String expectedWord = "SOME";
        Assertions.assertEquals(expectedWord, actualWord);
    }
    
    @Test
    void invalidNonLetterParamInputs() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord("som&thing", "s9o"));
    }
    
    @Test
    void getMatrix() throws IOException {
        entity = new MatrixAndWord("some", "som");
        char[][] actual = entity.getMatrix();
        char[][] expected = new char[][]{{'S', 'O'}, {'M', 'E'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
        
        entity = new MatrixAndWord("SOMETHING", "som");
        actual = entity.getMatrix();
        expected = new char[][]{{'S', 'O', 'M'}, {'E', 'T', 'H'}, {'I', 'N', 'G'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
        
        entity = new MatrixAndWord("QWEASDZXC", "qwe");
        actual = entity.getMatrix();
        expected = new char[][]{{'Q', 'W', 'E'}, {'A', 'S', 'D'}, {'Z', 'X', 'C'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
    
    @Test
    void getChain() throws IOException {
        entity = new MatrixAndWord("QLGNAEKIRLRNGEAE", "KING");
        String actual = entity.getChain();
    }
}
