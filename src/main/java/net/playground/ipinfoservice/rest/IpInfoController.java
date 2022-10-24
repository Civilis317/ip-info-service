package net.playground.ipinfoservice.rest;

import lombok.extern.slf4j.Slf4j;
import net.playground.ipinfoservice.model.CheckIpWhitelistedRequest;
import net.playground.ipinfoservice.model.CheckIpWhitelistedResponse;
import net.playground.ipinfoservice.persistence.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/ip")
public class IpInfoController extends AbstractController {

    private final StorageService storageService;

    public IpInfoController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/check")
    public @ResponseBody CheckIpWhitelistedResponse checkIpAddress(CheckIpWhitelistedRequest request) {
        return storageService.checkIpAddress(request);
    }
}
