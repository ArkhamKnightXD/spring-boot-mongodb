package arkham.knight.parcial2;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.services.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Parcial2Application implements CommandLineRunner {

	@Autowired
	private ComponenteService componenteService;

	public static void main(String[] args) {
		SpringApplication.run(Parcial2Application.class, args);
	}


	//Trabaje estos datos aqui para hacer una prueba rapida sobre si funcionaba bien, aunque esto es una buena opcion si deseamos
	//Agregar un par de datos cuando se ejecuta el programa
//Si voy a trabajar en el main con mongo debo de hacerlo de esta forma ya que en la clase implemente commandlinerunner
	    @Override
		public void run(String... args) throws Exception{

			componenteService.deleteAllComponents();


			Componente componente1 = new Componente("Mouse de pc","1234",150,"Caja");

			Componente componente2 = new Componente("Mouse de laptop","1244",170,"Caja");

			// Aqui guardo los componentes en la base de datos
			componenteService.createComponent(componente1);
			componenteService.createComponent(componente2);


			// Aqui listo todos los componentes
			System.out.println("Componentes encontrados:");
			System.out.println("-------------------------------");
			for (Componente componente : componenteService.listarComponentes()) {
				System.out.println(componente.toString());
			}
			System.out.println();

		}





}
