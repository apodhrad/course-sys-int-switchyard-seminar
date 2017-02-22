package com.redhat.brq.integration.switchyard.accounting;

import com.redhat.brq.integration.switchyard.models.Order;

public interface RefService {

    String account(Order order);
}
