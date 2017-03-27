package main;

import sql.SqlImporter;
import uber.ElasticSearchImporter;

/**
 * Created by Adrian on 2017-03-25.
 */
public class SqlImportMain {

    public static void main(String[] args) {
        new SqlImporter().importToDb(System.in, 100);
    }
}
