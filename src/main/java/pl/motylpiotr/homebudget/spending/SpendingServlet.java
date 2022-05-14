package pl.motylpiotr.homebudget.spending;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class SpendingServlet {

    @Autowired
    private SpendingService spendingService;

    @GetMapping("/spending")
    List<SpendingDTO> getSpendings(@RequestParam("sortBy")String sortBy) {
        log.info("###################################");
        log.info("SpendingServlet - getSpendings - @GetMapping(\"/spending\")");
        log.info("###################################");
        return spendingService.getSpendings(sortBy).stream().map(this::spendingAsDTO).collect(Collectors.toList());
    }

    @PostMapping("/spending")
    public SpendingDTO addSpending(@RequestBody SpendingDTO spendingDTO) {
        log.info("###################################");
        log.info("SpendingServlet - addSpending - @PostMapping(\"/spending\")");
        log.info("###################################");
        return spendingAsDTO(
                spendingService.addSpending(
                        spendingDTO.getAmountSpending(),
                        spendingDTO.getDescriptionSpending(),
                        spendingDTO.getLabelSpending()
                ));
    }
    @PutMapping("/spending/{idSpending}")
    public SpendingDTO updateSpending(@PathVariable("idSpending") Integer idSpending,
                                      @RequestBody SpendingDTO spendingDTO) {
        return spendingService
                .updateSpending(idSpending, spendingDTO.getAmountSpending(), spendingDTO.getDescriptionSpending(), spendingDTO.getLabelSpending())
                .map(this::spendingAsDTO)
                .orElseThrow();
    }

    @DeleteMapping("/spending/{idSpending}")
    public void deleteSpending(@PathVariable("idSpending") Integer idSPending) {
        spendingService.deleteSpending(idSPending);
    }





    public SpendingDTO spendingAsDTO(@NotNull SpendingModel spendingModel) {
        return SpendingDTO.builder()
                .idSpending(spendingModel.getIdSpending())
                .amountSpending(spendingModel.getAmountSpending())
                .descriptionSpending(spendingModel.getDescriptionSpending())
                .labelSpending(spendingModel.getLabelSpending())
                .build();
    }
}