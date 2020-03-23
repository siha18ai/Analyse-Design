package com.gmail.simon.ui.views.admin.user;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.gmail.simon.ui.views.admin.RoleSelect;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class UserAdminViewDesign extends VerticalLayout {
	protected TextField search;
	protected Button add;
	protected Grid<com.gmail.simon.backend.data.entity.User> list;
	protected VerticalLayout form;
	protected TextField email;
	protected TextField name;
	protected TextField password;
	protected RoleSelect role;
	protected Button update;
	protected Button cancel;
	protected Button delete;

	public UserAdminViewDesign() {
		Design.read(this);
	}
}
