package com.gmail.simon.ui.views.orderedit;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.gmail.simon.app.security.ShiroAccessControl;
import com.gmail.simon.backend.data.entity.HistoryItem;
import com.gmail.simon.backend.data.entity.Order;
import com.gmail.simon.backend.service.OrderService;
import com.gmail.simon.ui.utils.DateTimeFormatter;
import com.vaadin.ui.Button.ClickShortcut;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Encapsulates the order history part of the order edit view.
 * <p>
 * Created as a single class because the logic is so simple that using a pattern
 * like MVP would add much overhead for little gain. If more complexity is added
 * to the class, you should consider splitting out a presenter.
 */
@Dependent
public class OrderHistory extends OrderHistoryDesign {

	private final DateTimeFormatter dateTimeFormatter;

	private final javax.enterprise.event.Event<OrderUpdatedEvent> orderUpdatedEvent;

	private Order order;

	private final OrderService orderService;

	private final ShiroAccessControl accessControl;

	@Inject
	public OrderHistory(DateTimeFormatter dateTimeFormatter,
			javax.enterprise.event.Event<OrderUpdatedEvent> orderUpdatedEvent, OrderService orderService,
			ShiroAccessControl accessControl) {
		this.dateTimeFormatter = dateTimeFormatter;
		this.orderUpdatedEvent = orderUpdatedEvent;
		this.orderService = orderService;
		this.accessControl = accessControl;
	}

	@PostConstruct
	public void init() {
		// Uses binder to get bean validation for the message
		BeanValidationBinder<HistoryItem> binder = new BeanValidationBinder<>(HistoryItem.class);
		binder.setRequiredConfigurator(null); // Don't show a *
		binder.bind(newCommentInput, "message");
		commitNewComment.addClickListener(e -> {
			if (binder.isValid()) {
				addNewComment(newCommentInput.getValue());
			} else {
				newCommentInput.focus();
			}
		});

		// We don't want a global shortcut for enter, scope it to the panel
		addAction(new ClickShortcut(commitNewComment, KeyCode.ENTER, null));
	}

	public void addNewComment(String comment) {
		orderService.addHistoryItem(order, comment, accessControl.getUser());
		orderUpdatedEvent.fire(new OrderUpdatedEvent());
	}

	public void setOrder(Order order) {
		this.order = order;
		newCommentInput.setValue("");
		items.removeAllComponents();
		order.getHistory().forEach(historyItem -> {
			Label l = new Label(formatMessage(historyItem));
			l.addStyleName(ValoTheme.LABEL_SMALL);
			l.setCaption(formatTimestamp(historyItem) + " by " + historyItem.getCreatedBy().getName());
			l.setWidth("100%");
			items.addComponent(l);
		});
	}

	private String formatTimestamp(HistoryItem historyItem) {
		return dateTimeFormatter.format(historyItem.getTimestamp(), Locale.US);
	}

	private String formatMessage(HistoryItem historyItem) {
		return historyItem.getMessage();
	}

}
