package uk.wanat.policespring.model.myapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Police {
    private String force;
    private Map<String, Long> crimeTypeCout;
    private Map<String, Long> outcomeStatusCount;

}
