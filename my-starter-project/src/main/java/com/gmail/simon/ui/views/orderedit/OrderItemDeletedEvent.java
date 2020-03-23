package com.gmail.simon.ui.views.orderedit;

import com.gmail.simon.backend.data.entity.OrderItem;

public class OrderItemDeletedEvent {

	private OrderItem orderItem;

	public OrderItemDeletedEvent(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}
}
