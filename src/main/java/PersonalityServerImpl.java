import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;

public class PersonalityServerImpl extends UnicastRemoteObject implements PersonalityServer {
    protected PersonalityServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String determinePersonality(int answer1, int answer2, int answer3) throws RemoteException {
        // Your personality determination logic based on answers
        // Example: return "Introvert" or "Extrovert" based on answers

        // Replace this with your actual logic
        if (answer1 + answer2 + answer3 > 6) {
            return "Extrovert";
        } else {
            return "Introvert";
        }
    }

    public static void main(String[] args) {
        try {
            PersonalityServer server = new PersonalityServerImpl();
            // Register the server object with RMI registry
            Naming.rebind("PersonalityServer", server);
            System.out.println("PersonalityServer bound in registry");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
