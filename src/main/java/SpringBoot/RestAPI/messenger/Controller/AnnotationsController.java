package SpringBoot.RestAPI.messenger.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotations")
public class AnnotationsController {

    @GetMapping("/params/{param}")
    public @ResponseBody
    String getParamsUsingAnnotations(@MatrixVariable(name = "param", required = false) String matrixParam,
                                     @RequestHeader(name = "header", required = false) String header,
                                     @CookieValue(name = "cookie", required = false) String cookie) {

        return "Matrix param: " + matrixParam + "; Header param: " + header + "; Cookies: " + cookie;
    }

}
