import org.example.Rationnel;
import org.example.exception.RationnalException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RationnelTest {
    @Test
    void testCreationRationnel() throws RationnalException{
        Rationnel rationnel = new Rationnel(2, 4);
        assertAll(
                () -> assertEquals(rationnel.getNumerator(), 2,"Le numérateur de 2/4 est 2"),
                () -> assertEquals(rationnel.getDenominator(), 4,"Le dénominateur de 2/4 est 4"),
                () -> assertEquals(rationnel.getRationnel(), 1 / 2)
        );
    }
    @Test
    void testDenominateurRationnel() {
        Rationnel rationnel = new Rationnel(2, 4);
        assertThrows(RationnalException.class,()->new Rationnel(2, 0));
    }
    @Test
    void testAddRationnel(){
        Rationnel rationnel = new Rationnel(2, 3);
        Rationnel rationnel2 = new Rationnel(1, 2);
        Rationnel result = new Rationnel(7, 6);
//        assertEquals(result.getNumerator(), rationnel.add(rationnel2).getNumerator());
//        assertEquals(result.getDenominator(), rationnel.add(rationnel2).getDenominator());
        assertEquals(result,rationnel.add(rationnel2));
    }
    @Test
    void testSimplifyRationnel(){
        Rationnel rationnel = new Rationnel(2, 4);
        Rationnel result = new Rationnel(1, 2);
        rationnel.simplification();
        assertEquals(result,rationnel);
        assertEquals(result,rationnel);
    }

    @DisplayName("Rationnel simplficication")
    @ParameterizedTest(name = "test {index}: la verison simplififé de {0}/{1} est {2}/{3}")
    @MethodSource("rationnalProvider")
    void testSimplifyRationnel2(int n1,int d1,int n2, int d2){
        Rationnel rationnel = new Rationnel(n1, d1);
        rationnel.simplification();
        assertEquals(rationnel,new Rationnel(n2,d2));
        assertEquals(rationnel,new Rationnel(n2,d2));
    }

    static Stream<Arguments> rationnalProvider(){
        return Stream.of(
          Arguments.arguments(2,4,1,2),
          Arguments.arguments(12,15,4,5)
        );
    }
    @BeforeEach
    void init(){
        System.out.println("init");
    }
}
