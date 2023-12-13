package objectTdd.christmas;

import java.time.LocalDate;

public class SalePolicy implements Policy{

    private final TimeLoader timeLoader;

    public SalePolicy(TimeLoader timeLoader) {
        this.timeLoader = timeLoader;
    }

    @Override
    public String sale() {
        LocalDate date = timeLoader.now();
        if (date.isEqual(LocalDate.of(2023, 12, 25))) {
            return "50%";
        }

        return "0%";
    }

}