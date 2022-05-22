package junit;

import common.UrlPathMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrlTest {

    @Test
    void matchWildcard() {
        Assertions.assertTrue(UrlPathMatcher.matchUrl("a/*/a", "a/b/a"));
    }

    @Test
    void urlWithParameters(){
        Assertions.assertTrue(UrlPathMatcher.matchUrl("user/{user}/id", "user/bob/id?banana=a&banana1=b"));
    }

    @Test
    void wildcardStart() {
        System.out.println();
        Assertions.assertTrue(UrlPathMatcher.matchUrl("*/a/b", "banana/index/a/b"));
    }

    @Test
    void doubleWildcards() {
        System.out.println();
        Assertions.assertTrue(UrlPathMatcher.matchUrl("*/a/b", "banana/index/a/b"));
    }

    @Test
    void wrongURL() {
        Assertions.assertFalse(UrlPathMatcher.matchUrl("a/a/a", "a/b/a"));
    }

    @Test
    void wrongEndCharacter() {
        Assertions.assertFalse(UrlPathMatcher.matchUrl("a/a/a", "a/a/b"));
    }

    @Test
    void urlWithVariable() {
        Assertions.assertTrue(UrlPathMatcher.matchUrl("a/{letter}/a", "a/b/a"));
    }
}
