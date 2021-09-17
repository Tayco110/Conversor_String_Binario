import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {

    public static void main(String argv[]) throws Exception {

        Scanner input = new Scanner(System.in);
        String sentence, modifiedSentence, tarefa;
        int escolha;

        do {
            do{
                System.out.println("DIGITE O VALOR QUE CORRESPONDE À TAREFA QUE DESEJA REALIZAR:");
                System.out.println("    (1) CONVERTER UMA STRING PARA BINÁRIO");
                System.out.println("    (2) CONVERTER UM BINÁRIO PARA STRING");
                System.out.println("    (3) SAIR DA APLICAÇÃO");
                System.out.print("ENTRADA: ");
                escolha = input.nextInt();
            }while(escolha < 1 || escolha > 3 );

            if(escolha == 1)
            {
                System.out.println("DIGITE UMA STRING PARA CONVERTER PARA BINÁRIO: ");

                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                Socket clientSocket = new Socket("localhost", 6789);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                sentence = inFromUser.readLine();
                tarefa = String.valueOf(escolha);

                outToServer.writeBytes(sentence + '\n');
                outToServer.writeBytes(tarefa + '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println("SUA STRING EM BINÁRIO:\n" + modifiedSentence);
                System.out.println();

                clientSocket.close();
            }
            else if(escolha == 2)
            {
                System.out.println("DIGITE UM BINÁRIO PARA CONVERTER PARA STRING: ");

                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                Socket clientSocket = new Socket("localhost", 6789);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                sentence = inFromUser.readLine();
                tarefa = String.valueOf(escolha);

                outToServer.writeBytes(sentence + '\n');
                outToServer.writeBytes(tarefa + '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println("SEU BINÁRIO EM STRING:\n" + modifiedSentence);
                System.out.println();

                clientSocket.close();
            }
        }while (escolha != 3);
    }
}
