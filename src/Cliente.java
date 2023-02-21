import java.io.*;
import java.net.*;

public class Cliente {

    public static void main(String[] args) throws IOException {

        String serverHostname = "localhost";
        int port = 4444;

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket(serverHostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("No se puede conectar a " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.print("Ingrese el número de líneas: ");
        int numLines = Integer.parseInt(stdIn.readLine());
        out.println(numLines);

        for (int i = 0; i < numLines; i++) {
            System.out.print("Ingrese la línea " + (i + 1) + ": ");
            userInput = stdIn.readLine();
            out.println(userInput);
        }

        for (int i = 0; i < numLines; i++) {
            String response = in.readLine();
            System.out.println("Suma de verificación para la línea " + (i + 1) + ": " + response);
        }

        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}

