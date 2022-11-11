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

public class UdpServer {

    public static void main(String[] args) {

        System.out.println("-----------------------");
        System.out.println(":: SERVIDOR INICIADO ::");
        System.out.println("-----------------------");

        int port = 2300;

        try {
            DatagramSocket serverSocket = new DatagramSocket(port);

            while(true) {

                //vetor para armazenar as informações
                byte[] receiveData = new byte[1024];
                //receber as informações e jogar no vetor
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                //escuta a porta 1450 e oq vier dela será armazenado no receivePacket
                serverSocket.receive(receivePacket);

                //converto p/ string
                String sentence = new String(receivePacket.getData());


                if(sentence.substring(0,4).equalsIgnoreCase("sair")) {
                    break;
                }
                InetAddress IpAddress = receivePacket.getAddress();
                System.out.println(IpAddress.getHostAddress()+" - Mensagem: "+sentence.trim());
            }
            //fecha a conexão
            serverSocket.close();
            System.out.println("\n-------------------");
            System.out.println("Servidor finalidado.");

        } catch (Exception e) {
            System.out.println("ERRO: "+e.getMessage());
            e.printStackTrace();
        }

    }

}