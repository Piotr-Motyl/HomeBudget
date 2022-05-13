package pl.motylpiotr.homebudget.spending;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpendingCrudRepository extends JpaRepository<SpendingModel, Integer> {

    @Query("FROM SpendingModel ORDER BY idSpending")
    List<SpendingModel> findAllSpendingById();
}
