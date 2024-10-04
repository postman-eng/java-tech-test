package com.postman;

import net.ezpay.provider.EZPayPaymentProvider;
import org.payments.PaymentProvider;
import org.payments.billing.BillResult;
import org.payments.billing.BillingService;
import org.payments.billing.impl.BatchBillingService;
import org.payments.customer.CustomerBillingDetails;

import java.util.List;
import java.util.Set;

/**
 * Just a bootstrap class that allows us to abstract the payment.
 *
 * @author Landon Wainwright
 */
public class PostmanBillingService implements BillingService {
    private final BillingService billingService;

    public PostmanBillingService() {

        // We will be using the EZPay provider
        this(new EZPayPaymentProvider());
    }

    public PostmanBillingService(PaymentProvider paymentProvider) {

        // We will be using the EZPay provider
        this(new BatchBillingService(paymentProvider));
    }

    public PostmanBillingService(BillingService billingService) {
        assert billingService != null;
        this.billingService = billingService;
    }

    public Set<BillResult> bill(List<CustomerBillingDetails> billingDetails) {

        // Bill for the product
        return billingService.bill(billingDetails);
    }
}
