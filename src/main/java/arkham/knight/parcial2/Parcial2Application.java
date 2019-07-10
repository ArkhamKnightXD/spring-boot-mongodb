package arkham.knight.parcial2;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.model.MovimientoInventario;
import arkham.knight.parcial2.model.OrdenCompra;
import arkham.knight.parcial2.model.Suplidor;
import arkham.knight.parcial2.services.ComponenteService;
import arkham.knight.parcial2.services.MovimientoInventarioService;
import arkham.knight.parcial2.services.OrdenCompraService;
import arkham.knight.parcial2.services.SuplidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Parcial2Application implements CommandLineRunner {

	@Autowired
	private SuplidorService suplidorService;

	@Autowired
	private MovimientoInventarioService movimientoInventarioService;

	@Autowired
	private ComponenteService componenteService;

	@Autowired
	private OrdenCompraService ordenCompraService;

	public static void main(String[] args) {
		SpringApplication.run(Parcial2Application.class, args);
	}


	//Trabaje estos datos aqui para hacer una prueba rapida sobre si funcionaba bien, aunque esto es una buena opcion si deseamos
	//Agregar un par de datos cuando se ejecuta el programa
//Si voy a trabajar en el main con mongo debo de hacerlo de esta forma ya que en la clase implemente commandlinerunner
	    @Override
		public void run(String... args) throws Exception{

			componenteService.deleteAllComponents();

			movimientoInventarioService.deleteAllMovimientos();

			suplidorService.deleteAllSuplidores();

			ordenCompraService.deleteAllOrden();




			Componente componente1 = new Componente("Mouse de pc","1234",100,"Caja");

			Componente componente2 = new Componente("Mouse de laptop","1244",110,"Caja");

			// Aqui guardo los componentes en la base de datos
			componenteService.createComponent(componente1);
			componenteService.createComponent(componente2);

			MovimientoInventario movimientoInventario = new MovimientoInventario("Entrada",12,"cajas","1425", componente1);

			MovimientoInventario movimientoInventario2 = new MovimientoInventario("Salida",10,"cajas","1426", componente2);

			movimientoInventarioService.createMovimientoInventario(movimientoInventario);

			movimientoInventarioService.createMovimientoInventario(movimientoInventario2);

			List<Componente> listaComponente = new ArrayList<>();

			listaComponente.add(componente1);
			listaComponente.add(componente2);

			//Especifico un date aqui ya que es la forma mas rapida de agregar un date a un objeto
			Date date = new Date(22-7-2019);

			Suplidor suplidor = new Suplidor("Maria Castro",date,500,listaComponente);

			suplidorService.createSuplidor(suplidor);



			OrdenCompra ordenCompra =new OrdenCompra(date,600,suplidor,listaComponente);

			ordenCompraService.createOrden(ordenCompra);

			//OrdenCompra ordenCompra =new OrdenCompra("1",);

			//En esta parte me encargare de imprimir los documentos por consola para comprobar que se creen y se inserten
			//de forma correcta, ademas de poder tener valores de prueba de una vez

			// Aqui listo todos los componentes
			System.out.println("Componentes encontrados:");
			System.out.println("-------------------------------");
			for (Componente componente : componenteService.listarComponentes()) {
				System.out.println(componente.toString());
			}
			System.out.println();


			//Aqui listo los movimientos
			System.out.println("Movimientos  encontrados:");
			System.out.println("-------------------------------");
			for (MovimientoInventario movimientoInventarioToLoop : movimientoInventarioService.listarMovimientoInventario()) {
				System.out.println(movimientoInventarioToLoop.toString());
			}
			System.out.println();


			// Aqui listo todos los suplidores
			System.out.println("Suplidores encontrados:");
			System.out.println("-------------------------------");
			for (Suplidor suplidorToLoop : suplidorService.listarSuplidores()) {
				System.out.println(suplidorToLoop.toString());
			}
			System.out.println();

			// Aqui listo todas las ordenes de compras
			System.out.println("Ordenes de compras encontradas:");
			System.out.println("-------------------------------");
			for (OrdenCompra ordenCompraToLoop : ordenCompraService.listarOrdenesDeCompra()) {
				System.out.println(ordenCompraToLoop.toString());
			}
			System.out.println();

		}





}
