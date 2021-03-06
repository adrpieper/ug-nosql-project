package sql;

import dto.UberPickDTO;

import java.util.Locale;


/**
 * Created by Adrian on 2017-03-26.
 */
public class InsertGenerator {

    public String generate(Iterable<UberPickDTO> iterator) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO public.pick( data_time, latitude, longitude, base) VALUES ");
        boolean first = true;
        for (UberPickDTO dto : iterator) {
            if (!first) {
                stringBuilder.append(',');
            }
            first = false;
            stringBuilder.append(
                    String.format
                            (Locale.US,
                            "((TIMESTAMP '%s'), %f, %f, '%s')"
                            ,dto.getDateTime().toString()
                            ,dto.getLatitude()
                            ,dto.getLongitude()
                            ,dto.getBase()
                    )
            );
        }
        stringBuilder.append(';');
        return stringBuilder.toString();
    }
}
