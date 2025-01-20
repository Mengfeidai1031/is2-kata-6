package software.ulpgc.apps.windows.adapters;

import software.ulpgc.architecture.control.WorkingDaysCommand;
import spark.Request;
import spark.Response;

import java.time.LocalDate;

public class CalculateWorkingDaysAdapter {
    public static WorkingDaysCommand.Input adapt(Request request) {
        return new WorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(request.queryParams("from"));
            }

            @Override
            public LocalDate end() {
                return LocalDate.parse(request.queryParams("to"));
            }
        };
    }

    public static WorkingDaysCommand.Output adapt(Response response) {
        return days -> response.body(String.valueOf(days));
    }
}
