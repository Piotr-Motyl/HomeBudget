package pl.motylpiotr.homebudget.spending;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SpendingService {

    @Autowired
    private SpendingCrudRepository spendingCrudRepository;

    public List<SpendingModel> getSpendings(String sortBy) {
        if ("idSpending".equals(sortBy)) {
            return spendingCrudRepository.findAllSpendingById();
        }

        return spendingCrudRepository.findAll();
    }

    public SpendingModel addSpending(BigDecimal amountSpending, String descriptionSpending, String labelSpending) {
        SpendingModel spendingModel = SpendingModel.builder()
                .amountSpending(amountSpending)
                .descriptionSpending(descriptionSpending)
                .labelSpending(labelSpending)
                .build();
        return spendingCrudRepository.save(spendingModel);
    }

    public Optional<SpendingModel> updateSpending(int idSpending, BigDecimal amountSpending,
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