package ro.bogdanmariesan.rest.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.bogdanmariesan.rest.spring.response.GenericResponse;

/**
 * Created by bogdan.mariesan on 1/24/2015.
 */
@RestController
@RequestMapping("/")
public class SpringRestController {


    @RequestMapping(value = "/benchmark", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public GenericResponse exampleGet() {
        return new GenericResponse();
    }

}
