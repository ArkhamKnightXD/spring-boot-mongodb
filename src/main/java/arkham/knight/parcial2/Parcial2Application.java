package arkham.knight.parcial2;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.repository.ComponenteRepository;
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



	    @Override
		public void run(String... args) throws Exception{

		//componenteService.deleteAll();

			Componente componente1 = new Componente(1,"Mouse de pc","1234",150,"Caja");

			Componente componente2 = new Componente(2,"Mouse de laptop","1244",170,"Caja");
			// save a couple of customers
			componenteService.createComponent(componente1);
			componenteService.createComponent(componente2);

			// fetch all customers
			System.out.println("Componentes encontrados:");
			System.out.println("-------------------------------");
			for (Componente componente : componenteService.listarComponentes()) {
				System.out.println(componente.toString());
			}
			System.out.println();

		}





}
