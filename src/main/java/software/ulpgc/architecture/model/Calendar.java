package software.ulpgc.architecture.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import static java.time.DayOfWeek.*;

public class Calendar {
    public Iterable<LocalDate> from(LocalDate date) {
        return () -> createIteratorFrom(date);
    }

    private Iterator<LocalDate> createIteratorFrom(LocalDate date) {
        return new Iterator<>() {
            private LocalDate currentDate = date.minusDays(1);
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                while (true) {
                    currentDate = currentDate.plusDays(1);
                    if (isWorkingDay(currentDate)) return currentDate;
                }
            }
        };
    }

    private static final Set<DayOfWeek> workingDaysOfWeek = Set.of(
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
    );
    private boolean isWorkingDay(LocalDate currentDate) {
        return workingDaysOfWeek.contains(currentDate.getDayOfWeek());
    }
}
