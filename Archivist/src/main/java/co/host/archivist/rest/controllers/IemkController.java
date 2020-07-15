package co.host.archivist.rest.controllers;

import co.host.archivist.rest.clients.IemkClient;
import co.host.archivist.rest.dto.PatientList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

/**
 * Rest Controller для обработки запроса /iemk
 */
@RestController
public class IemkController {
    IemkClient iemkClient;

    @Autowired
    IemkController(IemkClient iemkClient){
        this.iemkClient = iemkClient;
    }

    @GetMapping("/iemk")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PatientList> getPatients(
            @RequestParam(value = "patientSnils", required = false) String patientSnils,
            @RequestParam(value = "patientLastName", required = false) String patientLastName)
    {
        PatientList patientList;

        if (Objects.nonNull(patientSnils) && Objects.nonNull(patientLastName)){
            patientList = iemkClient.getPatient(patientSnils, patientLastName);
        } else if (Objects.nonNull(patientSnils)) {
            patientList = iemkClient.getPatientBySnils(patientSnils);
        } else if (Objects.nonNull(patientLastName)) {
            patientList = iemkClient.getPatientByLastName(patientLastName);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не один параметр ни указан");
        }

        if (patientList.getPatientList().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователи не найдены");

        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
}