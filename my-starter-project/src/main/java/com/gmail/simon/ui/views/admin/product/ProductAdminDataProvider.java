package com.gmail.simon.ui.views.admin.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.gmail.simon.backend.data.entity.Product;
import com.gmail.simon.backend.service.ProductService;
import com.gmail.simon.ui.components.FilterablePageableDataProvider;

@Dependent
public class ProductAdminDataProvider extends FilterablePageableDataProvider<Product, Object> {

	private final ProductService productService;

	@Inject
	public ProductAdminDataProvider(ProductService productService) {
		this.productService = productService;
	}

	@Override
	protected Stream<Product> fetchFromBackEnd(Query<Product, Object> query, List<QuerySortOrder> sortOrders) {
		return productService.findAnyMatching(getOptionalFilter(), query.getOffset(), query.getLimit(), sortOrders);
	}

	@Override
	protected int sizeInBackEnd(Query<Product, Object> query) {
		return (int) productService.countAnyMatching(getOptionalFilter());
	}

	@Override
	protected List<QuerySortOrder> getDefaultSortOrders() {
		List<QuerySortOrder> sortOrders = new ArrayList<>();
		sortOrders.add(new QuerySortOrder("name", SortDirection.ASCENDING));
		return sortOrders;
	}

}