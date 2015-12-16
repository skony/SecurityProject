package jif.sql;

public abstract class ResultSet_JIF_IMPL {
    
    public static boolean jif$Instanceof(final Object o) {
        return o instanceof ResultSet;
    }
    
    public static ResultSet jif$cast$jif_sql_ResultSet(final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(o)) return (ResultSet) o;
        throw new ClassCastException();
    }
    
    public ResultSet_JIF_IMPL() { super(); }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 0L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "sCpXX9CHE0CCQ7nd5etg/AvZ63haSQsAAA==");
}
