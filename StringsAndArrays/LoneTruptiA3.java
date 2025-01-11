import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// References:
// Map : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
// Regex: https://www.w3schools.com/java/java_regex.asp
// Array: https://www.w3schools.com/java/ref_string_tochararray.asp
public class LoneTruptiA3 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Taking inputs from the user
        System.out.print("Anagram String 1: ");
        String string1 = userInput.nextLine();

        System.out.print("Anagram String 2: ");
        String string2 = userInput.nextLine();

        System.out.print("Substring Extraction String 3: ");
        String string3 = userInput.nextLine();

        System.out.print("Starting index substring: ");
        int startIndex = userInput.nextInt();

        System.out.print("Ending index substring: ");
        int endIndex = userInput.nextInt();
        System.out.println();

        // Check if the two strings are anagrams and print the result
        if (isAnagram(string1, string2)) {
            System.out.println(string1 + " and " + string2 + " are anagrams of each other");
        } else {
            System.out.println(string1 + " and " + string2 + " are not anagrams of each other");
        }

        System.out.println();
        extractSubstring(string3,startIndex,endIndex);
        System.out.println();
        System.out.println("Program Completed");
        System.out.println();
        System.out.println();
    }
    public static boolean isAnagram(String str1, String str2) {

        //From input strings ignoring spaces, punctuations and changing into lowercase

        str1 = str1.replaceAll("\\s+", "").replaceAll("\\p{Punct}", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").replaceAll("\\p{Punct}", "").toLowerCase();

        boolean isAnagram = true;

        //Checking for String length, if lengths are not equal, they cant be anagram

        if (str1.length() != str2.length()) {
            return false;
        }

        //Convert both strings to character array so that we can iterate over each letter.

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        //Create a map storing frequency of each character in the first string as key and maintaining count as value

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< charArray1.length; i++){
            char key = charArray1[i];
            Integer value = map.get(key);
            if(value == null){
                map.put(key, 1);
            }else{
                map.put(key,value +1);
            }
        }

        //Iterate over the characters of the second string and decrement the corresponding count in the map.

        for(int i = 0; i< charArray2.length; i++){
            char key = charArray2[i];
            int temp;
            if(map.containsKey(key)){
                temp = map.get(key);
                temp = temp - 1;
                map.put(key,temp);
            }
        }

        //If all counts in the dictionary are zero, the strings are anagrams.
        for (Integer i : map.values()){
            if(i != 0){
                isAnagram = false;
            }
        }
        return isAnagram;

    }


    // Public method to extract a substring
    public static void extractSubstring(String str, int start, int end){
        //System.out.println("String: "+str +" Start index: "+start +" End index: "+end);
        if (start < 0 || end >= str.length() || start > end) {
            System.out.println("Usage: java Enter a valid index within the given string length.");
            return;
        }
        //Iterate over character array
        char[] charArray = str.toCharArray();
        char[] subString = new char[end - start +1];

        for(int i= start; i<= end; i++){
           subString[i-start] =  charArray[i];
        }
            System.out.println("The extracted substring is: "+new String(subString));
            return;
        }
    }
