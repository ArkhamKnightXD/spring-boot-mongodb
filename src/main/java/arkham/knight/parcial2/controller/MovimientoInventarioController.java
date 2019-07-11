package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.model.MovimientoInventario;
import arkham.knight.parcial2.services.ComponenteService;
import arkham.knight.parcial2.services.MovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movimiento-inventario")
public class MovimientoInventarioController {

    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    @Autowired
    private ComponenteService componenteService;


    @RequestMapping("/")
    public String index(Model model ){

        model.addAttribute("movimientos", movimientoInventarioService.listarMovimientoInventario());


        return "freemarker/movimientos";
    }


    @RequestMapping("/creacion")
    public String creacionMovimientoInventario(Model model){

        model.addAttribute("titulo", "Pc Parts CXA");
        model.addAttribute("componentes", componenteService.listarComponentes());

        return "/freemarker/crearMovimientoInventario";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearMovimientoInventario(@RequestParam(name = "tipoMovimiento") String tipoMovimiento, @RequestParam(name = "unidad") String unidad, @RequestParam(name = "cantidad") int cantidad, @RequestParam(name = "idComponente") String idComponente){


        Componente componenteToInventario = componenteService.findComponenteById(idComponente);

        //si el tipo de movimiento es de entrada entonces la cantidad se sumara con el stock de componente que tengo ya
        //en inventario y en un else hare una resta para cuando sea salida osea lo contrario
        if (tipoMovimiento.equalsIgnoreCase("entrada")){

            cantidad += componenteToInventario.getStock();

            // Agrego la cantidad al stock para que tengan los mismo valores
            componenteToInventario.setStock(cantidad);

            //Luego hago un create ya que hice cambios al objeto y necesito salvarlos
            componenteService.createComponent(componenteToInventario);
        }
        else{
            cantidad = componenteToInventario.getStock()-cantidad;
            componenteToInventario.setStock(cantidad);

            componenteService.createComponent(componenteToInventario);
        }

        MovimientoInventario movimientoInventarioToCreate = new MovimientoInventario(tipoMovimiento,cantidad,unidad,componenteToInventario.getCodigoAlmacen(),componenteToInventario);

        movimientoInventarioService.createMovimientoInventario(movimientoInventarioToCreate);

        return "redirect:/movimiento-inventario/";
    }


}
