import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class TestUsuarios {

    private static final Logger log = LoggerFactory.getLogger(TestUsuarios.class);

    public static void main(String[] args) {
        Flux<String> nombres = Flux.just("Juan Hoyos","Cristian Ruiz","Mateo Silva","Sebastian Cifuentes","Gustavo Luna");
        Flux<User> users = nombres.map( nombre -> new User(nombre.split("")[0].toUpperCase(),nombre.split("")[1].toUpperCase()))
                .filter(user ->  user.getApellido().equalsIgnoreCase("Hoyos"))
                .doOnNext(user -> {
                    if(user == null){
                        throw  new RuntimeException("Los nombres no pueden estar vacios");
                    }
                    System.out.println(user.getNombre() + user.getApellido());
                })
                .map(usuario ->{
                    String nombre = usuario.getNombre().toLowerCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });
        users.subscribe( e -> TestUsuarios.log.info(e.toString()), err -> TestUsuarios.log.error(err.getMessage(),
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Se ha finalizado la ejecución");
                    }
                })
        );
    }
}
