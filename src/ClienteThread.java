import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread implements Runnable {

    private Socket connectionSocket;
    public ClienteThread(Socket s){
        this.connectionSocket = s;
    }

    public void run(){

        String clientSentence, escolha;
        BufferedReader inFromClient;
        DataOutputStream outToClient;

        try {
            inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            escolha = inFromClient.readLine();

            if(escolha.equals("1")){
                byte[] bytes = clientSentence.getBytes();
                StringBuilder binario = new StringBuilder();
                for (byte b1 : bytes) {
                    int val = b1;
                    for (int i = 0; i < 8; i++)
                    {
                        binario.append((val & 128) == 0 ? 0 : 1);
                        val <<= 1;
                    }
                    binario.append(' ');
                }
                outToClient.writeBytes(binario.toString() + '\n');
            }
            else if(escolha.equals("2")){
                String retorno = "";
                String[] values = clientSentence.split(" ");
                for(int i=0 ; i<values.length ; i++){
                    char c = (char)Integer.parseInt(values[i], 2);
                    retorno += c;
                }
                outToClient.writeBytes(retorno + '\n');
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

