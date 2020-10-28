package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account acc : list) {
            if (!acc.equals(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
            List<Account> list = users.get(user);
            for (Account acc : list) {
                if (acc.getRequisite().equals(requisite)) {
                    rsl = acc;
                    break;
                }
            }
            return rsl;
        }

        public boolean transferMoney (String srcPassport, String srcRequisite,
                String destPassport, String destRequisite,double amount) {
            boolean rsl = false;
            Account srcAcc = findByRequisite(srcPassport, srcRequisite);
            Account destAcc = findByRequisite(destPassport, destRequisite);
            if (srcAcc.getBalance() > amount && srcAcc != null && destAcc != null) {
                destAcc.setBalance(destAcc.getBalance() + amount);
                srcAcc.setBalance(srcAcc.getBalance() - amount);
                rsl = true;
            }
            return rsl;
        }
}