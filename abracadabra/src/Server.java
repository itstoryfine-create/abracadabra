import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080; // любой свободный порт, например 8080

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание подключения на порту " + port + "...");

            // Принимаем соединение от клиента
            Socket clientSocket = serverSocket.accept();
            System.out.println("Подключение установлено!");

            // Получаем поток для чтения данных от клиента
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Читаем строку, отправленную клиентом
            String message = in.readLine();

            // Выводим сообщение и порт клиента
            System.out.println("Порт клиента: " + clientSocket.getPort());
            System.out.println("Сообщение от клиента: " + message);

            // Закрываем соединение (try-with-resources закроет автоматически)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
