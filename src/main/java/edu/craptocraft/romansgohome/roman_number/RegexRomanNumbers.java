package edu.craptocraft.romansgohome.roman_number;

import java.util.ArrayList;
import java.util.List;

public class RegexRomanNumbers {
    
    private List<String> regexExpressions = new ArrayList<>();

    public RegexRomanNumbers(List<String> regexExpressions) {
        this.regexExpressions = regexExpressions;
    }

    private void addRegex(String regex) {
        this.regexExpressions.add(regex);
    }

    private void initRegexList() {
        this.addRegex("");
    }

    public String getRegex(int index) {
        return this.regexExpressions.get(index);
    }

}
