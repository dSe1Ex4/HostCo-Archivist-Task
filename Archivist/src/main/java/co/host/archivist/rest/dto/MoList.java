package co.host.archivist.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoList {
    private List<Mo> moList = new ArrayList<>();

    public void add(Mo mo){
        moList.add(mo);
    }
    public boolean isEmpty(){
        return moList.isEmpty();
    }
}
