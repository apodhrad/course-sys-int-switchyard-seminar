package com.example.switchyard.switchyard_seminar_final.accounting;

import com.example.switchyard.switchyard_seminar_final.model.Order;

public interface AccountingService {

	AccountResponse account(Order order);
}
