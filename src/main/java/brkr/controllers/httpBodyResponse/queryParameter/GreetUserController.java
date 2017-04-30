package brkr.controllers.httpBodyResponse.queryParameter;

import brkr.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetUserController {

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    @ResponseBody
    public String greetUser(@RequestParam(value = "user") String userName) {
        return "Hello " + userName;
    }

    @RequestMapping(value = "/greetJson", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Greeting greetUserJson(
            @RequestParam(value = "user") String userName,
            @RequestParam(value = "withMessage") String message) {
        return new Greeting(message, userName);
    }

    @RequestMapping(value = "/greetXml", method = RequestMethod.GET, produces = "application/xml")
    @ResponseBody
    public Greeting greetUserXml(
            @RequestParam(value = "user", required = false, defaultValue = "") String userName,
            @RequestParam(value = "withMessage", required = false, defaultValue = "hello") String message) {
        return new Greeting(message, userName);
    }
}


