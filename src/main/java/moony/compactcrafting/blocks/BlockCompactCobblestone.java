package moony.compactcrafting.blocks;

import java.util.Random;

import moony.compactcrafting.CCMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockCompactCobblestone extends Block {


public BlockCompactCobblestone(Material material) {
		super(material);
		this.setCreativeTab(CCMain.compactTab);
	}

@Override
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(CCMain.modid + ":" + "CompactCobblestone");
}


@Override
public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
	return Item.getItemFromBlock(Blocks.cobblestone);
}

@Override
public int quantityDropped(int meta, int fortune, Random random) {
	// TODO Auto-generated method stub
	return random.nextInt(10);
}


	

}