# Horspool-String-Matcher
Java implementation of Horspool's algorithm for finding substrings in strings.  

## Functions  
### HorspoolStringMatcher()
HorspoolStringMatcher class initialization.  
*charTable* set to be length of extended ASCII table
Parameter *needle* is the word or character being searched for. Derived from the saying "Like finding a NEEDLE in a haystack"
```
    public HorspoolStringMatcher(String needle) {
        pattern = needle;
        charTable = new int[256];
        preProcess();
    }
```
