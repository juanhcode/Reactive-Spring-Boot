import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;

import java.util.Arrays;
import java.util.List;

public class Ejemplo05 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        try {
            numbers.add(32);
        }catch (Exception e){
            System.out.println("Error agregando numero");
        }

        ParallelFlux<Integer> parallelNumbers = Flux.fromIterable(numbers)
                .parallel();

        parallelNumbers
                .map(number -> number * 2)
                .filter(number -> number > 5)
                .subscribe(System.out::println);
    }
}
