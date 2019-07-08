package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orden-compra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService ordenCompraService;

    @RequestMapping("/")
    public String index(Model model ){



        return "freemarker/ordenes";
    }

}
