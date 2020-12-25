import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixAndWordTest {
    
    @Test
    void twoNullInputValuesExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain(null, null));
    }
    
    @Test
    void twoEmptyInputValuesExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain("", ""));
    }
    
    @Test
    void firstNullValueInputExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain(null, "SOME"));
    }
    
    @Test
    void secondNullValueInputExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain("SOME", null));
    }
    
    @Test
    void invalidMatrixParamLength() {
        Assertions.assertThrows(Exception.class,
                () -> MatrixAndWord.getChain("som", "som"));
    }
    
    @Test
    void invalidWordParamLength() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain("Some", "something"));
    }
    
    @Test
    void invalidWordCharSequence() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain("something", "smoke"));
    }
    
    @Test
    void invalidNonLetterParamInputs() {
        Assertions.assertThrows(IOException.class,
                () -> MatrixAndWord.getChain("som&thing", "s9o"));
    }
    
    @Test
    void getMatrix() throws IOException {
        char[][] actual = MatrixAndWord.getMatrix("some");
        char[][] expected = new char[][]{{'S', 'O'}, {'M', 'E'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
        
        actual = MatrixAndWord.getMatrix("something");
        expected = new char[][]{{'S', 'O', 'M'}, {'E', 'T', 'H'}, {'I', 'N', 'G'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
        
        actual = MatrixAndWord.getMatrix("QWEASDZXC");
        expected = new char[][]{{'Q', 'W', 'E'}, {'A', 'S', 'D'}, {'Z', 'X', 'C'}};
        Assertions.assertEquals(Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
    
    @Test
    void getChain() throws IOException {
        String actual = MatrixAndWord.getChain("QLGNAEKIRLRNGEAE", "KING");
        String expected = "[1,2]->[1,3]->[0,3]->[0,2]";
        Assertions.assertEquals(expected, actual);
    }
}
