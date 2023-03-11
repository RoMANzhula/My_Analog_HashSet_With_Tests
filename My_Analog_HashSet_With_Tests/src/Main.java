public class Main {
    public static void main(String[] args) {
        AnalogHashSet analogHashSet = new AnalogHashSet();
        analogHashSet.add("I'");
        analogHashSet.add("ll");
        analogHashSet.add("be ");
        analogHashSet.add("back!");
        analogHashSet.add("!");
        analogHashSet.add("3");
        analogHashSet.add("2");
        analogHashSet.add("1");
        analogHashSet.add("1");
        analogHashSet.add("29");

        analogHashSet.print();
        System.out.println("Size HashSet: " + analogHashSet.size());

        analogHashSet.remove("29");
        analogHashSet.print();
        System.out.println("Size HashSet: " + analogHashSet.size());

        System.out.println(analogHashSet.contains("back!"));

    }
}