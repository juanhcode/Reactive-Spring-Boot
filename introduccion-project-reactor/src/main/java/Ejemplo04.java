import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo04 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Luciano");
        nombres.add("Julian");

        Flux<String> flux = Flux.fromArray(new String[]{"data1","data2"});
        //flux.subscribe(System.out::println);

        flux.doOnNext(System.out::println).subscribe();
    }
}
