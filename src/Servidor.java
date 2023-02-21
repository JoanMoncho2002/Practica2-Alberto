import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            int puerto = 4444;
            serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor de suma de verificación en ejecución en el puerto " + puerto);
        } catch (IOException e) {
            System.err.println("No se puede escuchar en el puerto 4444.");
            System.exit(-1);
        }

        while (listening) {
            new ServidorHilo(serverSocket.accept()).start();
        }

        serverSocket.close();
    }
}
