package brkr.controllers.httpBodyResponse.helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping(value = "*")
    @ResponseBody
    public String fallbackMethod() {
        return "Fallback controller - for requests not mapped to any other controller.";
    }
}
