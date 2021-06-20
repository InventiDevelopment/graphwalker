package inventi;

import lombok.SneakyThrows;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import org.graphwalker.websocket.WebSocketServer;

public class GraphWalkerRunner {

    @SneakyThrows
    public static void main(String[] args) {
        Executor executor = new TestExecutor(
                BaseModelImpl.class,
                PostModelImpl.class
        );
        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());
        server.start();

        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
        server.stop();
    }
}
