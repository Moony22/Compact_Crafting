package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemC2IronAxe extends ItemAxe {

	public ItemC2IronAxe(ToolMaterial enumToolMaterial) {
		super(enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);

	}
	
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
	    this.itemIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "C2IronAxe");
	}

}
