package util;

import dto.UberPickDTO;
import dto.UberPickParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Created by Adrian on 2017-03-26.
 */
public class StreamUtils {


    public static Stream<String> lines(InputStream is) {
        return new BufferedReader(new InputStreamReader(is)).lines();
    }

    public static Stream<UberPickDTO> dtos(InputStream is) {
        UberPickParser parser = new UberPickParser();
        return lines(is).map(s -> {
            try {
                return parser.parse(s);
            }catch (Exception e){
                return null;
            }
        })
        .filter(dto -> dto!=null);
    }

    public static  <T> void forEach(Stream<T> stream, Consumer<List<T>> consumer, int maxPacketSize) {
        List<T> buffer = new ArrayList<>(maxPacketSize);
        stream.forEach(o ->
                {
                    buffer.add(o);
                    if (buffer.size() == maxPacketSize) {
                        consumer.accept(buffer);
                        buffer.clear();
                    }
                }
        );
        consumer.accept(buffer);
        buffer.clear();
    }

}
