package com.testenterprise.controller;

import com.testenterprise.dto.GenshinDto;
import com.testenterprise.dto.request.GenshinPatchRequest;
import com.testenterprise.dto.request.GenshinPutRequest;
import com.testenterprise.service.GenshinService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class GenshinController {

    private GenshinService genshinService;

    public GenshinController(GenshinService genshinService) {
        this.genshinService = genshinService;
    }

    @PatchMapping(value = "/genshin/{id}")
    public void patchGenshin(@PathVariable String id, @RequestBody GenshinPatchRequest genshinPatchRequest) {
        genshinService.patchGenshin(genshinPatchRequest, id);
    }

    @DeleteMapping(value = "/genshin/{id}")
    public void deleteGenshin(@PathVariable String id) {
        genshinService.deleteGenshin(id);
    }

    @PutMapping(value = "/genshin/{id}")
    public void putGenshin(@PathVariable String id, @RequestBody GenshinPutRequest genshinPutRequest) {
        genshinService.putGenshin(genshinPutRequest, id);
    }
}
