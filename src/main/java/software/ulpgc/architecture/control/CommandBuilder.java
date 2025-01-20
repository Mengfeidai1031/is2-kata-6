package software.ulpgc.architecture.control;

import spark.Request;
import spark.Response;

public interface CommandBuilder {
    Command build(Request request, Response response);
}
