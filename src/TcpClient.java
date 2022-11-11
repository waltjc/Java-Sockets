/*
---------------------------------------------------------
:: SOCKETS JAVA
:: Prof. Heraldo Gonçalves Lima Junior
:: Curso: Sistemas para a Internet
:: Disciplina: Sistemas Distribuídos
:: Contato: heraldo.junior@ifsertao-pe.edu.br
---------------------------------------------------------
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class TcpClient {

    public static void main(String[] args) {

        int port = 1451;

        try {

            Socket socket = new Socket("localhost", port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String entradaServidor;

            String entradaUsuario = JOptionPane.showInputDialog("Digite: ");

            while(!entradaUsuario.equalsIgnoreCase("sair")) {
                out.println(entradaUsuario);

                entradaServidor = in.readLine();

                entradaUsuario = JOptionPane.showInputDialog("Msg. do Servidor: "+entradaServidor+"\nDigite:");
            }
            out.close();
            in.close();
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}