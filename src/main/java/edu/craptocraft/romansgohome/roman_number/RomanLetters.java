package edu.craptocraft.romansgohome.roman_number;

public enum RomanLetters {
    
    I(1), V(5), X(10), L(50),
    C(100), D(500), M(1000),
	IV(4), IX(9), XL(40),
    XC(90),CD(400), CM(900);

    private int valueDecimal;

    private RomanLetters(int valueDecimal) {
        this.valueDecimal = valueDecimal;
    }

    public int getValueDecimal() {
        return this.valueDecimal;
    }

}
