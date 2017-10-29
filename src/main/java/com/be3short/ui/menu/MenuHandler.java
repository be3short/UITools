package com.be3short.ui.menu;

public interface MenuHandler
{

	public MenuDefinition getMenu();

	public Object handleEvent(MenuDefinition event_id, Object... event_parameters);

	public Object[] getEventParameters(MenuDefinition definition);
}
