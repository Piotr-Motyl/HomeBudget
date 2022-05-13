package pl.motylpiotr.homebudget.spending;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "spending")
public class SpendingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_spending")
    private Integer idSpending;

    @Column(name = "amount_spending")
    private Double amountSpending;

    @Column(name = "description_spending")
    private String descriptionSpending;

    @Column(name = "label_spending")
    private String labelSpending;
}