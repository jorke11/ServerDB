/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverdb;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorke11
 */
public class ServerDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String clientSentence, response = "";
        Response res = new Response();
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        Triangle obj = new Triangle();

        Query sql = new Query();
        String[] param = new String[2];
        String menu = "";

        while (true) {
            String respon = "";
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

//            ObjectOutputStream outToClientObj = new ObjectOutputStream(connectionSocket.getOutputStream());
//            ObjectInputStream inFromClientObj = new ObjectInputStream(connectionSocket.getInputStream());
            clientSentence = inFromClient.readLine();
            menu = clientSentence.substring(0, 2);
            clientSentence = clientSentence.substring(3, clientSentence.length());
            param = clientSentence.split(",");

            if (menu.indexOf("@1") != -1) {
                clientSentence = String.valueOf(sql.setAccount(param[0], param[1], param[2]));
                if (clientSentence.equals("5")) {
                    System.out.println("Received de cliente: " + clientSentence);
                    capitalizedSentence = clientSentence + "\n";
                    outToClient.writeBytes(capitalizedSentence);
                }
            } else if (menu.indexOf("@2") != -1) {
            } else if (menu.indexOf("@3") != -1) {
            } else if (menu.indexOf("@4") != -1) {
            } else if (menu.indexOf("@5") != -1) {
            } else if (menu.indexOf("@6") != -1) {
            } else {
                respon = sql.getClients();
                outToClient.writeBytes(respon + "\n");
            }

        }
    }

}
