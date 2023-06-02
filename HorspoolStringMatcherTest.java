package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorspoolStringMatcherTest {

    @Test
    void computesCorrectShiftTable() {
        HorspoolStringMatcher matcher = new HorspoolStringMatcher("mississippi");
        assertEquals(10, matcher.getShift('m'));
        assertEquals(3, matcher.getShift('i'));
        assertEquals(4, matcher.getShift('s'));
        assertEquals(1, matcher.getShift('p'));
        assertEquals(11, matcher.getShift('a'));
    }

    @Test
    void findsEarlyMatch() {
        HorspoolStringMatcher matcher = new HorspoolStringMatcher("How");
        assertEquals(0, matcher.match("How much wood would a woodchuck chuck if a woodchuck could chuck wood?"));
    }

    @Test
    void findsMiddleMatch() {
        HorspoolStringMatcher matcher = new HorspoolStringMatcher("woodchuck");
        assertEquals(22, matcher.match("How much wood would a woodchuck chuck if a woodchuck could chuck wood?"));
    }

    @Test
    void findsLateMatch() {
        HorspoolStringMatcher matcher = new HorspoolStringMatcher("wood?");
        assertEquals(65, matcher.match("How much wood would a woodchuck chuck if a woodchuck could chuck wood?"));
    }

    @Test
    void detectsNonmatch() {
        HorspoolStringMatcher matcher = new HorspoolStringMatcher("plastic");
        assertEquals(-1, matcher.match("How much wood would a woodchuck chuck if a woodchuck could chuck wood?"));
    }

}