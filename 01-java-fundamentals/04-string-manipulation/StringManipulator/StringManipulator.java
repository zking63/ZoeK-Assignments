public class StringManipulator {
    public String trimAndConcat(String string1, String string2) {
        return string1.trim().concat(string2.trim());
    }
    public Integer getIndexOrNull(String string3, char char1) {
        if (string3.indexOf(char1) > -1) {
            return string3.indexOf(char1);
        }
        else {
            return null;
        }
    }
    public Integer getIndexOrNull(String string4, String string5) {
        if (string4.indexOf(string5) > -1) {
            return string4.indexOf(string5);
        }
        else {
            return null;
        }
    }
    String concatSubstring(String string6, int ind1, int ind2, String string7) {
        if (ind1 >= 0 && ind2 <= string6.length()){
            String subString = string6.substring(ind1, ind2);
            String bigString = subString.concat(string7);
            return bigString;
        }
        else {
            return "One index is out of bounds.";
        }
    }
}