package pl.motylpiotr.homebudget.spending;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SpendingService {

    @Autowired
    private SpendingCrudRepository spendingCrudRepository;

    public List<SpendingModel> getSpendings(String sortBy) {
        if ("idSpending".equals(sortBy)) {
            log.info("####################################");
            log.info("SpendingService - getSpendings - IF");
            log.info("####################################");
            return spendingCrudRepository.findAllSpendingById();
        }

        log.info("####################################");
        log.info("SpendingService - getSpendings - bez IFa");
        log.info("####################################");
        return spendingCrudRepository.findAll();
    }

    public SpendingModel addSpending(Double amountSpending, String descriptionSpending, String labelSpending) {
        SpendingModel spendingModel = SpendingModel.builder()
                .amountSpending(amountSpending)
                .descriptionSpending(descriptionSpending)
                .labelSpending(labelSpending)
                .build();
        return spendingCrudRepository.save(spendingModel);
    }

    public Optional<SpendingModel> updateSpending(int idSpending, Double amountSpending,
                                                  String descriptionSpending, String labelSpending) {
        SpendingModel spendingModel = SpendingModel.builder()
                .idSpending(idSpending)
                .amountSpending(amountSpending)
                .descriptionSpending(descriptionSpending)
                .labelSpending(labelSpending)
                .build();

        return spendingCrudRepository
                .findById(idSpending)
                .map(savedSpendingModel -> spendingCrudRepository.save(spendingModel));
    }

    public void deleteSpending(int idSpending) {
        spendingCrudRepository.deleteById(idSpending);
    }
}