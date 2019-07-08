package arkham.knight.parcial2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suplidor")
public class SuplidorController {

    @RequestMapping("/")
    public String index(Model model ){


        return "freemarker/suplidores";
    }

}
