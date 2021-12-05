package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;

public class SafeWallet extends Wallet {
    public SafeWallet(final User user) throws IllegalAccessException {
        super(user);
    }

    @Override
    public boolean deposit(final int amount) throws OverflowException {
        if (amount <= 0) {
            return false;
        }

        if (amount > Integer.MAX_VALUE - super.getAmount()) {
            throw new OverflowException("wallet deposit overflowed!");
        } else {
            super.deposit(amount);
        }

        return true;
    }
}
