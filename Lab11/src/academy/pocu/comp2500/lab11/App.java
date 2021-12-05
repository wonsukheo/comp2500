package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        StringBuilder sb = new StringBuilder();
        WarehouseType[] warehouseList = WarehouseType.values();

        // 1. print.out WarehouseList
        sb.append("WAREHOUSE: Choose your warehouse!");
        sb.append(System.lineSeparator());

        int i = 1;
        for (WarehouseType wType : warehouseList) {
            sb.append(String.format("%d. %s", i++, wType.toString()));
            sb.append(System.lineSeparator());
        }

        out.println(sb);

        // 2. user Input
        String userInput = new String();

        try {
            userInput = in.readLine();
        } catch (IOException e) {
            run(in, out, err);
        }

        if (userInput.equals("exit")) {
            return;
        }

        int userInputInt = Integer.parseInt(userInput) - 1;

        if (userInputInt < 1 || userInputInt >= warehouseList.length) {
            this.run(in, out, err);
        }

        // 3. check user access for department's Wallet
        SafeWallet wallet;

        try {
            wallet = new SafeWallet(new User());
        } catch (IllegalAccessException e) {
            err.print("AUTH_ERROR");

            return;
        }

        chooseProduct(in, out, err, wallet, userInputInt);
    }

    private void chooseProduct(BufferedReader in, PrintStream out, PrintStream err, SafeWallet wallet, int wareHouse) {
        // 4. print.out Wallet balance
        out.println(String.format("BALANCE: <%d>", wallet.getAmount()));

        // 5. print.out ProductList
        StringBuilder sb = new StringBuilder();
        Warehouse warehouse = new Warehouse(WarehouseType.values()[wareHouse]);

        sb.append("PRODUCT_LIST: Choose your product!");
        sb.append(System.lineSeparator());

        int i = 1;
        for (Product product : warehouse.getProducts()) {
            sb.append(String.format("%d. %-16s%4d", i++, product.getName(), product.getPrice()));
            sb.append(System.lineSeparator());
        }

        out.println(sb);

        // 6. user Input
        String userInput = new String();

        try {
            userInput = in.readLine();
        } catch (IOException e) {
            run(in, out, err);
        }

        if (userInput.equals("exit")) {
            return;
        }

        int userInputInt = Integer.parseInt(userInput) - 1;

        if (userInputInt < 1 || userInputInt >= warehouse.getProducts().size()) {
            this.chooseProduct(in, out, err, wallet, userInputInt);
        }

        // 7. purchase product
        Product product = warehouse.getProducts().get(userInputInt);

        if (wallet.getAmount() >= product.getPrice()) {
            wallet.withdraw(product.getPrice());

            try {
                warehouse.removeProduct(product.getId());
            } catch (ProductNotFoundException e) {
                wallet.deposit(product.getPrice());
            }
        }

        this.chooseProduct(in, out, err, wallet, userInputInt);
    }
}
