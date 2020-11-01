package ru.job4j.lambda;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Function<Attachment, Boolean> func = new Function<>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, func);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Function<Attachment, Boolean> func = new Function<>() {
            @Override
            public Boolean apply(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, func);
    }

    private static List<Attachment> filter(
            List<Attachment> list,
            Function<Attachment, Boolean> func
    ) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (func.apply(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}