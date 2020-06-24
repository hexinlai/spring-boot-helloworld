package de.ykoer.examples.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/ping"
    )
    public String ping() {
    	logger.info("This is /ping request");
        return "Hello World! It is wonderful!";
    }
    
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/greeting"
    )
    public String greeting() {
    	logger.info("This is /greeting request");
        return "This is a greeting";
    }
    
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/hello"
    )
    public String error() throws Exception {
    	logger.info("This is /error request");
    	throw new Exception("This is an error");

    }


}
