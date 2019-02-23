package org.tc.autotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/usc/debug")
public class TestController {



    @RequestMapping("/index")
    public String index() {
        String services = "[debugName: index]";
        return services;
    }

    @RequestMapping("/get")
    public String get() {
        String services = "[debugName: get]";
        return services;
    }



}
