package fr.shodo.romannumerals.domain;


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
    I(1)    ;

    PositiveInteger number;

    RomanStep(int number) {
        this.number = PositiveInteger.from(number);
    }

    String symbol() {
        return name();
    }

    String repeatSymbol(PositiveInteger times){
        return new String(new char[times.value]).replace("\0", symbol());
    }

    RomanStep lower() {
        if (I.equals(this)) {
            throw new IllegalArgumentException("I doesn't have any lower roman step");
        }
        return values()[ordinal()+1];
    }
}
