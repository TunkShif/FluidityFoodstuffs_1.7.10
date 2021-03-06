package defeatedcrow.addonforamt.fluidity.common;

import java.util.ArrayList;

import net.minecraft.util.MathHelper;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class FFConfig {
	
	private FFConfig(){}
	
	public static String[] saltList = {"salt", "Salt", "cookingSalt", "dustSalt", "foodSalt"};
	public static String[] sugarList = {"sugar", "Sugar", "cookingSugar", "dustSugar", "foodSugar"};
	public static String[] milkList = {"milk", "listAllmilk", "bucketMilk", "cookingMilk", "milkBucket", "foodMilk"};
	public static String[] flourList = {"flour", "Flour", "foodFlour", "cookingFlour", "dustFlour", "dustWheat"};
	public static String[] wheatList = {"wheat", "Wheat", "cropWheat", "foodWheat"};
	public static String[] riceList = {"rice", "Rice", "cropRice", "foodRice"};
	public static String[] seedList = {"seedWheat", "cropSeed", "foodSeed"};
	public static String[] waterList = {"water", "bucketWater", "waterBucket", "foodWater", "fluidWater"};
	
	public static float IBCalpha = 0.8F;
	
	public static int sizeIBC = 1024000;
	public static int sizeFluidHopper = 80000;
	public static int sizeAdvHopper = 80000;
	
	public static int flowRateBase = 100;
	public static int flowRateAdv = 400;
	
	private final String BR = System.getProperty("line.separator");
	
	public static void config(Configuration cfg)
	{
		
		try
		{
			cfg.load();
			
			cfg.setCategoryComment("oredictionary", "Add OreDictionary name into the integration list.");
			
			cfg.setCategoryComment("device setting", "Setting for fluid devices.");
			
			Property saltListP = cfg.get("oredictionary", "Salt", saltList);
			Property sugarListP = cfg.get("oredictionary", "Sugar", sugarList);
			Property milkListP = cfg.get("oredictionary", "Milk", milkList);
			Property flourListP = cfg.get("oredictionary", "Flour", flourList);
			Property wheatListP = cfg.get("oredictionary", "Wheat", wheatList);
			Property riceListP = cfg.get("oredictionary", "Rice", riceList);
			Property seedListP = cfg.get("oredictionary", "Seed", seedList);
			Property waterListP = cfg.get("oredictionary", "Water", waterList);
			
			Property ibca = cfg.get("render setting", "IBC_alpha", IBCalpha);
			
			Property sizeI = cfg.get("device setting", "IBC_TankSize", sizeIBC, 
					"The tank size of the IBC. 1,000 - 1024,000 mB.");
			
			Property sizeH = cfg.get("device setting", "FluidHopper_TankSize", sizeFluidHopper, 
					"The tank size of the Fluid Hopper. 1,000 - 512,000 mB.");
			
			Property sizeAdvH = cfg.get("device setting", "SolenoidValveHopper_TankSize", sizeAdvHopper, 
					"The tank size of the Solenoid Valve Hopper. 1,000 - 512,000 mB.");
			
			Property rateH = cfg.get("device setting", "FluidHopper_FlowRateBase", flowRateBase, 
					"The minimum flow rate of the Fluid Hopper. 10 - 10,000 mB.");
			
			Property rateAdvH = cfg.get("device setting", "SolenoidValveHopper_FlowRate", flowRateAdv, 
					"The max flow rate of the Solenoid Valve Hopper. 10 - 10,000 mB.");
			
			saltList = saltListP.getStringList();
			sugarList = sugarListP.getStringList();
			milkList = milkListP.getStringList();
			flourList = flourListP.getStringList();
			wheatList = wheatListP.getStringList();
			riceList = riceListP.getStringList();
			seedList = seedListP.getStringList();
			waterList = waterListP.getStringList();
			
			IBCalpha = MathHelper.clamp_float((float) ibca.getDouble(), 0.0F, 1.0F);
			
			sizeIBC = MathHelper.clamp_int(sizeI.getInt(), 1000, 1024000);
			sizeFluidHopper = MathHelper.clamp_int(sizeH.getInt(), 1000, 512000);
			sizeAdvHopper = MathHelper.clamp_int(sizeAdvH.getInt(), 1000, 512000);
			flowRateBase = MathHelper.clamp_int(rateH.getInt(), 10, 10000);
			flowRateAdv = MathHelper.clamp_int(rateAdvH.getInt(), 10, 10000);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cfg.save();
		}
	}

}
