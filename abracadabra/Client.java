import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // или "127.0.0.1"
        int port = 8080;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Подключение к серверу " + host + ":" + port);

            // Получаем поток для отправки данных серверу
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Отправляем одну строку
            String message = "Привет, сервер!";
            out.println(message);
            System.out.println("Отправлено сообщение: " + message);

            // Соединение закрывается автоматически
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}