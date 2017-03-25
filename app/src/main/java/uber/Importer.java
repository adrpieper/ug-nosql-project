package uber;

import dto.UberPickDTO;
import dto.UberPickParser;
import http.UberPickHttpClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Adrian on 2017-03-25.
 */
public class Importer {

    private UberPickParser parser = new UberPickParser();
    private UberPickHttpClient client = new UberPickHttpClient();
    private List<UberPickDTO> buffer;

    public void sendToDb(InputStream is, int maxPacketSize) {
        Scanner scanner = new Scanner(is);
        buffer = new ArrayList<>(maxPacketSize);

        while (scanner.hasNext()) {
            try {
                UberPickDTO dto = parser.parse(scanner.nextLine());
                buffer.add(dto);
                if (buffer.size() == maxPacketSize) {
                    flush();
                }
            }catch (Exception e) {}
        }
        scanner.close();
        flush();
    }

    private void flush() {
        client.post(buffer);
        buffer.clear();
    }
}
