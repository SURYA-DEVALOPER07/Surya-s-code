import java.util.*;

public class AIChatbot {

    private static Map<String, String> knowledgeBase = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeKnowledgeBase();

        System.out.println("🤖 AI Chatbot: Hello! I’m your AI Assistant. Type 'bye' to exit.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine().toLowerCase().trim();

            if (userInput.equals("bye")) {
                System.out.println("🤖 Chatbot: Goodbye! Have a great day!");
                break;
            }

            String response = getResponse(userInput);
            System.out.println("🤖 Chatbot: " + response);
        }

        sc.close();
    }

    // Step 1: Define some default question-answer pairs
    private static void initializeKnowledgeBase() {
        knowledgeBase.put("hello", "Hi there! How can I help you today?");
        knowledgeBase.put("hi", "Hello! Nice to meet you.");
        knowledgeBase.put("how are you", "I'm doing great, thank you! How about you?");
        knowledgeBase.put("your name", "I'm an AI chatbot created in Java!");
        knowledgeBase.put("what is ai", "AI stands for Artificial Intelligence — the simulation of human intelligence by machines.");
        knowledgeBase.put("who created you", "I was created by a Java developer who loves AI!");
        knowledgeBase.put("what can you do", "I can chat with you, answer questions, and help you learn AI concepts!");
        knowledgeBase.put("time", "The current time is " + new Date().toString());
        knowledgeBase.put("date", "Today’s date is " + new Date().toString());
        knowledgeBase.put("thank you", "You're welcome! 😊");
    }

    // Step 2: NLP-like logic to find best-matching response
    private static String getResponse(String userInput) {
        // Direct match first
        for (String key : knowledgeBase.keySet()) {
            if (userInput.contains(key)) {
                return knowledgeBase.get(key);
            }
        }

        // Simple NLP-based processing (keyword-based)
        if (userInput.contains("weather")) {
            return "I can’t check the weather yet, but it looks like a nice day! ☀️";
        } else if (userInput.contains("help")) {
            return "Sure! You can ask me about AI, Java, or general questions.";
        } else if (userInput.contains("java")) {
            return "Java is a powerful, object-oriented programming language used for web, desktop, and AI applications.";
        } else if (userInput.contains("bye")) {
            return "Goodbye! Come back anytime!";
        }

        // If unknown, fallback response
        return "Hmm... I’m not sure about that yet. Can you rephrase your question?";
    }
}
