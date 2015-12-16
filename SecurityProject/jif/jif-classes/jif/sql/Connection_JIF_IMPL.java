package jif.sql;

public abstract class Connection_JIF_IMPL {
    
    public static boolean jif$Instanceof(final Object o) {
        return o instanceof Connection;
    }
    
    public static Connection jif$cast$jif_sql_Connection(final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(o)) return (Connection) o;
        throw new ClassCastException();
    }
    
    public Connection_JIF_IMPL() { super(); }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 0L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "WJWzz+vDMSDBodzu9XU8/gXbhSxNTgsAAA==");
}
