package com.ecommerce.project.model;

import jakarta.persistence.*;
<<<<<<< Updated upstream
=======
//import jakarta.persistence.criteria.Order;
>>>>>>> Stashed changes
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne(mappedBy = "payment", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Order order;

    @NotBlank
<<<<<<< Updated upstream
    @Size(min = 1, message = "Payment method must contain at least 4 characters")
=======
    @Size(min = 4, message = "Payment method must contain at least 4 characters")
>>>>>>> Stashed changes
    private String paymentMethod;
	
    private String pgPaymentId;
    private String pgStatus;
    private String pgResponseMessage;

    private String pgName;

<<<<<<< Updated upstream
    public Payment(Long paymentId, String pgPaymentId, String pgStatus, String pgResponseMessage, String pgName) {
        this.paymentId = paymentId;
=======

    public Payment(String paymentMethod, String pgPaymentId, String pgStatus,
                   String pgResponseMessage, String pgName) {
        this.paymentMethod = paymentMethod;
>>>>>>> Stashed changes
        this.pgPaymentId = pgPaymentId;
        this.pgStatus = pgStatus;
        this.pgResponseMessage = pgResponseMessage;
        this.pgName = pgName;
    }
}
