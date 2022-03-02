import java.util.Scanner;

public class EnigmaMachine {
  Scanner inText = new Scanner(System.in);

  public static void main(String[] args) {
    new EnigmaMachine().enigmaMachine();
  }

  void enigmaMachine() {
    displayWelcomeMessage();
    menuEncryptionOrDecryption();
    menuCipherTypes();
  }

  void displayWelcomeMessage() {
    System.out.println("Welcome to the Enigma Machine!");
  }

  void menuEncryptionOrDecryption() {
    System.out.println("Choose whether to:");
    System.out.println("1. Encrypt");
    System.out.println("2. Decrypt");

    String encryptionOrDecryption = inText.nextLine();
    switch (encryptionOrDecryption) {
      case "1", "Encrypt", "encrypt" -> System.out.println("You have chosen to encrypt.");
      case "2", "Decrypt", "decrypt" -> System.out.println("You have chosen to decrypt.");
      default -> {
        System.out.println("You haven't chosen one of the two options, try again.");
        menuEncryptionOrDecryption();
      }
    }
  }

  void menuCipherTypes() {
    System.out.println("Choose a type of cipher:");
    System.out.println("1. Ceasar");
    System.out.println("2. Vigenère");
    //System.out.println("3. Number");
    //System.out.println("4. Substitution");

    String encryptionType = inText.nextLine();
    switch (encryptionType) {
      case "1", "Ceasar", "ceasar" -> {
        System.out.println("You have chosen Ceasar cipher");
        cipherCeasar();
      }
      case "2", "Vigenère", "vigenère", "Vigenere", "vigenere" -> {
        System.out.println("You have choosen Vigenère cipher");
        cipherVigenere();
      }
      //case "3", "Number", "number" -> System.out.println("You have chosen Number cipher");
      //case "4", "Substitution", "substitution" -> System.out.println("You have choosen Substitution cipher");
      default -> {
        System.out.println("You haven't chosen a type of cipher, try again.");
        menuCipherTypes();
      }
    }
  }

  void cipherCeasar() {
    String plaintext = new EnigmaMachine().userInputPlaintext();
    displayCiphertext(encryptionCeasar(plaintext, userInputKey()),plaintext);
  }

  void cipherVigenere() {
    String plaintext = new EnigmaMachine().userInputPlaintext();
    displayCiphertext(encryptionVigenere(plaintext, userInputKey()),plaintext);
  }

  String userInputPlaintext() {
    System.out.print("\nEnter plaintext: ");
    return inText.nextLine();
  }

  String userInputKey() {
    System.out.print("\nEnter key: ");

    return inText.nextLine();
  }

  String encryptionCeasar(String plaintext, String key) {
    return plaintext + key;
  }

  String encryptionVigenere(String plaintext, String key) {
    return plaintext + key;
  }

  void displayCiphertext(String encryption, String plaintext) {
    System.out.println("Ciphertext: "+encryption);
    System.out.println("Plaintext: "+plaintext);
  }
}
