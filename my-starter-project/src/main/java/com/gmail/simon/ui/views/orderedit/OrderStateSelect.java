package com.gmail.simon.ui.views.orderedit;

import com.vaadin.cdi.ViewScoped;
import com.gmail.simon.app.HasLogger;
import com.gmail.simon.backend.data.OrderState;
import com.vaadin.ui.ComboBox;

@ViewScoped
public class OrderStateSelect extends ComboBox<OrderState> implements HasLogger {

	public OrderStateSelect() {
		setEmptySelectionAllowed(false);
		setTextInputAllowed(false);
		setItems(OrderState.values());
		setItemCaptionGenerator(OrderState::getDisplayName);
	}

}
