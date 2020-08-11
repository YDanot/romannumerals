package fr.shodo.romannumerals.domain;


import fr.shodo.romannumerals.utils.PositiveInteger;

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

    private final PositiveInteger algebraic;

    RomanStep(int number) {
        this.algebraic = PositiveInteger.from(number);
    }

    public PositiveInteger algebraic() {
        return algebraic;
    }

    public String symbol() {
        return name();
    }

    public String repeatSymbol(PositiveInteger times){
        return new String(new char[times.value()]).replace("\0", symbol());
    }

    public RomanStep lower() {
        checkLast(this);
        return values()[ordinal()+1];
    }

    private void checkLast(RomanStep romanStep) {
        if (I.equals(romanStep)) {
            throw new IllegalArgumentException("I doesn't have any lower roman step");
        }
    }
}
