import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo03 {
    public static void main(String[] args) {
        List<Double> lista = new ArrayList<>();
        lista.add(1D);
        lista.add(2D);
        lista.add(3D);
        lista.add(4D);

        Mono<Double> mono = Mono.fromSupplier(() -> {
            int index = Math.toIntExact(Math.round(Math.random() * 3));
            System.out.println("i " + index);
            return lista.get(index);
        });


        mono.subscribe(
                data -> System.out.println(data), //OnNext
                err -> System.out.println(err), //OnError
                () -> System.out.println("Completado")//OnComplete
        );
    }
}
