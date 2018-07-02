package fr.arolla.romannumerals;


enum RomanStep {
    M(1000) ,
    CM(900) ,
    D(500)  ,
    CD(400) ,
    C(100)  ,
    XC(90)  ,
    L(50)   ,
    XL(40)  ,
    X(10)   ,
    IX(9)   ,
    V(5)    ,
    IV(4)   ,
    I(1)    {
        @Override
        RomanStep next() {
            return I;
        }
    };

    int numeric;

    RomanStep(int numeric) {
        this.numeric = numeric;
    }

    RomanStep next(){
        return values()[this.ordinal()+1];
    }

    public static RomanStep penultimate() {
        RomanStep[] values = values();
        return values[values.length-1];
    }

    public static RomanStep last() {
        RomanStep[] values = values();
        return values[values().length];
    }

    public String letter() {
        return name();
    }
}
