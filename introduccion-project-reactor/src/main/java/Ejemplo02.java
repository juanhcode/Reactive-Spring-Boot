import reactor.core.publisher.Mono;

public class Ejemplo02 {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Juan");
        mono.subscribe(
                data -> System.out.println(data), //OnNext
                err -> System.out.println(err), //OnError
                () -> System.out.println("Completado")//OnComplete
        );
    }
}
