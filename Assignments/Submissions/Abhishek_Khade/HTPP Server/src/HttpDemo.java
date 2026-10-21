import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpDemo {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 8080),0);

        server.createContext("/songs", exchange -> {
            String json = "[{\"tital\":\"Sunrise\", \"duration\": 180}]";

            byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

            exchange.sendResponseHeaders(200, bytes.length);

            try(var output = exchange.getResponseBody()) {
                output.write(bytes);
            }

        });
        server.start();

        System.out.println("Server started");

        }


    }

