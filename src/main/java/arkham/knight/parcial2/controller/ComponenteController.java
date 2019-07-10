package arkham.knight.parcial2.controller;

import arkham.knight.parcial2.model.Componente;
import arkham.knight.parcial2.services.ComponenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/componente")
public class ComponenteController {

    @Autowired
    private ComponenteService componenteService;


    @RequestMapping("/")
    public String index(Model model ){

        model.addAttribute("componentes", componenteService.listarComponentes());

        return "freemarker/componentes";
    }


    @RequestMapping("/creacion")
    public String creacionComponente(Model model){

        model.addAttribute("titulo", "Pc Parts CXA");

        return "/freemarker/crearComponente";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearComponente(@RequestParam(name = "descripcion") String descripcion, @RequestParam(name = "codigoAlmacen") String codigoAlmacen, @RequestParam(name = "stock") int stock, @RequestParam(name = "unidadCompra") String unidadCompra ){


        Componente componenteToCreate = new Componente(descripcion,codigoAlmacen,stock,unidadCompra);

        componenteService.createComponent(componenteToCreate);
        return "redirect:/componente/";
    }


    @RequestMapping("/edicion")
    public String edicionComponente(Model model,@RequestParam(name = "id") String id){

        Componente componenteToEdit = componenteService.findComponenteById(id);

        model.addAttribute("titulo", "Pc Parts CXA");
        model.addAttribute("componente", componenteToEdit);

        return "/freemarker/editarComponente";
    }


    @RequestMapping( value = "/editar")
    public String editarComponente(@RequestParam(name = "id") String id, @RequestParam(name = "descripcion") String descripcion, @RequestParam(name = "codigoAlmacen") String codigoAlmacen, @RequestParam(name = "stock") int stock, @RequestParam(name = "unidadCompra") String unidadCompra ){


        Componente componenteToEdit = componenteService.findComponenteById(id);

        componenteToEdit.setDescripcion(descripcion);
        componenteToEdit.setCodigoAlmacen(codigoAlmacen);
        componenteToEdit.setStock(stock);
        componenteToEdit.setUnidadCompra(unidadCompra);


        componenteService.createComponent(componenteToEdit);
        return "redirect:/componente/";
    }


    // Considero que editar usuario no es necesario, por lo tanto no creare estas funciones
    @RequestMapping("/borrar")
    public String eliminarComponente(@RequestParam(name = "id") String id){


        Componente componenteToDelete = componenteService.findComponenteById(id);

        componenteService.deleteComponent(componenteToDelete);

        return "redirect:/componente/";
    }


}
