package Jamal.projetoZero;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public String mostrarMenu() {
        return "menu"; // nome da página HTML para exibir o menu
    }
}
