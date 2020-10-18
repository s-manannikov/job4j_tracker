package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User i : users) {
            if (i.getUsername().equals(login)) {
                rsl = i;
                break;
            }
        }
            if (rsl.equals(null)) {
                throw new UserNotFoundException("This user was not found!");
            }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if ((!user.isValid()) || (user.getUsername().length() < 3)) {
            throw new UserInvalidException("This user is not valid!");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ie) {
            ie.printStackTrace();
        } catch (UserNotFoundException nf) {
            nf.printStackTrace();
        }
    }
}