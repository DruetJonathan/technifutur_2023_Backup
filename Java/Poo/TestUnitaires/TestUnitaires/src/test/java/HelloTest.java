import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    public void helloTest(){
        assertEquals("hello", Main.getHello());
//        assertEquals("helloo", Main.getHello());
    }
}
