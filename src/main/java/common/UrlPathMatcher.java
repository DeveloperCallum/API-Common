package common;

import common.exception.InvalidUrlException;

public class UrlPathMatcher {
    /**
     * Matches 2 URLs.
     *
     * @param base     The comparator URL.
     * @param matching The URL for testing.
     */
    public static boolean matchUrl(String base, String matching) {
        String[] baseParts = convertURL(base).split("/");
        String[] matchParts = convertURL(matching).split("/");

        int baseIndex = 0;
        int matchIndex = 0;

        for (int x = 0; x < matchParts.length; x++) {
            if (baseParts.length - 1 < baseIndex & matchParts.length - 1 < matchIndex) {
                //TODO Throw Exception
                throw new RuntimeException("");
            }

            if (baseParts[baseIndex].equals("*")) {
                ++baseIndex;
                continue;
            }

            if (matchParts[matchIndex].equals("*")) {
                ++matchIndex;
                continue;
            }

            if (!baseParts[baseIndex].equals(matchParts[matchIndex])) {
                ++matchIndex;
                continue;
            }

            break;
        }

        return match(baseParts, matchParts, baseIndex, matchIndex);
    }

    public static String convertURL(String urlRaw) {
        String url = urlRaw;

        if (urlRaw.contains("?")){
            url = urlRaw.split("\\?")[0];
        }


        StringBuilder convertedURl = new StringBuilder();

        boolean isParameter = false;
        char[] charArr = url.toCharArray();

        for (int x = 0; x < url.length(); x++) {
            char currentChar = charArr[x];

            switch (currentChar) {
                case '{':
                    if (isParameter) {
                        throw new InvalidUrlException("URL is not valid");
                    }

                    isParameter = true;
                    break;

                case '}':
                    if (!isParameter) {
                        throw new InvalidUrlException("URL is not valid");
                    }

                    isParameter = false;
                    convertedURl.append("*");
                    break;

                default:
                    if (!isParameter) {
                        convertedURl.append(currentChar);
                    }
                    break;
            }
        }

        return convertedURl.toString();
    }

    private static boolean match(String[] basePart, String[] currentPart, int baseIndex, int matchIndex) {
        if (basePart.length <= baseIndex & currentPart.length <= matchIndex) {
            return true;
        }

        if (basePart[baseIndex].equals("*")) {
            return match(basePart, currentPart, ++baseIndex, ++matchIndex);
        }

        if (basePart[baseIndex].equals(currentPart[matchIndex])) {
            return match(basePart, currentPart, ++baseIndex, ++matchIndex);
        } else {
            return false;
        }
    }
}
