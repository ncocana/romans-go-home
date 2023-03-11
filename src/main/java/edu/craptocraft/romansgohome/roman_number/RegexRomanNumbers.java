package edu.craptocraft.romansgohome.roman_number;

public class RegexRomanNumbers {
    
    private String regexExpression;

    public RegexRomanNumbers() {
        this.initRegex();
    }

    private void initRegex() {
        this.regexExpression = "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    }

    @Override
    public String toString() {
        return this.regexExpression;
    }

}
