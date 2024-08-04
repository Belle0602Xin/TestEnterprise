package com.testenterprise.controller;

import com.testenterprise.dto.GenshinDto;
import com.testenterprise.service.GenshinService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class GenshinController {

    private GenshinService genshinService;

    public GenshinController(GenshinService genshinService) {
        this.genshinService = genshinService;
    }

    @GetMapping(value = "/genshin/{id}")
    public GenshinDto getGenshinById(@PathVariable String id) {
        return genshinService.getGenshin(id);
    }

    @PostMapping(value = "/genshin")
    public void saveGenshin(@RequestBody GenshinDto genshinDto) {
        genshinService.saveGenshin(genshinDto);
    }
}
