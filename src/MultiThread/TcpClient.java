package MultiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class TcpClient {

    public static void main(String[] args) {

        System.out.println("------------------------------");
        System.out.println(":: Cliente TCP Iniciado.... ::");
        System.out.println("------------------------------");

        int port = 4800;

        try {
            Socket socket = new Socket("localhost", port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            EscutaThread escuta = new EscutaThread(in);
            escuta.start();

            String entrada;

            while(true) {
                entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor: ", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                out.println(entrada);
                System.out.println("Cliente: "+entrada);
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}