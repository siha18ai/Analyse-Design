package com.gmail.simon.ui.views.admin.product;

import javax.inject.Inject;

import com.vaadin.cdi.ViewScoped;
import com.gmail.simon.backend.data.entity.Product;
import com.gmail.simon.backend.service.ProductService;
import com.gmail.simon.ui.navigation.NavigationManager;
import com.gmail.simon.ui.views.admin.AbstractCrudPresenter;

@ViewScoped
public class ProductAdminPresenter extends AbstractCrudPresenter<Product, ProductService, ProductAdminView> {

	@Inject
	public ProductAdminPresenter(ProductAdminDataProvider productAdminDataProvider, NavigationManager navigationManager,
			ProductService service) {
		super(navigationManager, service, Product.class, productAdminDataProvider);
	}
}
