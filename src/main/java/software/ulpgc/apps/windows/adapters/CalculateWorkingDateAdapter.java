package software.ulpgc.apps.windows.adapters;

import software.ulpgc.architecture.control.WorkingDateCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalculateWorkingDateAdapter {

    public static WorkingDateCommand.Input adapt(Request request) {
        return new WorkingDateCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public int days() {
                return Integer.parseInt(request.queryParams("days"));
            }
        };
    }

    public static WorkingDateCommand.Output adapt(Response response) {
        return localdate -> response.body(localdate.toString());
    }
}