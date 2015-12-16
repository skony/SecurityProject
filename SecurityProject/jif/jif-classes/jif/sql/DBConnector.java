package jif.sql;

import java.sql.*;

public class DBConnector {
    static final String DB_URL = "jdbc:mysql://localhost/my_db";
    static final String USER = "root";
    static final String PASS = "root";
    Connection conn;
    
    DBConnector jif$sql$DBConnector$() throws Exception {
        this.jif$init();
        {
            Connection conn =
              DriverManager.getConnection(DBConnector.DB_URL, DBConnector.USER,
                                          DBConnector.PASS);
            ;
        }
        return this;
    }
    
    public void saveData(final MyData myDataRec) {
        try {
            Statement stmt = this.conn.createStatement();
            int key = myDataRec.getkey();
            String secret = myDataRec.getsecret();
            {
                int kk = key;
                String ss = secret;
                String sql = "INSERT INTO DB.TABLE VALUES (" + kk + "," + ss +
                ")";
                stmt.executeUpdate(sql);
            }
            stmt.close();
        }
        catch (final Exception e) {  }
    }
    
    public MyData dbGetRecord(final int key) {
        MyData myDataRec = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = null;
            String sql;
            {
                int kk = key;
                sql = "SELECT * FROM DB.TABLE WHERE key=\'" + kk + "\'";
            }
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int k = rs.getInt("Key");
                String secret = rs.getString("Secret");
                myDataRec = new MyData().jif$sql$MyData$(k, secret);
            } else
                myDataRec = null;
            stmt.close();
        }
        catch (final Exception e) {  }
        return myDataRec;
    }
    
    void test1() {
        MyData d1 = new MyData().jif$sql$MyData$(1, "foo");
        MyData d2 = this.dbGetRecord(2);
        if (d2 != null) {
            int k0 = d2.getkey();
            String s0 = d1.getsecret();
            this.saveData(new MyData().jif$sql$MyData$(k0 + 1, s0));
            this.saveData(d2);
        }
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1450279432000L;
    public static final String jlc$ClassType$jif =
      ("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");
    
    public DBConnector() { super(); }
    
    public void jif$invokeDefConstructor() throws Exception {
        this.jif$sql$DBConnector$();
    }
    
    private void jif$init() { conn = null; }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1450279432000L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "RxXTe4myhhGQF/jWdchjCx8RhjNMofPj");
    public static final String jlc$ClassType$jl$1 =
      ("3IUTK2tEK+gDmooLnIXVBWyn5FI4cIws6DywFAVnJ68agS0Nlwd8J2w7DEsj" +
       "0V9sY9iLhAVISpw3TKceu5lMTp+f7cuP7y+d0wD37oo8kAC4SJK8eio+ei/d" +
       "cf49eXlj4NOX9SeupDuuJAsHp0/rH3m3yx3nz+rf/Km3v2Hzfwu6eZkHMYrB" +
       "M0WcfCZwKie4gurJHtMPXsPEni+03E8e/h32W9+lP2H91ZuDx+7l/d5xL+bB" +
       "Sa8/mO17NnOKMovkB3J+3/9gruiUi3ppMLjx+cuau5rquf+R/93yPI/ItpbX" +
       "xm5cXjG4TAm9735mZd5YTnLKCZ3n1aciKQbf16/e7TwNbl+5z3D7PkfRPTme" +
       "PZH8YP98oEf/u5f1d99FjgeX/6yCZy6nfOey/ifXl/9dZXj+blqLbUmjMM50" +
       "vvgIlfz0qXizGDydG5VzmnGG+sJl3uZU/XgxeLyKPfthIqIXJvp4cVkv/+9E" +
       "PE1ZXNbT/zMRr3H2mBcVZ0JffYSMP38q/lIxeI9t0k4hOlacnb3zJ6+JdHNw" +
       "mTllB4Onfuqybt4h0qnIHkHu648Y+xun4mvF4InCyQvo9OdnrjFxvjj0iZO8" +
       "l6HgXBeDn3jnfY/P3krL/hUxLePC+eTFNYpbp5W6dTLTfhONjw7puFfuvHzy" +
       "tVvnyyb5rc/fM/A3jdB86wvyrTeLg5ffeZiBf/K119967d7dkkdFrAdYPo1+" +
       "I0keoYy/+fB1Pv1tzgDfPBW/WAw+9G4CPUyBTw8u4sZ1Bap/lgIzr+o7r2rQ" +
       "K3qNvXnr805lBJ88JY/Pyrr1I7eiMghee/0L0q3rirkek24Ug6cuETcP6uup" +
       "h+nrlx+pr28/Yuzvn4q/3fvxXc7Pqml6o7+ylKdLLB96x/XNi0uG1re/8cLT" +
       "H/yG8m/ON5zuXQR8khk87fbSXr2xcaX9ZJI5rnfm4MmL+xsX6vhHvdyXkah3" +
       "0r48M/0PLwZ/ve+63Af/cfKQKxQXV0ua/w3JVuoAcCoAAA==");
}
