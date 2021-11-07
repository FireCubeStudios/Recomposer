import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {
    /// Seperates a string into vowel/consonant groups then reverses the characters in
    /// each group and joins them together with a space before each capital letter
    /// Example: DeosItOffednaeYuoYh [D, eo, s, I, t, O, ff, e, dn, aeYuoY, h]
    /// = [D, oe, s, I, t, O, ff, e, nd, YouYea, h] = Does It Offend You Yeah
    /// Pre-conditions: Must be a string to recompose
    /// Post conditions: Return a recomposed string
    /// @param str - first int to add
    /// @return str with all vowel/consonant groups swapped and split by the capital case
    public static String recompose(String str)
    {
      String recomposedString = "";
      String group = "";
      boolean wasVowel = isVowel(str.charAt(0)); //Sets character type for first character
      for(int i = 0; i < str.length(); i++)
      {
        if(isVowel(str.charAt(i)) == wasVowel) //Checks if character type is same as previous character
        {
          group = group + str.charAt(i);
          wasVowel = isVowel(str.charAt(i));
        }
        else
        {
          recomposedString = recomposedString + reverseString(group);
          group = "";
          group = group + str.charAt(i);
          wasVowel = isVowel(str.charAt(i));
        }
      }
      recomposedString = recomposedString + reverseString(group); //This adds the final group which is not covered in the while loop
      return splitCase(recomposedString);
    }

    /// Reverses all the characters in a string
    /// Pre-conditions: Must be a string
    /// Post conditions: Must return a reversed string
    /// @param str - The string to reverse
    /// @return reversed str
    public static String reverseString(String str)
    {
      String reversedString = "";
      for (int i = 0; i < str.length(); i++)
      {
          reversedString = str.charAt(i) + reversedString;
      }
      return reversedString;
    }

    /// Adds a space before capital cases in a string
    /// Pre-conditions: Must be a string
    /// Post conditions: Must return a string with a space before all capital cases
    /// @param str - The string to add spaces before capital cases
    /// @return str with spaces before each capital case
    public static String splitCase(String str)
    {
      return Pattern.compile("(.)([A-Z])", Pattern.MULTILINE).matcher(str).replaceAll("$1 $2");
    }

    /// Checks if a character is a vowel
    /// Pre-conditions: Must be a string
    /// Post conditions: Must return true if it is a vowel
    /// @param c - The character which will be checked
    /// @return a new boolean with true if vowel or false if consonant
    public static boolean isVowel(char c)
    {
      return Pattern.compile("^[aeiouy]$", Pattern.CASE_INSENSITIVE).matcher(Character.toString(c)).find();
    }
}
