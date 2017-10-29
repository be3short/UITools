package com.be3short.ui.menu;

import java.util.Arrays;

/*
 * Generic definition of a menu to suite a variety of uses. Is used to generate a Java FX menu, providing a simple way
 * to identify and handle menu events.
 */
public interface MenuDefinition
{

	/*
	 * Label to be displayed for the menu item
	 */
	public String label();

	/*
	 * Sub menu item definitions of the current menu definition, if there are any
	 */
	public MenuDefinition[] subMenuItems();

	/*
	 * Determines if the menu has sub menu items
	 * 
	 * @param info - menu definition to be evaluated
	 * 
	 * @return true if menu definition has sub menu items, false otherwise
	 */
	public static boolean hasSubItems(MenuDefinition info)
	{
		Boolean hasSubItems = false;
		if (info.subMenuItems() != null)
		{
			if (info.subMenuItems().length > 0)
			{
				hasSubItems = true;
			}
		}
		return hasSubItems;
	}

	/*
	 * Determines if the menu has the specified sub menu item
	 * 
	 * @param info - menu definition to be checked
	 * 
	 * @param item - potential sub menu definition
	 * 
	 * @return true if menu definition has sub menu item, false otherwise
	 */
	public static boolean containsSubItem(MenuDefinition root, MenuDefinition item)
	{
		Boolean hasSubItem = false;
		if (root.subMenuItems() != null)
		{
			if (root.subMenuItems().length > 0)
			{
				for (MenuDefinition subItem : root.subMenuItems())
				{
					hasSubItem = hasSubItem || Arrays.asList(root.subMenuItems()).contains(item);
					hasSubItem = hasSubItem || MenuDefinition.containsSubItem(subItem, item);
				}

			}
		}
		return hasSubItem;
	}

}
