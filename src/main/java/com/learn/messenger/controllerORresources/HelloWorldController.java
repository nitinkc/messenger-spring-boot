package com.learn.messenger.controllerORresources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nitin on Thursday, January/09/2020 at 9:45 PM
 */

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String HelloWorldTesting(){
        return "Messenger Service is Up and Running...";
    }
}
