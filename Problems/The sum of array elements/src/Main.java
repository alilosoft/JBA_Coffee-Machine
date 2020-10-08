import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt(); // skip size
        int sum = 0;
        while (scanner.hasNext()){
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}

class Test {
    public static void main(String args[]) {
        Person person = new Person("R. Johnson");
        System.out.println(Person.getNextId()); // (1)
    }
}

class Person {
    private static long nextId = 1;
    long id;
    String name;

    public Person(String name) {
        name = name; // (2)
        this.id = nextId;
        this.nextId++; // (3)
    }

    public static long getNextId() { // (4)
        return nextId;
    }
}