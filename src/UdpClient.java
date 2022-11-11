/*
---------------------------------------------------------
:: SOCKETS JAVA
:: Prof. Heraldo Gonçalves Lima Junior
:: Curso: Sistemas para a Internet
:: Disciplina: Sistemas Distribuídos
:: Contato: heraldo.junior@ifsertao-pe.edu.br
---------------------------------------------------------
*/

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JOptionPane;

public class UdpClient {

    public static void main(String[] args) {

        try {

            DatagramSocket clientSocket = new DatagramSocket();

            byte[] sendData = new byte[1024];

            InetAddress IpAddress = InetAddress.getByName("localhost");

            int port = 2300;

            while(true) {
                String sentence = JOptionPane.showInputDialog("Digite:");

                sendData = sentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(), IpAddress, port);

                clientSocket.send(sendPacket);

                if(sentence.equalsIgnoreCase("sair")) {
                    break;
                }

            }
            //fecho a conexão
            clientSocket.close();

        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
            e.printStackTrace();
        }
    }

}