package software.ulpgc.apps.windows;

import software.ulpgc.apps.windows.adapters.CalculateWorkingDateAdapter;
import software.ulpgc.apps.windows.adapters.CalculateWorkingDaysAdapter;
import software.ulpgc.architecture.control.CommandFactory;
import software.ulpgc.architecture.control.WorkingDateCommand;
import software.ulpgc.architecture.control.WorkingDaysCommand;
import software.ulpgc.architecture.model.Calendar;
import spark.Request;
import spark.Response;

public class Main {
    public static void main(String[] args) {
        new WebService(commandFactory()).init();
    }

    private static CommandFactory commandFactory() {
        return new CommandFactory().add("working-date", Main::createWorkingDateCommand)
                .add("working-days", Main::createWorkingDaysCommand);
    }

    private static WorkingDaysCommand createWorkingDaysCommand(Request request, Response response) {
        return new WorkingDaysCommand(
                CalculateWorkingDaysAdapter.adapt(request), new Calendar(),
                CalculateWorkingDaysAdapter.adapt(response)
        );
    }

    private static WorkingDateCommand createWorkingDateCommand(Request request, Response response) {
        return new WorkingDateCommand(
                CalculateWorkingDateAdapter.adapt(request), new Calendar(),
                CalculateWorkingDateAdapter.adapt(response)
        );
    }
}