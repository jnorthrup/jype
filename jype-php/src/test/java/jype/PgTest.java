package jype;


import junit.framework.*;

import java.sql.*;
import java.util.*;

/**
 * User: jim
 * Date: Nov 6, 2008
 * Time: 8:15:01 PM
 */
public class PgTest extends TestCase {
    public void testMusic() throws SQLException {


        String url = "jdbc:postgresql://keyframe/music?user=jim";
        Properties props = new Properties();
        props.setProperty("user", "jim");
        org.postgresql.Driver d = new org.postgresql.Driver();
        Connection c
                = d.connect(url, props);

        final DatabaseMetaData metaData = c.getMetaData();
        final ResultSet set = metaData.getTables(null, "public", null, new String[]{"TABLE"});

        final ResultSetMetaData meta = set.getMetaData();
        final int columnCount = meta.getColumnCount();
        ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0;i<columnCount;i++){
            list.add(meta.getColumnName(1+i));
        }
        
        
        /*
        table_cat:null
table_schem:public
table_name:ad
table_type:TABLE
remarks:null
         */
        while(set.next()){

         }
    }
}
