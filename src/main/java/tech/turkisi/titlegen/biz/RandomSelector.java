package tech.turkisi.titlegen.biz;

import java.util.List;
import java.util.Random;

class RandomSelector {

    private RandomSelector() {
    }

    private static final Random random = new Random();

    static <T> T pickOne(List<T> from) {

        final int index = random.nextInt(from.size());
        return from.get(index);
    }
}
