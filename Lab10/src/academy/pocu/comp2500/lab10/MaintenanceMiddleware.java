package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;

public class MaintenanceMiddleware implements IRequestHandler {
    private IRequestHandler next;
    private OffsetDateTime maintenanceStartTime;

    public MaintenanceMiddleware(IRequestHandler next, OffsetDateTime maintenanceStartTime) {
        this.next = next;
        this.maintenanceStartTime = maintenanceStartTime;
    }


    @Override
    public ResultBase handle(Request request) {
        if (OffsetDateTime.now().isBefore(maintenanceStartTime.plusHours(1))) {
            return new ServiceUnavailableResult(maintenanceStartTime, maintenanceStartTime.plusHours(1));
        }

        return next.handle(request);
    }
}
