package kpfu.logistic.server.controller;

import kpfu.logistic.server.entity.AcceptorInfo;
import kpfu.logistic.server.entity.Storage;
import kpfu.logistic.server.entity.User;
import kpfu.logistic.server.service.api.ErrorCodes;
import kpfu.logistic.server.service.api.auth.AuthService;
import kpfu.logistic.server.service.api.exceptions.InvalidFormException;
import kpfu.logistic.server.service.api.exceptions.StorageNotFoundException;
import kpfu.logistic.server.service.api.exceptions.TokenNotFoundException;
import kpfu.logistic.server.service.api.exceptions.UserNotFoundException;
import kpfu.logistic.server.service.api.form.PackageForm;
import kpfu.logistic.server.service.api.packages.PackageService;
import kpfu.logistic.server.service.api.response.ApiResult;
import kpfu.logistic.server.service.api.response.PackageRegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ErrorCodes errorCodes;

    @Autowired
    private PackageService packageService;

    @RequestMapping(value = "/package", method = RequestMethod.POST)
    public ApiResult addPackage(
            @RequestHeader(name = "token", required = true) String token,
            @RequestBody PackageForm packageForm
            ) throws TokenNotFoundException {

        PackageRegisterResult result = null;
        int errorCode = errorCodes.success();
        try {
            User user = authService.getUserByToken(token);
            if (authService.userHasRole(user, User.ROLE_ACCEPTOR)) {
                AcceptorInfo acceptorInfo = authService.getAcceptorInfoByUser(user);
                if (acceptorInfo != null) {
                    result = packageService.register(packageForm, acceptorInfo.getStorage());
                } else {
                    errorCode = errorCodes.notFound();
                }
            } else {
                errorCode = errorCodes.permissionDenied();
            }


        } catch (UserNotFoundException | StorageNotFoundException e) {
            e.printStackTrace();
            errorCode = errorCodes.notFound();
        } catch (InvalidFormException e) {
            e.printStackTrace();
            errorCode = errorCodes.invalidForm();
        }

        return new ApiResult(errorCode, result);
    }


}
