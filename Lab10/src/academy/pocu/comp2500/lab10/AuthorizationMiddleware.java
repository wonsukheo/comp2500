package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private HashSet<User> authorizedUsers;
    private IRequestHandler next;

    public AuthorizationMiddleware(IRequestHandler next, HashSet<User> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
        this.next = next;
    }

    @Override
    public ResultBase handle(Request request) {
        if (!authorizedUsers.contains(request.getUser())) {
            return new UnauthorizedResult();
        }

        return next.handle(request);
    }
}
