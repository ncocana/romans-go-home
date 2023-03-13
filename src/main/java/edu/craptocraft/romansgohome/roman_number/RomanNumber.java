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

    public int decimalValue(String number) {
        if (!number.matches(this.getRegexExpression().toString())) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }

        for (int i = 0; i < number.length(); i++) {
            char currentChar = number.charAt(i);
            RomanLetters currentLetter = RomanLetters.valueOf(String.valueOf(currentChar));

            if (i < number.length() - 1) {
                char nextChar = number.charAt(i + 1);
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

    private Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(this.romanNum);
    }

    public int toDecimal() {
        Matcher matcher = createMatcher(this.getRegexExpression().toString());
        while (matcher.find()) {
            this.decimalNumber += decimalValue(matcher.group());
        }
        return this.getDecimalNumber();
    }

}
