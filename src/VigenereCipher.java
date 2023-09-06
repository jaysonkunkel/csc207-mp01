import java.io.PrintWriter;

public class VigenereCipher {
  
  public static int base = 97;

  public static void main (String[] args) throws Exception {

    // pen that writes to stdout
    PrintWriter stdOutPen = new PrintWriter(System.out, true);

    //pen that writes to stderr
    PrintWriter stdErrPen = new PrintWriter(System.err, true);

    // if there are not exactly 3 arguments, the input is invalid
    if(args.length != 3) {
      stdErrPen.println("Incorrect number of parameters");
      System.exit(2);
    } //if

    // if first parameter is neither "encode" nor "decode", the input is invalid       
    if (!(args[0].equals("encode") || args[0].equals("decode"))) {      
      stdErrPen.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    } // if

    // if key is empty, print plaintext as is
    if (args[2].isEmpty()){
      stdOutPen.println(args[1]);
      System.exit(1);
    } // if

    // if either the plaintext or key contains uppercase letters, the input is invalid
    if(!args[1].toLowerCase().equals(args[1]) || !args[2].toLowerCase().equals(args[2])){
      stdErrPen.println("Plaintext string and key must be lowercase");
      System.exit(1);
    } // if

    // if first parameter is "encode", encrypt string; otherwise, decrypt string
    if(args[0].equals("encode")){
      stdOutPen.println(encryptString(args[1], args[2]));
    } // if 
    else {
      stdOutPen.println(decryptString(args[1], args[2]));
    } // if
  
  } // main

  /**
   * Returns the result of encoding char ch by a given key.
   * 
   * @param ch - Lowercase char
   * @param key - Lowercase char
   * @return - Encoded character
   */
  public static char encryptChar (char ch, char key) {
      
    // "re-base" at 0 by subtracting value of 'a'
    int charValue = (int) ch - base;
    int keyValue = (int) key - base;
    // shift char and wrap around to front if needed
    char result = (char) ((charValue + keyValue) % 26);
    // return encrypted character
    return (char) (result + base);
      
  } // encryptChar (char, char)

  /**
   * Returns the result of decoding char ch by a given key.
   * 
   * @param ch - Lowercase char
   * @param key - Lowercase char
   * @return - Decoded character
   */
  public static char decryptChar (char ch, char key) {
    
    // "re-base" at 0 by subtracting value of 'a'
    int charValue = (int) ch - base;
    int keyValue = (int) key - base;
    // shift char and wrap around to end if needed
    char result = (char) ((charValue - keyValue) % 26 + 26);
    // return decrypted character
    return (char) (result % 26 + base);
      
  } // decryptChar (char, char)
  
 /**
     * Returns the result of encoding a String with a given keyword.
     * 
     * @param word - Lowercase string
     * @param key - Lowercase string
     * @return - Encoded string
     */      
    public static String encryptString (String word, String key) {

      char[] wordArr = word.toCharArray();
      char[] keyArr = key.toCharArray();
      char[] result = new char[word.length()];

      // for each letter of original word, store its shifted value in new string
      for(int i = 0; i < word.length(); i++){
        result[i] = encryptChar(wordArr[i], keyArr[i % key.length()]);
      } // for

      return new String(result);

  } // encryptString (String, String)

 /**
     * Returns the result of decoding a String with a given keyword.
     * 
     * @param word - Lowercase string
     * @param key - Lowercase string
     * @return - Encoded string
     */      
    public static String decryptString (String word, String key) {

      char[] wordArr = word.toCharArray();
      char[] keyArr = key.toCharArray();
      char[] result = new char[word.length()];

      // for each letter of original word, store its shifted value in new string
      for(int i = 0; i < word.length(); i++){
        result[i] = decryptChar(wordArr[i], keyArr[i % key.length()]);
      } // for

      return new String(result);

  } // decryptString (String, String)
  
} // class VigenereCipher
