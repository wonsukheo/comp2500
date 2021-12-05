package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class App {
    private int userInputInteger(BufferedReader in, PrintStream out, PrintStream err, int max) {
        String userInput = new String();

        try {
            userInput = in.readLine();
        } catch (IOException e) {
            // what should i do when it occurs?
            run(in, out, err);
        }

        if (userInput.equals("exit")) {
            return -1;
        }

        int userInputInt = 0;

        try {
            userInputInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            userInputInteger(in, out, err, max);
        }

        if (userInputInt < 1 || userInputInt > max) {
            userInputInteger(in, out ,err, max);
        }

        return userInputInt - 1;
    }

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
        int userInputResult = userInputInteger(in, out ,err, warehouseList.length);

        if (userInputResult == -1) {
            return;
        }

        // 3. check user access for department's Wallet
        SafeWallet wallet;

        try {
            wallet = new SafeWallet(new User());
        } catch (IllegalAccessException e) {
            err.print("AUTH_ERROR");

            return;
        }

        chooseProduct(in, out, err, wallet, userInputResult);
    }
    private void chooseWarehouseMsg(PrintStream out) {
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
        int userInputResult = userInputInteger(in, out ,err, warehouse.getProducts().size());

        if (userInputResult == -1) {
            return;
        }

        // 7. purchase product
        Product product = warehouse.getProducts().get(userInputResult);

        if (wallet.getAmount() >= product.getPrice()) {
            wallet.withdraw(product.getPrice());

            try {
                warehouse.removeProduct(product.getId());
            } catch (ProductNotFoundException e) {
                wallet.deposit(product.getPrice());
            }
        }

        this.chooseProduct(in, out, err, wallet, userInputResult);
    }
}
