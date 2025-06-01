interface DollProduct {
    public void push();
}

class BlueDoll implements DollProduct {
    @Override
    public void push() {
        System.out.println("블루인형");
    }
}

class RedDoll implements DollProduct {
    @Override
    public void push() {
        System.out.println("레드인형");
    }
}

class SimpleFactory {
    public DollProduct makeDoll(String name) {
        if (name.equals("blue")) return new BlueDoll();
        if (name.equals("red")) return new RedDoll();
        return null;
    }
}

public class Main {
    public static void main(String[] args) {

        SimpleFactory factory = new SimpleFactory();
        DollProduct mine1 = factory.makeDoll("blue");
        mine1.push();
    }
}
