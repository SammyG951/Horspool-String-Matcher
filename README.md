# Horspool-String-Matcher
Java implementation of Horspool's algorithm for finding substrings in strings.  

## Functions  
### HorspoolStringMatcher()
HorspoolStringMatcher class initialization.  
*charTable* set to be length of extended ASCII table.  
Parameter *needle* is the word or character being searched for. Derived from the saying "Like finding a NEEDLE in a haystack".  
```
    public HorspoolStringMatcher(String needle) {
        pattern = needle;
        charTable = new int[256];
        preProcess();
    }
```

## preProcess()  
Converts the string pattern into a character array.  
Sets each value in charTable to the length of pattern.  
Sets placeholder for each ascii character to the first appearance starting from but not including the last character (It's *Shift*).  
```
    public void preProcess(){
        char p[] = pattern.toCharArray();
        for (int i = 0; i < 256; i++){
            charTable[i] = pattern.length();
        }
        for (int i = 0; i < pattern.length() - 1; i++){
            charTable[p[i]] = pattern.length() - 1 - i;
        }
    }
```

## getShift()  
Iterates through charTable to find the shift of the character.  
Parameter *character* is the ASCII character value being searched for.  
Returns shift of the character.  
```
    public int getShift(char character){
        for (int i = 0; i < 256; i++){
            if (i == (int) character){
                return charTable[i];
            }
        }
        return -1;
    }
```

## match()  
Searches for index of pattern in the given string. Skip refers to the number of characters that can safely be skipped when evaluating for the pattern at a given position in the string.  
Paramter *haystack* is the string you want to search for the pattern in. Derived from the saying "Like finding a needle in a HAYSTACK".  
Returns the index of the first character in the pattern.  
```
public int match(String haystack){
        char h[] = haystack.toCharArray();
        char p[] = pattern.toCharArray();
        int patternLength = pattern.length();
        int skip;

        for (int i = patternLength - 1; i < haystack.length();){
            skip = 0;
            while((skip < patternLength) && (p[patternLength - 1 - skip] == h[i - skip])){
                skip ++;
            }
            if (skip == patternLength){
                return i - patternLength + 1;
            }
            else {
                i += charTable[h[i]];
            }
        }
        return -1;
    }
```



