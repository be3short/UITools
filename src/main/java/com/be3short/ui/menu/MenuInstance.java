package com.be3short.ui.menu;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuInstance implements MenuDefinition
{

	private MenuDefinition[] subMenuItems;
	private String label;

	public MenuInstance(String label, MenuDefinition... sub_menus)
	{
		this.label = label;
		if (sub_menus.length > 0)
		{
			subMenuItems = sub_menus;
		}
	}

	@Override
	public String label()
	{
		return label;
	}

	@Override
	public MenuDefinition[] subMenuItems()
	{
		return subMenuItems;
	}

	public void addMenuDefinition(MenuDefinition... definitions)
	{
		ArrayList<MenuDefinition> newSubMenus = new ArrayList<MenuDefinition>(Arrays.asList(subMenuItems));
		newSubMenus.addAll(Arrays.asList(definitions));
		MenuDefinition[] newMenus = newSubMenus.toArray(new MenuDefinition[newSubMenus.size()]);
		subMenuItems = newMenus;

	}

}
