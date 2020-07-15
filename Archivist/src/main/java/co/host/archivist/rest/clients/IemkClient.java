package co.host.archivist.rest.clients;

import co.host.archivist.rest.dto.PatientList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST клиент для запроса /iemk удаленного сервера
 * Создано три Request метода для отказоустойчевости при неправильной реализации удаленного REST сервера
 */
@FeignClient(value = "clientIEMK", url = "${app.REST.ServiceURL}")
public interface IemkClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "iemk?patientSnils={snils}&patientLastName={lastName}",
            produces = "application/json")
    PatientList getPatient(@PathVariable("snils") String snils,
                           @PathVariable("lastName") String lastName
    );

    @RequestMapping(
            method = RequestMethod.GET,
            value = "iemk?patientSnils={snils}",
            produces = "application/json")
    PatientList getPatientBySnils(@PathVariable("snils") String snils);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "iemk?patientLastName={lastName}",
            produces = "application/json")
    PatientList getPatientByLastName(@PathVariable("lastName") String lastName);
}