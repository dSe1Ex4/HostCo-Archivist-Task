package co.host.archivist.rest.controllers;

import co.host.archivist.db.repositories.RefMoRepository;
import co.host.archivist.rest.dto.Mo;
import co.host.archivist.rest.dto.MoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Rest Controller для обработки запроса /mo
 */
@RestController
public class MoController {
    RefMoRepository moRepository;

    @Autowired
    MoController(RefMoRepository moRepository){
        this.moRepository = moRepository;
    }

    @GetMapping("/mo")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MoList> getMo(){
        final MoList list = new MoList();

        moRepository.findByMaxVersionAndIsShown(true).forEach(
                refMo -> list.getMoList().add(
                        new Mo(refMo.getNameshort(), refMo.getOid(), refMo.getIsShown())
                ));

        if (list.getMoList().isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Требуемые МО отсутствуют в БД");

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}