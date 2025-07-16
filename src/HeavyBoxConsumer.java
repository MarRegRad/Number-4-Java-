import java.util.function.Consumer;

class HeavyBox {
    private int weight;

    HeavyBox(int weight) {
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }
}

public class HeavyBoxConsumer {
    public static void main(String[] args) {
        Consumer<HeavyBox> ship = box ->
                System.out.println("Отгрузили ящик с весом " + box.getWeight());

        Consumer<HeavyBox> send = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> combined = ship.andThen(send);

        HeavyBox box = new HeavyBox(25);
        combined.accept(box);
    }
}