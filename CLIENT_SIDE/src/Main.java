import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try(Socket socket=new Socket("localhost",80)){
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output=new PrintWriter(socket.getOutputStream(),true);
            Scanner scanner=new Scanner(System.in);
            String userInput,response,clientName="empty";
            Client clientThread=new Client(socket);
            clientThread.start();

            do{
                    System.out.println("Enter your name: ");
                    userInput=scanner.nextLine();
                    output.println(userInput);
                    if(userInput.equals("exit")) {
                        break;
                    }
            } while (!userInput.equals("exit"));
        }catch (Exception e){
            System.out.println("Exception main, client "+e.getStackTrace());
        }
    }
}