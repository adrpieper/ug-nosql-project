package main;

import org.junit.jupiter.api.Test;
import uber.TestData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adrian on 2017-03-25.
 */
class ToGeoTest {

    ToGeo unterTest = new ToGeo();

    @Test
    void toGeo() {
        unterTest.toGeo(TestData.class.getResourceAsStream("sample.csv"), System.out);
    }

}