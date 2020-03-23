package com.gmail.simon.ui.views.admin.user;

import java.io.Serializable;

import javax.inject.Inject;

import com.vaadin.cdi.ViewScoped;
import com.gmail.simon.backend.data.entity.User;
import com.gmail.simon.backend.service.UserService;
import com.gmail.simon.ui.navigation.NavigationManager;
import com.gmail.simon.ui.views.admin.AbstractCrudPresenter;

@ViewScoped
public class UserAdminPresenter extends AbstractCrudPresenter<User, UserService, UserAdminView>
		implements Serializable {

	@Inject
	public UserAdminPresenter(UserAdminDataProvider userAdminDataProvider, NavigationManager navigationManager,
			UserService service) {
		super(navigationManager, service, User.class, userAdminDataProvider);
	}

	public String encodePassword(String value) {
		return getService().encodePassword(value);
	}

	@Override
	protected void editItem(User item) {
		super.editItem(item);
		getView().setPasswordRequired(item.isNew());
	}
}