import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Ejemplo01 {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        Flux.fromArray(new String[]{"Tom","Melissa","Steve","Megan"})
                .map(String::toUpperCase)
                .subscribe(lista::add);


        lista.forEach(System.out::println);

    }
}
