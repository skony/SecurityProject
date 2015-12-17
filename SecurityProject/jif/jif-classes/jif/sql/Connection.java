package jif.sql;

public interface Connection {
    
    Statement createStatement();
    
    CallableStatement prepareCall(final String sql);
    
    void close();
    
    String jlc$CompilerVersion$jif = "3.4.3";
    long jlc$SourceLastModified$jif = 1450363436000L;
    String jlc$ClassType$jif =
      ("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");
    String jlc$CompilerVersion$jl = "2.7.0";
    long jlc$SourceLastModified$jl = 1450363436000L;
    String jlc$ClassType$jl =
      ("H4sIAAAAAAAAALV6W7Ds2FVY3zszd8bjwfMAG4/xDMaeEDyyr7ql1qNrIJWW" +
       "1GpJ3S2ppZZaLQiDni2p9X60pAa7CFSCg1PGlYzBpGJXPkxCiMMrRVIV45Tz" +
       "AdhliqoAIUlVwP4glVDEH3yk8pOESH3OvefcO9d3bGx31V7avffaa6+19lpr" +
       "b62tT39l8FiRD96VJmG7D5PydtmmTnFbNPLCscnQKIpN1/Cq9TEAfO3nfviZ" +
       "X39k8LQ+eNqP5dIofYtM4tJpSn3wVOREppMXU9t2bH3wbOw4tuzkvhH6pw4x" +
       "ifXBc4W/j42yyp1CcookPPaIzxVV6uTnOe80LgdPWUlclHlllUlelINnloFx" +
       "NMCq9ENw6RflK8vBLdd3QrvIBh8c3FgOHnNDY98hvm15RwrwTBGk+/YO/Um/" +
       "YzN3Dcu5M+TRgx/b5eC77x9xV+KXFh1CN/TxyCm95O5Uj8ZG1zB47oKl0Ij3" +
       "oFzmfrzvUB9Lqm6WcvCOr0q0Q3oiNayDsXdeLQdvvx9PvOjqsN50Vks/pBy8" +
       "9X60M6UmH7zjvjW7tlpf4b//Iz8aM/HNM8+2Y4U9/491g168b5DkuE7uxJZz" +
       "MfCpl5c/a7ztsx+6ORh0yG+9D/kC59/82F/8zfe9+LnPX+B81wNwBDNwrPJV" +
       "61PmW/7DO8n3Th7p2XgiTQq/N4V7JD+vqnjZ80qTdrb4trsU+87bdzo/J/32" +
       "7sd/yfnzm4Mn2cEtKwmrqLOqZ60kSv3QyedO7ORG6djs4E1ObJPnfnbweFdf" +
       "+rFz0Sq4buGU7ODR8Nx0Kzn/71TkdiR6FT3a1f3YTe7UU6P0zvUmHQwGj3dl" +
       "8F1deaQr7798Pl8ORNBLIgdM/aTMnQO490tQdqwq98tWzJNeF6/7H/huX95f" +
       "5BZYZCHYeVLctXdy3u6a028BzaaX49vqGzc6Fb/zfncPO99gktB28let1ypi" +
       "9he//OoXb941+EsNdHbf0bndkb59RXpw48aZ5Hf0HnGxYp2+D50fd6761Hvl" +
       "v8X9yIfe3empSetHe/U1Z1d66/nPI8XrDZLuPZvt/N/ojPJVSwc//Y/fQf6N" +
       "Pz8z86YuMJRGt3Sdl714v1vcY8m9f9wvpGrkV3ShX4r+18133/qtm4PH9cEz" +
       "54BjxKVqhJUjO11Ae9IvyMvG5eDb7um/1/0vbP2VSzcrB++8n69r075yJ1b1" +
       "Krh5Xbldvcfu64+fF+rNZ5y3/GX3u9GV/9eXXn19Q//smCAvLf9dd00/TZsb" +
       "N8rBY/Dt8W24H/9CvzD3K7hn4Afk9BP/+ff+DL7Zs3Enfj59LdB2Snjlms/2" +
       "xJ46e+ezV+u8yZ1eWX/8cfEffuwrP/WD50XuMN7zoAlf6mHPsdFxmuR/5/PZ" +
       "f/nSn3zqD2/eNYxHysGttDJD3+oqxXl36SRx/dgIzwp5sRx8ZxBaL92RWu12" +
       "m46xlzqLPKvquW6jOLPWr8rti6B8tvhz79vPJJqzpb7lCm2ZdJH7w3/60d/9" +
       "mfd8qbMwbvDYsV/hzniu0eKrfmv7u5/+2Atvfu3LHz5zPBjcWP+q85kv91Rv" +
       "nyf4njN8qQd//UKevvp9PXhvD16+I8Q7eiHkpMotZ2kU5Sqx/W4zs89yvN4b" +
       "xNyPugU4XoZn50Ov/fRf3v7Iazev7WHved02cn3MxT52nvzJCx10s3zPw2Y5" +
       "j6D/+6984DO/+IGfuojxz90bkWdxFf3LP/q/v3v741/+wgOCxKNh8kDVl89+" +
       "jhkX7PTOb6kaDjJVGik+ajsEwzeIQzQnxgpaZQSNZ/tgxpDeab83StjWHJYp" +
       "6cDMTdiMCEhPg1SUdmvypLBrWVGJlZyt5wc6i+s1Lx/KQ+tlObkXmUbdcMFY" +
       "ZmoVzAilkQt1dmiok2sPJwEC28K4FTMkcyAdq3IMjDGwQpExarHu0I7GjZuh" +
       "WmAueDp294ulDRXQFOF5/Yg2gZmg4RQ8gi49EpE81xw/Xcp2OD8KcsFLw0Di" +
       "Fum6QE96GWxHB33utbm9CLgltxo2PHfaMiN5w035NcRAuzRaza1JpdOzQyQn" +
       "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" +
       "tqkOnoX504vO/9E1Xb5h/Vl3NPn/qkWz7d0nAAA=");
}
