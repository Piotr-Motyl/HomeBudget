package pl.motylpiotr.homebudget.spending;

import lombok.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SpendingDTO {

    private Integer idSpending;

    @NotEmpty(message = "Spending must be not empty")
    private Double amountSpending;

    private String descriptionSpending;

    private String labelSpending;
}
