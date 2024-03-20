package ch.hslu.ad.sw03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        HashTree<Integer> tree = new HashTree<>();

        tree.add(2);
        tree.add(8);
        tree.add(12);
    }
}
