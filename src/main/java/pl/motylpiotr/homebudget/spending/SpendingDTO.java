package pl.motylpiotr.homebudget.spending;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SpendingDTO {

    private Integer idSpending;

    @NotEmpty(message = "Spending must be not empty")
    private BigDecimal amountSpending;

    private String descriptionSpending;

    private String labelSpending;
}
