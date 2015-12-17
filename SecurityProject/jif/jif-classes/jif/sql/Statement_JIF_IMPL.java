package jif.sql;

public abstract class Statement_JIF_IMPL {
    
    public static boolean jif$Instanceof(final Object o) {
        return o instanceof Statement;
    }
    
    public static Statement jif$cast$jif_sql_Statement(final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(o)) return (Statement) o;
        throw new ClassCastException();
    }
    
    public Statement_JIF_IMPL() { super(); }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1450363369000L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "WJWrL+jDCSDBodzu8nUw/gWlcdqlSQsAAA==");
}
