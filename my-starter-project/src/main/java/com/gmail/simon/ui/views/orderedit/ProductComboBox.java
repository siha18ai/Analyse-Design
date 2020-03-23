package com.gmail.simon.ui.views.orderedit;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.gmail.simon.backend.data.entity.Product;
import com.vaadin.ui.ComboBox;

@Dependent
public class ProductComboBox extends ComboBox<Product> {

	@Inject
	public ProductComboBox(ProductComboBoxDataProvider dataProvider) {
		setWidth("100%");
		setEmptySelectionAllowed(false);
		setPlaceholder("Product");
		setItemCaptionGenerator(Product::getName);
		setDataProvider(dataProvider);
	}

}
