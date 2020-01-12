package org.easymis.easysaas.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class ApiTestController {

    @GetMapping("/demo")
    private String  demo(){
        return "demo";
    }
}
