package software.ulpgc.apps.windows;

import software.ulpgc.architecture.control.CommandFactory;
import spark.Route;
import spark.Spark;

public class WebService {
    private final CommandFactory factory;

    public WebService(CommandFactory factory) {
        this.factory = factory;
    }

    public void init() {
        Spark.port(8080);
        for (String command : factory)
            Spark.get("/" + command, execute(command));
    }

    private Route execute(String command) {
        return (req, res) -> {
            factory.given(req, res).get(command).execute();
            return res.body();
        };
    }
}
