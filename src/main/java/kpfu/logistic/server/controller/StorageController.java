package kpfu.logistic.server.controller;


import kpfu.logistic.server.service.api.ErrorCodes;
import kpfu.logistic.server.service.api.auth.AuthService;
import kpfu.logistic.server.service.api.response.ApiResult;
import kpfu.logistic.server.service.api.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ErrorCodes errorCodes;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/storage")
    public ApiResult storagesByCountryCity(
            @RequestParam(name = "country", required = true) String country,
            @RequestParam(name = "city", required = true) String city) {

        return new ApiResult()
                .setCode(errorCodes.success())
                .setBody(storageService.getByCountryCity(country, city));


    }

}
