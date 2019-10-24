package uk.wanat.policespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uk.wanat.policespring.model.myapi.Police;
import uk.wanat.policespring.model.policedata.ListOfForces;
import uk.wanat.policespring.model.policedata.PoliceData;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PoliceApi {

    PoliceProvider policeProvider;

    @Autowired
    public PoliceApi(PoliceProvider policeProvider) {
        this.policeProvider = policeProvider;
    }

    @GetMapping("api/categorycount")
    public List<Police> getData() {
        ListOfForces listOfForces = new ListOfForces();
        List<String> forces = listOfForces.getForces();
        return returnAPIdata(forces);

    }

    @GetMapping("api/categorycountp")
    @ResponseBody
    public List<Police> getDataForOneForce(@RequestParam String f){
        List<String> forceList = new ArrayList<>();
        forceList.add(f);
        List<Police> policeList = returnAPIdata(forceList);

        return policeList;
    }

    private List<Police> returnAPIdata(List<String> forces) {
        PoliceData[] data;
        Police police;
        List<Police> policeList = new ArrayList<>();
        Map<String, Long> categoryHashMap = new HashMap();
        Map<String, Long> outcomeStatusHashMap = new HashMap();

        for (String force : forces) {
            data = policeProvider.getData(force);
            police = new Police();

            getCatogoryList(data, categoryHashMap);
            getOutcomeList(data, outcomeStatusHashMap);

            police.setForce(force);
            police.setCrimeTypeCout(categoryHashMap);
            police.setOutcomeStatusCount(outcomeStatusHashMap);
            policeList.add(police);
        }
        return policeList;
    }

    private void getOutcomeList(PoliceData[] data, Map<String, Long> outcomeStatusHashMap) {
        List<String> outcomeList = Arrays.stream(data).filter(e -> e.getOutcomeStatus() != null).map(e -> e.getOutcomeStatus().getCategory()).collect(Collectors.toList());
        for (String outcome : outcomeList) {
            Long count = Arrays.stream(data).filter(e -> e.getOutcomeStatus() != null).filter(e -> e.getOutcomeStatus().getCategory().equals(outcome)).count();
            outcomeStatusHashMap.put(outcome, count);
        }
    }

    private void getCatogoryList(PoliceData[] data, Map<String, Long> categoryHashMap) {
        List<String> catregoryList = Arrays.stream(data).map(e -> e.getCategory()).distinct().collect(Collectors.toList());
        for (String category : catregoryList) {
            Long count = Arrays.stream(data).filter(e -> e.getCategory().equals(category)).count();
            categoryHashMap.put(category, count);
        }
    }
}
