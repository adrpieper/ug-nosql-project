
import dto.FormatterProvider;
import dto.Parser;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Adrian on 2017-03-21.
 */

class ParserTest {

    @Test
    public void formatterTest() {
        final DateTimeFormatter formatter = FormatterProvider.provide();
        LocalDateTime dateTime = LocalDateTime.parse("4/1/2014 2:11:00", formatter);
        assertThat(dateTime).isEqualTo(
                LocalDateTime.of(2014,1,4,2,11,0)
        );
    }

    @Test
    public void test() {
        String line = "\"4/1/2014 0:11:00\",40.769,-73.9549,\"B02512\"";
        Parser parser = new Parser();
        parser.parse(line);
    }
}