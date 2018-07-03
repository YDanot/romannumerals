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
        RomanStep nextDescending() {
            return I;
        }
    };

    int number;

    RomanStep(int number) {
        this.number = number;
    }

    RomanStep nextDescending(){
        return values()[this.ordinal()+1];
    }

    public static RomanStep secondSmallest() {
        RomanStep[] values = values();
        return values[values.length-2];
    }

    public static RomanStep smallest() {
        RomanStep[] values = values();
        return values[values().length-1];
    }

    public String symbol() {
        return name();
    }
}
