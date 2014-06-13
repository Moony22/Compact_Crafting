package moony.compactcrafting.items;

import moony.compactcrafting.CCMain;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class ItemC1IronPickaxe extends ItemPickaxe{

	public ItemC1IronPickaxe(int id, ToolMaterial enumToolMaterial) {
		super(enumToolMaterial);
		this.setCreativeTab(CreativeTabs.tabTools);		
	}
	
	public void updateIcons(IconRegister par1IconRegister)
	{
	    this.iconIndex = par1IconRegister.registerIcon(CCMain.modid + ":" + this.getUnlocalizedName());
	}
	


}