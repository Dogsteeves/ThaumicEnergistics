package thaumicenergistics.registries;

import thaumicenergistics.render.RenderBlockEssentiaProvider;
import thaumicenergistics.render.RenderBlockInfusionProvider;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renderers
{
	public static final int PASS_OPAQUE = 0;
	public static final int PASS_ALPHA = 1;
	
	public static int currentRenderPass = 0;
	
	public static int EssentiaProviderRenderID;
	
	public static int InfusionProviderRenderID;
	
	public static void registerRenderers()
	{
		// Get the next render ID
		Renderers.EssentiaProviderRenderID = RenderingRegistry.getNextAvailableRenderId();
		// Register the essentia provider renderer
		RenderingRegistry.registerBlockHandler( new RenderBlockEssentiaProvider() );
		
		// Get the next render ID
		Renderers.InfusionProviderRenderID = RenderingRegistry.getNextAvailableRenderId();
		// Register the infusion provider renderer
		RenderingRegistry.registerBlockHandler( new RenderBlockInfusionProvider() );
	}
}
