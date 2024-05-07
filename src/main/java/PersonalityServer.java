import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonalityServer extends Remote {
    String determinePersonality(int answer1, int answer2, int answer3) throws RemoteException;
}
