package br.ufscar.pooa.cinema_api.application.ports.out.payment;

import br.ufscar.pooa.cinema_api.domain.enums.PaymentMethod;

public interface IPaymentStrategy {
    boolean pay(Integer amount);
    PaymentMethod getPaymentMethod();
}
