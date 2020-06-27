package glowredman.fpsp;

import glowredman.fpsp.block.BlockCorner;
import glowredman.fpsp.block.BlockStraight;
import net.minecraft.block.Block;

public class Reference {
	
	public static final String MCVERSION = "1.12.2";
	public static final String DEPENDENCIES = "required-after:ic2";
	public static final String MODID = "fpsp";
	public static final String MODNAME = "FPSP Core";
	public static final String MODVERSION = "${version}";
	
	public static final String COMMON = "glowredman.fpsp.proxy.CommonProxy";
	public static final String CLIENT = "glowredman.fpsp.proxy.ClientProxy";
	
	public static final Block CORNER = new BlockCorner();
	public static final Block STRAIGHT = new BlockStraight();

}