package co.host.archivist.rest.controllers;

import co.host.archivist.rest.dto.User;
import co.host.archivist.soap.SoapModelManager;
import co.host.archivist.soap.dto.UserSoap;
import co.host.archivist.soap.exceptions.SoapResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<User> getUser(@RequestParam(value = "snils") String snils){
        try {
            final UserSoap userSoap = SoapModelManager.getUserClientBySnils(snils);

            final long userId = Long.parseLong(userSoap.getSnils());
            final String firstName = userSoap.getFirstname();
            final String middleName = userSoap.getMiddlename();
            final String lastName = userSoap.getLastname();

            return new ResponseEntity<User>(new User(userId, firstName, middleName, lastName), HttpStatus.OK);
        } catch (SoapResponseException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}