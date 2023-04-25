import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Ejemplo01 {
    public static void main(String[] args) {

        List<Integer> elementosMono = new ArrayList<>();
        List<Integer> elementosFLux = new ArrayList<>();

        System.out.println("Hola");
        //Mono y Flex son publishers
        Mono<Integer> mono = Mono.just(1);

        Flux<Integer> flux = Flux.just(1,2,3,4,5,6,7,8,9,10);

        //Sucribirme a los publishers
        mono.subscribe(elementosMono::add);
        flux.subscribe(elementosFLux::add);

        //Visualizar Flujo de datos
        System.out.println(elementosMono);
        System.out.println(elementosFLux);

    }
}
