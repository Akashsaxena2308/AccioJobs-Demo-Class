
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpDemo {
    public static void main(String[] args) throws java.io.IOException {

        //Creating a server
        //127.0.0.1 --> Local IP accesable from our computer
        //port
        //default backlog
        HttpServer server = HttpServer.create(
                new InetSocketAddress("127.0.0.1", 8081), 0);

        //Listening for /songs path
        //HTTP Exchange represents data object which stores data
        //during API call --> Request data and Response data
        server.createContext("/songs", exchange -> {

            if (!exchange.getRequestMethod().equals("GET")) {
                exchange.getResponseHeaders().set("Allow", "GET");
                exchange.sendResponseHeaders(405, -1); // No response body.
                exchange.close();
                return;
            }

            //Local response data
            String json = "[{\"title\":\"Sunrise\",\"durationMinutes\":3.5}]";
            //Encoding and setting format of our response
            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            //Sending response with status code and data format
            exchange.sendResponseHeaders(200, bytes.length);

            //Sending the response or output
            //Gets an output stream through which we can send body data to the client.
            // Writes the JSON bytes into that stream, sending the response body.
            try (var output = exchange.getResponseBody()) {
                output.write(bytes);
            }
        });


        //Starting our server
        server.start();
        System.out.println("Open http://127.0.0.1:8081/songs");
    }
}
