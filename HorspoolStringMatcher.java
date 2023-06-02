package homework;

public class HorspoolStringMatcher{

    String pattern;
    int[] charTable;

    public HorspoolStringMatcher(String needle) {
        pattern = needle;
        charTable = new int[256];
        preProcess();
    }

    public void preProcess(){
        char p[] = pattern.toCharArray();
        for (int i = 0; i < 256; i++){
            charTable[i] = pattern.length();
        }
        for (int i = 0; i < pattern.length() - 1; i++){
            charTable[p[i]] = pattern.length() - 1 - i;
        }
    }

    public int getShift(char character){
        for (int i = 0; i < 256; i++){
            if (i == (int) character){
                return charTable[i];
            }
        }
        return -1;
    }

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
}
