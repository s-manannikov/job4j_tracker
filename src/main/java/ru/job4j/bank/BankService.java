package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = Optional.ofNullable(findByPassport(passport));
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
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
        Optional<User> user = Optional.ofNullable(findByPassport(passport));
        if (user.isPresent()) {
            return users.get(user.get()).stream().
                    filter(u -> u.getRequisite().equals(requisite)).
                    findFirst().orElse(null);
        }
        return null;
    }

        public boolean transferMoney(String srcPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
            boolean rsl = false;
            Optional<Account> srcAcc = Optional.ofNullable(findByRequisite(srcPassport, srcRequisite));
            Optional<Account> destAcc = Optional.ofNullable(findByRequisite(destPassport, destRequisite));
            if (srcAcc.isPresent() && destAcc.isPresent()) {
                if (srcAcc.get().getBalance() >= amount) {
                    destAcc.get().setBalance(destAcc.get().getBalance() + amount);
                    srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
                    rsl = true;
                }
            }
            return rsl;
        }
}



















