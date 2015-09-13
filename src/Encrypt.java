import java.util.HashMap;

/**
 * Encrypts a message using a code word.
 */
public class Encrypt {
    private String code;
    private String message;
    private Utils utils;
    private HashMap<Character, Integer> hm;
    
    Encrypt(String code, String message) {
        code = code.toLowerCase();
        this.message = message;
        this.utils = new Utils(code);
        this.code = utils.code;
        
        this.hm = new HashMap<>();
        int index = 0;
        for (Character letter : utils.alphabet) {
            this.hm.put(letter, index++);
        }
    }
    
    /**
     * Encrypts a message using a code word with a substitution cipher.
     * @return The encrypted message.
     */
    public String encryptWithSubstitution() {
        String result = "";
        char[] alph = utils.alphabet;
        char[] encrAlph = utils.encryptedAlphabet;
        int index;
        String substitute;
        boolean capitalized;
        
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
            else {
                capitalized = Character.isUpperCase(c);
                c = Character.toLowerCase(c);
                index = utils.getIndex(alph, c);
                char charSub = encrAlph[index];
                if (capitalized) {
                    charSub = Character.toUpperCase(charSub);
                }
                substitute = String.valueOf(charSub);
                result = result.concat(substitute);
            }
        }
        
        return result;
    }
    
    /**
     * Encrypts a message using a code word with a Vigenère cipher.
     * @return The encrypted message.
     */
    public String encryptWithVigenere() {
        String result = "";
        char[] codeArray = code.toCharArray();
        int codeSize = code.length();
        int codeIndex = 0;
        char codeLetter;
        char[] alph = utils.alphabet;
        int index;
        String substitute;
        boolean capitalized;
        
        for (char c : message.toCharArray()) {
            if (!Character.isLetter(c)) {
                result = result.concat(String.valueOf(c));
            }
            else {
                capitalized = Character.isUpperCase(c);
                c = Character.toLowerCase(c);
                codeLetter = codeArray[codeIndex++ % codeSize];
                index = (hm.get(codeLetter) + hm.get(c)) % 26;
                char charSub = alph[index];
                if (capitalized) {
                    charSub = Character.toUpperCase(charSub);
                }
                substitute = String.valueOf(charSub);
                result = result.concat(substitute);
            }
        }
        
        return result;
    }
}
