package glowredman.fpsp.tile;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergyConductor;
import ic2.api.energy.tile.IEnergyEmitter;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.MinecraftForge;

public class TileCorner extends TileEntity implements IEnergyConductor, ITickable {
	
	private boolean loaded;
	
	public TileCorner() {
		this.loaded = false;
	}

	@Override
	public boolean acceptsEnergyFrom(IEnergyEmitter emitter, EnumFacing side) {
		return true;
	}

	@Override
	public boolean emitsEnergyTo(IEnergyAcceptor receiver, EnumFacing side) {
		return true;
	}

	@Override
	public double getConductionLoss() {
		return 0;
	}

	@Override
	public double getInsulationEnergyAbsorption() {
		return Double.MAX_VALUE - 65;
	}

	@Override
	public double getInsulationBreakdownEnergy() {
		return Double.MAX_VALUE;
	}

	@Override
	public double getConductorBreakdownEnergy() {
		return Double.MAX_VALUE;
	}

	@Override
	public void removeInsulation() {
	}

	@Override
	public void removeConductor() {
	}
	
	@Override
	public void invalidate() {
		super.invalidate();
		onChunkUnload();
	}
	
	@Override
	public void onChunkUnload() {
		super.onChunkUnload();
		if(loaded) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
			loaded = false;
		}
	}

	@Override
	public void update() {
		if(!loaded && !world.isRemote) {
			MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
			loaded = true;
		}
	}

}
