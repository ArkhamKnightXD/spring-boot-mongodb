package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.model.Suplidor;
import arkham.knight.parcial2.services.SuplidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/suplidor")
public class SuplidorController {

    @Autowired
    private SuplidorService suplidorService;

    @RequestMapping("/")
    public String index(Model model ){

        model.addAttribute("suplidores", suplidorService.listarSuplidores());
        return "freemarker/suplidores";
    }


    // Considero que editar usuario no es necesario, por lo tanto no creare estas funciones
    @RequestMapping("/borrar")
    public String eliminarSuplidor(@RequestParam(name = "id") String id){


        Suplidor suplidorToDelete = suplidorService.findSuplidorById(id);

        suplidorService.deleteSuplidor(suplidorToDelete);

        return "redirect:/suplidor/";
    }

}
