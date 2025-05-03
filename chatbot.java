import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        
        System.out.println("Hello! I'm your assistant. How can I help you today?");
        
        while (true) {
            userInput = scanner.nextLine().toLowerCase();

            if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("Hi there! How can I assist you?");
            } 
            else if (userInput.contains("problem")) {
                System.out.println("I'm sorry to hear you're facing a problem. Can you describe it?");
            } 
            else if (userInput.contains("thank you")) {
                System.out.println("You're welcome! Is there anything else I can help you with?");
            } 
            else if (userInput.contains("bye") || userInput.contains("exit")) {
                System.out.println("Goodbye! Have a great day!");
                break; // Ends the conversation
            } 
            else {
                System.out.println("I'm not sure how to respond to that. Can you please clarify?");
            }
        }

        scanner.close();
    }
}
