package dummy;

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.MatcherAssert.*;

public class SampleTest {

    public SampleTest() {
    }

    public void dummy() {
        assertThat(((Supplier<Object>)() ->  {
                    final var x = 1;
                    final var y = 2;
                    /* return? */x + y;
                }
                ).get(), is(3));
    }
}