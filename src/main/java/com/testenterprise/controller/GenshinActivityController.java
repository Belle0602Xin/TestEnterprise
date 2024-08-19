package com.testenterprise.controller;

import com.testenterprise.property.GenshinProperty;
import com.testenterprise.service.GenshinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/activity")
public class GenshinActivityController {

    private GenshinService genshinService;

    public GenshinActivityController(GenshinService genshinService) {
        this.genshinService = genshinService;
    }

    @PostMapping
    public GenshinProperty saveGenshinProperty() {
        GenshinProperty genshinProperty = genshinService.saveGenshinProperty();
        return genshinProperty;
    }
}
