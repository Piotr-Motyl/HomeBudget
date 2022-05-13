package pl.motylpiotr.homebudget.spending;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class SpendingServlet {

    @Autowired
    private SpendingService spendingService;

    @GetMapping(value = "/spending", params = {"sortBy"})
    List<SpendingDTO> getSpendings(@RequestParam("sortBy")String sortBy) {
        log.info("####################################");
        log.info("SpendingServlet - getSpendings - @GetMapping(\"/spending\")");
        log.info("####################################");
        return spendingService.getSpendings(sortBy).stream().map(this::spendingAsDTO).collect(Collectors.toList());
    }

    @PostMapping("/spending")
    public SpendingDTO addSpending(@RequestBody SpendingDTO spendingDTO) {
        log.info("####################################");
        log.info("SpendingServlet - addSpending - @PostMapping(\"/spending\")");
        log.info("####################################");
        return spendingAsDTO(
                spendingService.addSpending(
                        spendingDTO.getAmountSpending(),
                        spendingDTO.getDescriptionSpending(),
                        spendingDTO.getLabelSpending()
                ));
    }
    public SpendingDTO spendingAsDTO(SpendingModel spendingModel) {
        return SpendingDTO.builder()
                .idSpending(spendingModel.getIdSpending())
                .amountSpending(spendingModel.getAmountSpending())
                .descriptionSpending(spendingModel.getDescriptionSpending())
                .labelSpending(spendingModel.getLabelSpending())
                .build();
    }
}