import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixAndWordTest {
    private MatrixAndWord entity;
    
    @Test
    void twoNullValuesInputExceptionExpected() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord(null, null));
    }
    
    @Test
    void firstNullValueInputExceptionExpected() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord(null, "SOME"));
    }
    
    @Test
    void secondNullValueInputExceptionExpected() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord("SOME", null));
    }
    
    @Test
    void validStringLength() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord("som", "som"));
    }
}