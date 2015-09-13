import java.util.Scanner;

/**
 * Main class used to print to the console.
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("Welcome to the encryption/decryption program!\n\nPlease enter S for a "
                + "substitution cipher or V for a Vigenère cipher: ");
        @SuppressWarnings("resource")
        Scanner userIn = new Scanner(System.in);
        String choice = userIn.nextLine();
        
        
        if (choice.equals("S") || choice.equals("s")) {
            substitution();
        }
        else if (choice.equals("V") || choice.equals("v")) {
            vigenere();
        }
        else {
            System.out.print("\nYou have inputted an incorrect choice. Please try running this again.\n");
        }
    }
    
    /**
     * Creates an interactive console program that encrypts or decrypts a message 
     * using the substitution cipher and a code word.
     */
    public static void substitution() {
        System.out.print("\nPlease enter E for encryption or D for decryption: ");
        Scanner userIn = new Scanner(System.in);
        String choice = userIn.nextLine();
        
        
        if (choice.equals("E") || choice.equals("e")) {
            System.out.print("Please enter the code word or key: ");
            String code = userIn.nextLine();
            System.out.print("Please enter the message to be encrypted (press enter twice): ");
            String message = getMessage(userIn);
            Encrypt e = new Encrypt(code, message);
            printMessage("\nYour encrypted message: " + e.encryptWithSubstitution() + "\n");
        }
        else if (choice.equals("D") || choice.equals("d")) {
            System.out.print("\nPlease enter the code word or key: ");
            String code = userIn.nextLine();
            System.out.print("\nPlease enter the message to be decrypted (press enter twice): ");
            String message = getMessage(userIn);
            Decrypt d = new Decrypt(code, message);
            printMessage("\nYour decrypted message: " + d.decryptWithSubstitution() + "\n");
        }
        else {
            System.out.print("\nYou have inputted an incorrect choice. Please try running this again.\n");
        }
    }
    
    /**
     * Creates an interactive console program that encrypts or decrypts a message 
     * using the Vigenère cipher and a code word.
     */
    public static void vigenere() {
        System.out.print("\nPlease enter E for encryption or D for decryption: ");
        Scanner userIn = new Scanner(System.in);
        String choice = userIn.nextLine();
        
        
        if (choice.equals("E") || choice.equals("e")) {
            System.out.print("Please enter the code word or key: ");
            String code = userIn.nextLine();
            System.out.print("Please enter the message to be encrypted (press enter twice): ");
            String message = getMessage(userIn);
            Encrypt e = new Encrypt(code, message);
            printMessage("\nYour encrypted message: " + e.encryptWithVigenere() + "\n");
        }
        else if (choice.equals("D") || choice.equals("d")) {
            System.out.print("\nPlease enter the code word or key: ");
            String code = userIn.nextLine();
            System.out.print("\nPlease enter the message to be decrypted (press enter twice): ");
            String message = getMessage(userIn);
            Decrypt d = new Decrypt(code, message);
            printMessage("\nYour decrypted message: " + d.decryptWithVigenere() + "\n");
        }
        else {
            System.out.print("\nYou have inputted an incorrect choice. Please try running this again.\n");
        }
    }

    private static String getMessage(Scanner userIn) {
        String message = "";
        String next = userIn.nextLine();
        while (next.length() > 0) {
            message += next;
            next = userIn.nextLine();
        }
        return message;
    }
    
    /**
     * Prints something to the console and adds line breaks every 100 characters.
     * @param message What to print to console.
     */
    private static void printMessage(String message) {
        String substring = message;
        String result = "";
        int lineLength = 100;
        
        while (substring.length() > lineLength) {
            result += substring.substring(0, lineLength) + "\n";
            substring = substring.substring(lineLength);
        }
        
        result += substring;
        System.out.print(result);
    }

}
