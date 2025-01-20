package software.ulpgc.architecture.control;

import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandFactory implements Iterable<String> {
    private final Map<String, CommandBuilder> builders;

    public CommandFactory() {
        this.builders = new HashMap<>();
    }

    public CommandFactory add(String name, CommandBuilder builder) {
        builders.put(name, builder);
        return this;
    }

    public Executing given(Request request, Response response) {
        return name -> builders.get(name).build(request, response);
    }

    @Override
    public Iterator<String> iterator() {
        return builders.keySet().iterator();
    }

    public interface Executing {
        Command get(String name);
    }
}
