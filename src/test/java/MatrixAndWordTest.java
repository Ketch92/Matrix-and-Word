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
    void invalidMatrixParamLength() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord("som", "som"));
    }
    
    @Test
    void validMatrixParamLength() {
        entity = new MatrixAndWord("some", "som");
        String actual = entity.getMatrix();
        String expected = "SOME";
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    void invalidWordParamLength() {
        Assertions.assertThrows(RuntimeException.class,
                () -> new MatrixAndWord("Some", "something"));
    }
    
    @Test
    void validWordParamLength() {
        entity = new MatrixAndWord("some", "som");
        String actual = entity.getWord();
        String expected = "SOM";
        Assertions.assertEquals(expected, actual);
    }
}