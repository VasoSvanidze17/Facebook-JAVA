import java.awt.Color;

/*
 * File: FacePamphletConstants.java
 * --------------------------------
 * This file declares several constants that are shared by the
 * different modules in the FacePamphlet application.  Any class
 * that implements this interface can use these constants.
 */

public interface Constants {

	/** The width of the application window */
	public static final int APPLICATION_WIDTH = 1300;

	/** The height of the application window */
	public static final int APPLICATION_HEIGHT = 750;
	
	
	public static final String EMPTY_LABEL_TEXT = " ";
	
	/** Number of characters for each of the text input fields */
	public static final int TEXT_FIELD_SIZE = 10;
	
	
	public static final String TEXT_ON_CENTER = "Dialog-24";
	
	public static final String INPUT_FIELD = "Dialog-16";
	
	public static final String BUTTON_TEXT = "Dialog-16-bold";
	
	//not used
	public static final String MESSAGE_FONT = "Dialog-18";
	
	
	//for login button color
	public static final Color LOGIN_FIRST_COLOR = new Color(24, 119, 242);
	
	public static final Color LOGIN_EFECT_COLOR = new Color(19, 93, 189);
	
	public static final Color LOGIN_CLICK_EFECT_COLOR = new Color(66, 183, 42);
	
	//for create new button color
	public static final Color CREATE_FIRST_COLOR = new Color(66, 183, 42);
	
	public static final Color CREATE_EFECT_COLOR = new Color(46, 140, 27);
	
	public static final Color CREATE_CLICK_EFECT_COLOR = new Color(24, 119, 242);
	
	
	public static final int PAUSE_FOR_CLICK = 300;
	
	
	public static final String REGISTRATION_PAGE = "Registration";
	
	public static final String HOME_PAGE = "Home";
	
	public static final String PROFILE_PAGE = "Profile";
	
	public static final String SEARCHED_PROFILE_PAGE = "Searched Profile";
	
	//size
	public static final int LEFT_MARGIN = 20;
	
	public static final int TOP_MARGIN = 80;
	
	public static final int ABOUT_OFFSET = 50;
	
	/** The width (in pixels) that profile images should be displayed */
	public static final double IMAGE_WIDTH = 170;

	/** The height (in pixels) that profile images should be displayed */
	public static final double IMAGE_HEIGHT = 170;	
	
	public static final double MESSAGE_REXT_Y = 40;
}

