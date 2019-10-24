package uk.wanat.policespring;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.wanat.policespring.model.policedata.PoliceData;

@Service
public class PoliceProvider {

    public PoliceData[] getData(String force){
        String url = "https://data.police.uk/api/crimes-no-location?category=all-crime&force=" + force + "&date=2019-08";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PoliceData[]> forEntity = restTemplate.getForEntity(url, PoliceData[].class);

        return forEntity.getBody();
    }
}
