package academy.pocu.comp2500.lab9;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;


public class BuyOneGetOneFree implements IEvent {
    private HashMap<UUID, Boolean> sku = new HashMap<>();

    public BuyOneGetOneFree(HashSet<UUID> sku) {
        for (UUID uuid : sku) {
            this.sku.put(uuid, false);
        }
    }

    //arg is not an array
    public int getTotalPrice(Collection<Book> books) {
        int sum = 0;

        loop:
        for (Book book : books) {
            for (UUID uuid : this.sku.keySet()) {
                if (uuid == book.getSku()) {

                    if (this.sku.get(uuid) == false) {
                        this.sku.replace(uuid, true);
                        sum += book.getPrice();
                        continue loop;
                    } else {
                        this.sku.replace(uuid, false);
                        continue loop;
                    }

                }
            }

            sum += book.getPrice();
        }

        return sum;
    }
}
