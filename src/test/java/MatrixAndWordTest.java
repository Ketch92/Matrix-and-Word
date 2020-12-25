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
    
//    @Test
//    void validStringLength() {
//        int actualLength = entity.getMatrixDimension().length();
//        for (int i = 1; i < 100; i++) {
//            if(actualLength == Math.pow(i, 2));
//        }
//    }
}