package uk.wanat.policespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.wanat.policespring.model.policedata.PoliceData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PoliceController {
    PoliceProvider policeProvider;

    @Autowired
    public PoliceController(PoliceProvider policeProvider) {
        this.policeProvider = policeProvider;
    }

    @GetMapping()
    @RequestMapping("/data")
    public String chcek(Model model, PoliceData[] data){
        PoliceData[] data = policeProvider.getData("city-of-london");
        List<String> categorList = Arrays.stream(data).map(e -> e.getCategory()).distinct().collect(Collectors.toList());
        model.addAttribute("categorList", categorList);
        return "data";
    }
}
