import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {

    public static void main(String argv[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int escolher1;


        int sair = 1;
        String sentence;
        String coisinha;
        String modifiedSentence;


        while(sair != 0)
        {
            System.out.println("Digite 1 para converter texto para binário e 2 para converter binário para texto");
            System.out.println();
            escolher1 = sc.nextInt();

            if(escolher1 == 1)
            {
                System.out.println("CLIENTE INICIADO, DIGITE UM TEXTO PARA CONVERTER PARA BINARIO: ");
                BufferedReader inFromUser1 = new BufferedReader(new InputStreamReader(System.in));

                Socket clientSocket = new Socket("localhost", 6789);

                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //saida para o servidor, manda oque escrevou para o servidor
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


                sentence = inFromUser1.readLine();
                coisinha = String.valueOf(escolher1);

                if(sair != 0)
                {
                    outToServer.writeBytes(sentence + '\n');//saida do cliente para o servidor, que é a entrada do servidor
                    outToServer.writeBytes(coisinha + '\n');
                    modifiedSentence = inFromServer.readLine();//retorno do servidor (palavra em maiusculo)
                    System.out.println("FROM SERVER: " + modifiedSentence);//printe da palavra em maiusculo
                }
                clientSocket.close();

            }
            else if(escolher1 == 2)
            {
                System.out.println("CLIENTE INICIADO, DIGITE UM TEXTO PARA CONVERTER PARA BINARIO: ");
                BufferedReader inFromUser1 = new BufferedReader(new InputStreamReader(System.in));

                Socket clientSocket = new Socket("localhost", 6789);

                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //saida para o servidor, manda oque escrevou para o servidor
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


                sentence = inFromUser1.readLine();
                coisinha = String.valueOf(escolher1);

                if(sair != 0)
                {
                    outToServer.writeBytes(sentence + '\n');//saida do cliente para o servidor, que é a entrada do servidor
                    outToServer.writeBytes(coisinha + '\n');
                    modifiedSentence = inFromServer.readLine();//retorno do servidor (palavra em maiusculo)
                    System.out.println("FROM SERVER: " + modifiedSentence);//printe da palavra em maiusculo
                }
                clientSocket.close();
            }
            System.out.println("Se deseja sair digite 0 se não digite 1");
            sair = sc.nextInt();
        }
    }
}
