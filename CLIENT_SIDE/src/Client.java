import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{
    private Socket socket;
    private BufferedReader input;

    public Client(Socket socket) throws IOException{
        this.socket = socket;
        this.input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run(){
        try{
            while(true){
                String response=input.readLine();
                System.out.println(response);
            }
        } catch (IOException e){
            e.getStackTrace();
        } finally {
            try{
                input.close();
            } catch ( Exception e){
                e.getStackTrace();
            }
        }
    }
}