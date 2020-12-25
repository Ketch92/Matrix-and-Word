import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixAndWordTest {
    private MatrixAndWord entity;
    
    @Test
    void twoNullValuesInputExceptionExpected() {
        Assertions.assertThrows(IOException.class,
                () -> new MatrixAndWord(null, null));
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
        String actual = entity.getMatrix();
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
}