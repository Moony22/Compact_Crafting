package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemC1WoodenAxe extends ItemAxe
{

	public ItemC1WoodenAxe(ToolMaterial enumToolMaterial)
	{
		super(enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);

	}

	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "C1WoodenAxe");
	}
}
