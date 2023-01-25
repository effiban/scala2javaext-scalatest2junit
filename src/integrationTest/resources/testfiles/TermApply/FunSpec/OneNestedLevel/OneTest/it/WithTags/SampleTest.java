package dummy;

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    public SampleTest() {
    }

    @Nested
    @DisplayName("air conditioner")
    public class AirConditioner {

        public AirConditioner() {
        }

        @Test
        @DisplayName("should lower temperature when cooling selected")
        @Tag("tag1")
        @Tag("tag2")
        public void shouldLowerTemperatureWhenCoolingSelected() {
            checkCooling();
        }
    }
}