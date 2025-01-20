package software.ulpgc.architecture.control;

import software.ulpgc.architecture.model.Calendar;

import java.time.LocalDate;

public class WorkingDaysCommand implements Command {
    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public WorkingDaysCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = 0;
        for (LocalDate localDate : calendar.from(input.start())) {
            if (localDate.isAfter(input.end())) break;
            days++;
        }
        output.days(days);
    }

    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void days(int days);
    }
}
