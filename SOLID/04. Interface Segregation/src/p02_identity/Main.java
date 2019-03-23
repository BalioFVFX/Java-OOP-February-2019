package p02_identity;

import p02_identity.interfaces.User;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager(new Repository());

        User user = accountManager.register("Pesho", "Peshev");

        System.out.println(user.getEmail());

    }
}
