package co.host.archivist.rest.controllers;

import co.host.archivist.db.models.StoredData;
import co.host.archivist.db.repositories.StoredDataRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

/**
 * Rest Controller для обработки запроса /data
 */
@RestController
public class DataController {
    StoredDataRepositoryImpl dataRepository;

    @Autowired
    public DataController(StoredDataRepositoryImpl dataRepository) {
        this.dataRepository = dataRepository;
    }

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.OK)
    public void postData(@RequestBody StoredData data){
        if (Objects.nonNull(data.getUserId()))
            dataRepository.save(data);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserId is Null");
    }
}