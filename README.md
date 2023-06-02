# Horspool-String-Matcher
Java implementation of Horspool's algorithm for finding substrings in strings.  

## Functions  
### HorspoolStringMatcher()
HorspoolStringMatcher class initialization.  
*charTable* set to be length of extended ASCII table.  
Parameter *needle* is the word or character being searched for. Derived from the saying "Like finding a NEEDLE in a haystack"
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





