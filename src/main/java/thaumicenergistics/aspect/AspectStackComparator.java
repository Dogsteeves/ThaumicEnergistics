package thaumicenergistics.aspect;

import java.util.Comparator;

/**
 * Compares one aspect stack against another.
 * 
 * @author Nividica
 * 
 */
public class AspectStackComparator
	implements Comparator<AspectStack>
{

	/**
	 * Modes of comparison
	 * 
	 * @author Nividica
	 * 
	 */
	public enum AspectStackComparatorMode
	{
			/**
			 * Compare based on name
			 */
			MODE_ALPHABETIC,

			/**
			 * Compare based on amount
			 */
			MODE_AMOUNT;

		/**
		 * Cache of the enum values
		 */
		public static final AspectStackComparatorMode[] VALUES = AspectStackComparatorMode.values();

		/**
		 * Returns the next mode of comparison.
		 * 
		 * @return
		 */
		public AspectStackComparatorMode nextMode()
		{
			return( VALUES[( this.ordinal() + 1 ) % VALUES.length] );
		}

		/**
		 * Returns the previous mode of comparison.
		 * 
		 * @return
		 */
		public AspectStackComparatorMode previousMode()
		{
			return( VALUES[( this.ordinal() + ( VALUES.length - 1 ) ) % VALUES.length] );
		}
	}

	/**
	 * The set mode of comparison
	 */
	private AspectStackComparatorMode mode;

	/**
	 * Creates the comparator with sorting mode alphabetic.
	 */
	public AspectStackComparator()
	{
		this.setMode( AspectStackComparatorMode.MODE_ALPHABETIC );
	}

	/**
	 * Creates the comparator with specified sorting mode.
	 * If the mode is unrecognized, the list will not be sorted.
	 * 
	 * @param mode
	 * Mode to sort by.
	 */
	public AspectStackComparator( final AspectStackComparatorMode mode )
	{
		this.setMode( mode );
	}

	/**
	 * Compares the two stacks by amount.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private int compareByAmount( final AspectStack left, final AspectStack right )
	{
		return (int)( right.stackSize - left.stackSize );
	}

	/**
	 * Compares the two stacks by name
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	private int compareByName( final AspectStack left, final AspectStack right )
	{
		return left.aspect.getName().compareTo( right.aspect.getName() );
	}

	/**
	 * Compares two aspect stacks by the selected mode.
	 */
	@Override
	public int compare( final AspectStack left, final AspectStack right )
	{
		switch ( this.mode )
		{
		case MODE_ALPHABETIC:
			// Compare tags
			return this.compareByName( left, right );

		case MODE_AMOUNT:
			// Compare amounts
			int comparedAmounts = this.compareByAmount( left, right );

			// Are the amounts equal?
			if( comparedAmounts == 0 )
			{
				// Compare tags
				comparedAmounts = this.compareByName( left, right );
			}

			return comparedAmounts;
		}

		return 0;
	}

	/**
	 * Sets the mode of comparison.
	 * 
	 * @param mode
	 */
	public void setMode( final AspectStackComparatorMode mode )
	{
		this.mode = mode;
	}

}
