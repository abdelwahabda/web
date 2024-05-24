package taxes.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxeSecurityController {
    @RequestMapping( value = "/login" )
    public String login() {
        return "login";
    }

    @RequestMapping( "/403" )
    public String accesDined() {
        return "403";
    }

}
