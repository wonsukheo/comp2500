package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashSet;

public class CachedResult extends ResultBase {
    private int expiryCount;

    public CachedResult(int expiryCount) {
        super(ResultCode.NOT_MODIFIED);

        this.expiryCount = expiryCount;
    }

    public int getExpiryCount() {
        return expiryCount;
    }

    public void setExpiryCount(int expiryCount) {
        this.expiryCount = expiryCount;
    }
}
