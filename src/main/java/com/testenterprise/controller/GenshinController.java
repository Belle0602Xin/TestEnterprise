package com.testenterprise.controller;

import com.testenterprise.Genshin;
import com.testenterprise.service.GenshinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GenshinController {

    private GenshinService genshinService;

    public GenshinController(GenshinService genshinService) {
        this.genshinService = genshinService;
    }

    @GetMapping(value = "/genshin")
    public Genshin genshin() {
        return genshinService.getGenshin();
    }
}
