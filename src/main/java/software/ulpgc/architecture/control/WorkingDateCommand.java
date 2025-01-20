package software.ulpgc.architecture.control;

import software.ulpgc.architecture.model.Calendar;

import java.time.LocalDate;

public class WorkingDateCommand implements Command {

    private final Input input;
    private final Calendar calendar;
    private final Output output;

    public WorkingDateCommand(Input input, Calendar calendar, Output output) {
        this.input = input;
        this.calendar = calendar;
        this.output = output;
    }

    @Override
    public void execute() {
        int days = input.days();
        for (LocalDate localDate : calendar.from(input.start())) {
            if (days == 0) {
                output.endDate(localDate);
                break;
            }
            days--;
        }
    }

    public interface Input {
        LocalDate start();
        int days();
    }

    public interface Output {
        void endDate(LocalDate date);
    }
}