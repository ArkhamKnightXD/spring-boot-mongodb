package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.services.SuplidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
