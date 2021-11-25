package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase result;

    public ResultValidator(ResultBase result) {
        this.result = result;
    }

    public boolean isValid(ResultCode resultCode) {
        if (result.getCode().equals(resultCode)) {
            switch (resultCode) {
                case OK:
                    return result instanceof OkResult;
                case NOT_MODIFIED:
                    return result instanceof CachedResult;
                case SERVICE_UNAVAILABLE:
                    return result instanceof ServiceUnavailableResult;
                case UNAUTHORIZED:
                    return result instanceof UnauthorizedResult;
                case NOT_FOUND:
                    return result instanceof NotFoundResult;
                default:
                    return false;
            }
        }

        return false;
    }
}
