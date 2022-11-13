import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Server extends Thread{
    private Socket socket;
    private ArrayList<Server> threadList;
    private PrintWriter output;
    private static ArrayList<Human> humanList=new ArrayList<>();
    public Server(Socket socket, ArrayList<Server> threadList) {
        this.socket = socket;
        this.threadList = threadList;
    }
    @Override
    public void run(){
        try {
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output=new PrintWriter(socket.getOutputStream(),true);

            while(true){
                String outputString=input.readLine();
                if(outputString.equals("exit")){
                    break;
                }
                String[] data=outputString.split("\\s+");
                if(data[0].equals("Student")) {
                    Human h=new Student(data[1],data[2],data[3],Integer.parseInt(data[4]),Integer.parseInt(data[5]));
                    humanList.add(h);
                } else {
                    Human h=new Profesor(data[1],data[2],data[3],Integer.parseInt(data[4]),data[5]);
                    humanList.add(h);
                }
                Collections.sort(humanList);
                System.out.println("\n\n");
                for(Human h: humanList){
                    System.out.println(h);
                }
            }
        } catch(Exception e){
            System.out.println("Error: "+e.getStackTrace());
        }
    }
}