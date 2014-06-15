package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemC1IronPickaxe extends ItemPickaxe{

	public ItemC1IronPickaxe(ToolMaterial enumToolMaterial) {
		super(enumToolMaterial);
		this.setCreativeTab(CCMain.compactTab);	
	}
	
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "C1IronPickaxe");
	}
	
}
