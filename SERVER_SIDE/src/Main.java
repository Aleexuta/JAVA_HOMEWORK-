import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Server> threadList=new ArrayList<>();
        try(ServerSocket serverSocket=new ServerSocket(80)){
            while(true){
                Socket socket=serverSocket.accept();
                Server serverThread=new Server(socket,threadList);
                threadList.add(serverThread);
                serverThread.start();

            }
        } catch (IOException e) {
            System.out.println("error in main,server: "+e.getStackTrace());
        }
    }
}