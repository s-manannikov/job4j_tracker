package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book good = new Book("Good Code", 240);
        Book bad = new Book("Bad Code", 313);
        Book clean = new Book("Clean Code", 268);
        Book stupid = new Book("Stupid Code", 666);
        Book[] lib = new Book[4];
        lib[0] = good;
        lib[1] = bad;
        lib[2] = clean;
        lib[3] = stupid;
        for (Book b : lib) {
            System.out.println(b.getName() + ". " + b.getPages() + " pages.");
        }
        System.out.println(System.lineSeparator() + "Replace books:");
        Book temp = lib[0];
        lib[0] = lib[3];
        lib[3] = temp;
        for (Book b : lib) {
            System.out.println(b.getName() + ". " + b.getPages() + " pages.");
        }
        System.out.println(System.lineSeparator() + "Show only Clean Code:");
        for (Book b : lib) {
            if (b.equals(clean)) {
                System.out.println(b.getName() + ". " + b.getPages() + " pages.");
            }
        }
    }
}
