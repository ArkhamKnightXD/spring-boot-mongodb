package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.model.OrdenCompra;
import arkham.knight.parcial2.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orden-compra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @RequestMapping("/")
    public String index(Model model ){

        model.addAttribute("ordenes", ordenCompraService.listarOrdenesDeCompra());
        return "freemarker/ordenes";
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
