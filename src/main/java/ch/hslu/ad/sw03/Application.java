package ch.hslu.ad.sw03;

public class Application {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyTree<>();

        tree.add(2);
        System.out.println(tree);

        tree.add(8);
        // tree.add(9);
        // tree.add(10);
        // tree.add(13);
        // tree.add(11);
        // tree.add(7);
        // tree.add(4);
        // tree.add(15);
        // tree.add(1);
        System.out.println(tree);

        System.out.println(tree.contains(9));

        // tree.getRoot();
    }
}
