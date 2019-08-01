package com.fengwenyi.wyf_aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2019-08-01 16:06
 */
@RestController
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

}
