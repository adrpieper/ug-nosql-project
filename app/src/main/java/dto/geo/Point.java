package dto.geo;

import java.util.Arrays;

/**
 * Created by Adrian on 2017-03-25.
 */
public class Point {

    public float[] coordinates = {0,0};

    public Point(float lat, float lon) {
        coordinates[0] = lat;
        coordinates[1] = lon;
    }

    public Point(float[] location) {
        coordinates = Arrays.copyOf(location, 2);
    }

    public String getType() {
        return "Point";
    }
}
