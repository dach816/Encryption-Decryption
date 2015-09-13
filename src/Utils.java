import java.util.ArrayList;

/**
 * Utilities class.
 */
public class Utils {
    public char[] alphabet;
    public char[] encryptedAlphabet;
    public String code;

    public Utils(String code) {
        this.alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        this.encryptedAlphabet = encryptedAlphabet(code);
    }
    
    public char[] encryptedAlphabet(String code) {
        ArrayList<Character> alreadySeen = new ArrayList<>();
        char[] encrypted = new char[26];
        int index = 0;
        String newCode = "";
        
        for(char c : code.toCharArray()) {
            if (Character.isLetter(c)) {
                encrypted[index++] = c;
                alreadySeen.add(c);
                newCode += c;
            }
        }
        
        this.code = newCode;
        
        int codeLength = newCode.length();
        int newIndex = getIndex(alphabet, newCode.toCharArray()[codeLength - 1]);

        if (newIndex < 0 || newIndex >= 26) {
            throw new RuntimeException("error in encrypting alphabet, " + newIndex);
        }
        
        for (int i = 0; i < 26; i++) {
            char c = alphabet[newIndex];
            if (!alreadySeen.contains(c) && index < 26) {
                encrypted[index++] = c;
                alreadySeen.add(c);
            }
            newIndex = (newIndex + 1) % 26;
        }
        
        return encrypted;
    }
    
    public int getIndex(char[] letters, char c) {
        int index = 0;
        
        for (char ch : letters) {
            if (ch == c) {
                return index;
            }
            index++;
        }
        
        return -1;
    }
}
