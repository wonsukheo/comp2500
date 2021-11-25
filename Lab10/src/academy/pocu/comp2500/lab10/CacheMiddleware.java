package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;
import java.util.HashSet;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler next;
    private int cacheExpiryCount;
    private HashMap<Request, CachedResult> cachedResults = new HashMap<>();

    public CacheMiddleware(IRequestHandler next, int cacheExpiryCount) {
        this.next = next;
        this.cacheExpiryCount = cacheExpiryCount;
    }

    @Override
    public ResultBase handle(Request request) {
        if (cachedResults.containsKey(request)) {
            CachedResult cachedResult = cachedResults.get(request);

            if (cachedResult.getExpiryCount() == 0) {
                return next.handle(request);
            }

            cachedResult.setExpiryCount(cachedResult.getExpiryCount() - 1);

            return cachedResult;
        }

        ResultBase result = next.handle(request);

        if (result.getCode() == ResultCode.OK) {
            cachedResults.put(request, new CachedResult(cacheExpiryCount));
        }

        return result;
    }
}
