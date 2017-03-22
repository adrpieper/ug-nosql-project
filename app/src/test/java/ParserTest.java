import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-21.
 */

class ParserTest {

    @Test
    public void test() {
        String line = "\"4/1/2014 0:11:00\",40.769,-73.9549,\"B02512\"";
        Parser parser = new Parser();
        parser.parse(line);
    }
}