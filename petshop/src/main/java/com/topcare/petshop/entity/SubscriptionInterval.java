package com.topcare.petshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SubscriptionInterval {

    MONTHLY("30 dias"),
    EVERY_OTHER_WEEK("14 dias"),
    EVERY_WEEK("7 dias"),
    EVERY_DAY("1 dia"),
    EVERY_YEAR("1 ano");

    private String subscriptionInterval;

}
