package dto;

import java.time.format.DateTimeFormatter;

/**
 * Created by Adrian on 2017-03-22.
 */
public class FormatterProvider {

    public static DateTimeFormatter provide(){
        return DateTimeFormatter.ofPattern("d/M/yyyy H:mm:ss");
    }
}
