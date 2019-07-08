package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.services.MovimientoInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movimiento-inventario")
public class MovimientoInventarioController {

    @Autowired
    private MovimientoInventarioService movimientoInventarioService;


    @RequestMapping("/")
    public String index(Model model ){


        return "freemarker/movimientos";
    }


}
