import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonalityTest extends Remote {
    String submitAnswers(int answer1, int answer2, int answer3) throws RemoteException;
}
