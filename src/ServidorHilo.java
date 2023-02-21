import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServidorHilo extends Thread{

    private Socket socket;

    public ServidorHilo(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int numLines = Integer.parseInt(in.readLine());

            for (int i = 0; i < numLines; i++) {
                String line = in.readLine();
                int sum = 0;
                for (char c : line.toCharArray()) {
                    sum += (int) c;
                }
                out.println(sum);
            }

            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
