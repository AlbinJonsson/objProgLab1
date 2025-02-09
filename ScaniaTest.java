import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania();
    }

    @Test
    void raiseFlak() { assertEquals(1, scania.getFlakAngle());
    }

    @Test
    void downFlak() { assertEquals(0, scania.getFlakAngle());
    }

    @Test
    void getFlakAngle() { assertEquals(0, scania.getFlakAngle());
    }

    @Test
    void move() {
    }
}