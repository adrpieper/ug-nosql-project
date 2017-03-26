package sql;

import dto.UberPickDTO;


/**
 * Created by Adrian on 2017-03-26.
 */
public class InsertGenerator {

    public String generate(Iterable<UberPickDTO> iterator) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO public.pick( data_time, longitude, latitude, base) VALUES ");
        boolean first = true;
        for (UberPickDTO dto : iterator) {
            if (!first) {
                stringBuilder.append(',');
            }
            first = false;
            stringBuilder.append(String.format("((TIMESTAMP '2011-05-16 15:36:38'), 4, 23, '%s')",dto.getBase()));
        }
        stringBuilder.append(';');
        return stringBuilder.toString();
    }
}
