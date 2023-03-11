package edu.craptocraft.romansgohome.roman_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {

    private final String romanNum;
    private int decimalNumber = 0;
    private RegexRomanNumbers regexExpression = null;

    public RomanNumber(String romanNum) {
        this.romanNum = romanNum;
        this.decimalNumber = 0;
        this.regexExpression = new RegexRomanNumbers();
    }
    
    public Object getRegexExpression() {
        return this.regexExpression;
    }

    public int getDecimalNumber() {
        return this.decimalNumber;
    }

    @Override
    public String toString() {
        return this.romanNum;
    }

    // private Matcher createMatcher(String regex) {
    //     Pattern pattern = Pattern.compile(regex);
    //     return pattern.matcher(this.romanNum);
    // }

    public int decimalValue(String romanNum) {
        RomanLetters letter = Enum.valueOf(RomanLetters.class, String.valueOf(romanNum));
        return letter.getValueDecimal();
    }

    public int toDecimal() {
        if (!this.romanNum.matches(this.getRegexExpression().toString())) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }

        for (int i = 0; i < this.romanNum.length(); i++) {
            char currentChar = this.romanNum.charAt(i);
            RomanLetters currentLetter = RomanLetters.valueOf(String.valueOf(currentChar));

            if (i < this.romanNum.length() - 1) {
                char nextChar = this.romanNum.charAt(i + 1);
                RomanLetters nextLetter = RomanLetters.valueOf(String.valueOf(nextChar));

                if (nextLetter.getValueDecimal() > currentLetter.getValueDecimal()) {
                    this.decimalNumber -= currentLetter.getValueDecimal();
                } else {
                    this.decimalNumber += currentLetter.getValueDecimal();
                }
            } else {
                this.decimalNumber += currentLetter.getValueDecimal();
            }
        }

        return decimalNumber;
    }

}
