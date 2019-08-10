package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.model.OrdenCompra;
import arkham.knight.parcial2.model.Suplidor;
import arkham.knight.parcial2.services.ComponenteService;
import arkham.knight.parcial2.services.OrdenCompraService;
import arkham.knight.parcial2.services.SuplidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orden-compra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @Autowired
    private SuplidorService suplidorService;

    @Autowired
    private ComponenteService componenteService;

    @RequestMapping("/")
    public String index(Model model ){

        model.addAttribute("ordenes", ordenCompraService.listarOrdenesDeCompra());
        return "freemarker/ordenes";
    }

    @RequestMapping("/creacion")
    public String creacionOrdenCompra(Model model){


        model.addAttribute("suplidores", suplidorService.listarSuplidores());
        model.addAttribute("componentes", componenteService.listarComponentes());
        model.addAttribute("titulo", "Pc Parts CXA");


        return "/freemarker/crearOrdenCompra";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearOrdenCompra(@RequestParam(name = "fechaOrden") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaOrden, @RequestParam(name = "idSuplidor", required = false) String idSuplidor,  @RequestParam(name = "idComponentes", required = false)List<String> idComponentes){

       Suplidor suplidor = suplidorService.findSuplidorById(idSuplidor);

       List<Componente> listaComponentes = new ArrayList<>();

        float montoTotal =0;

       //Forma de encontrar multiples objetos y agregarlo a una lista
        for (String idComponentesToLoop: idComponentes
             )
        {

            Componente componenteDeOrdenCompra = componenteService.findComponenteById(idComponentesToLoop);

            componenteService.createComponent(componenteDeOrdenCompra);

            listaComponentes.add(componenteDeOrdenCompra);

            //Aqui voy sumando la multiplicacion de la cantidad y precio de los componentes agregados a la orden


              montoTotal += componenteDeOrdenCompra.getPrecioUnidadCompra()*componenteDeOrdenCompra.getStock();

        }

        //Le pondre valor de prueba de 50k
        OrdenCompra ordenCompraToCreate = new OrdenCompra(fechaOrden,suplidor,listaComponentes);

        ordenCompraToCreate.setMontoTotal(montoTotal);
        ordenCompraService.createOrdenCompra(ordenCompraToCreate);


        return "redirect:/orden-compra/";
    }

    @RequestMapping("/mostrar")
    public String mostrar(Model model, @RequestParam(name = "id") String id){


        OrdenCompra ordenCompraToShow = ordenCompraService.findOrdenCompraById(id);

        model.addAttribute("titulo", "PC");
        model.addAttribute("orden", ordenCompraToShow);
        model.addAttribute("suplidor", ordenCompraToShow.getSuplidor());
        model.addAttribute("componentes", ordenCompraToShow.getComponentes());
        return "freemarker/mostrarOrdenes";
    }

}
