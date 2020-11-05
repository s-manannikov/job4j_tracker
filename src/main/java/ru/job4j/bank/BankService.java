package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream().
                filter(u -> u.getPassport().equals(passport)).
                findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return users.get(user).stream().
                    filter(u -> u.getRequisite().equals(requisite)).
                findFirst().orElse(null);
    }

        public boolean transferMoney(String srcPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
            boolean rsl = false;
            Account srcAcc = findByRequisite(srcPassport, srcRequisite);
            Account destAcc = findByRequisite(destPassport, destRequisite);
            if (srcAcc != null && destAcc != null) {
                if (srcAcc.getBalance() >= amount) {
                    destAcc.setBalance(destAcc.getBalance() + amount);
                    srcAcc.setBalance(srcAcc.getBalance() - amount);
                    rsl = true;
                }
            }
            return rsl;
        }
}



















