package co.host.archivist.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mo {
    private String shortName;
    private String codeMo;
    private Boolean isShown;
}
