import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.graphics.GRoundRect;
import acm.program.GraphicsProgram;
import acmx.export.javax.swing.JCheckBox;
import acmx.export.javax.swing.JPanel;

public class MainClass extends GraphicsProgram implements Constants{
	
	public void init() {
		addWestComponents(); //add WEST panel
		addNorthComponents(); //add North panel
		addSouthComponents(); //add south panel
		
		addActionListeners();
		addMouseListeners();
		
		//initialize  
		page = "";
		messagingProfile = "";
		update = "";
		profile = null;
		searchedProfile = null;
		profileDataBase = new ProfileDataBase();
		
		this.setBackground(new Color(240, 242, 245));
	}
	
	public void run() {
		while(true) {
			removeAll();
			drawhomePageInterface(); //this method end when user click log in button
			
			drawWholeProfile(); //this method end when user log out from profile
		}
	}
	
	
	//west panel
	
	//add west layout
	private void addWestComponents() {
		JLabel label = new JLabel("C R E A T I N G   AN   A C C O U N T                  "); //header of west panel
		add(label, WEST);
		addEmptySpaceOnWest(5, WEST); //add 5 empty label on west panel
		
		addCreateLoginTextField(); //add login field west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addCreatePasswordTextField(); //add password field west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addCreateNameTextField(); //add name field west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addCreateLastNameTextField(); //add last name field west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addGenderComboBox(); //add gender combo box west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addBirthdayComboBoxes(); //add birthday combo boxes west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addCheckBox(); //add check box west panel
		addEmptySpaceOnWest(3, WEST); //add 3 empty label on west panel
		
		addSignUpButton();
	}
	
	//add empty spaces between components spaces on west panel
	private void addEmptySpaceOnWest(int space, Object constrains) {
		for(int i = 0; i < space; i++) {
			JLabel emptyLabel = new JLabel("");
			add(emptyLabel, constrains);
		}
	}
	
	//add login field and label on west panel
	private void addCreateLoginTextField() {
		JLabel label = new JLabel("LOGIN"); //header of field
		add(label, WEST);
		
		createLoginField = new JTextField();
		add(createLoginField, WEST);
	}
	
	//add password field and label on west panel
	private void addCreatePasswordTextField() {
		JLabel label = new JLabel("PASSWORD"); //header of field
		add(label, WEST);
		
		createPasswordField = new JTextField();
		add(createPasswordField, WEST);
	}
	
	//add name of profile field with label
	private void addCreateNameTextField() {
		JLabel label = new JLabel("FIRST  NAME"); //header of field
		add(label, WEST);
		
		createNameField = new JTextField();
		add(createNameField, WEST);
	}
	
	//add last name of profile field with label
	private void addCreateLastNameTextField() {
		JLabel label = new JLabel("LAST  NAME"); //header of field
		add(label, WEST);
		
		createLastNameField = new JTextField();
		add(createLastNameField, WEST);
	}
	
	//add gender field with label
	private void addGenderComboBox() { 
		JLabel label = new JLabel("GENDER"); //header of box
		add(label, WEST);
		
		genderBox = new JComboBox();
		genderBox.setEditable(false);
		add(genderBox, WEST);
		
		//add item in gender combo box
		genderBox.addItem("Empty");
		genderBox.addItem("Male");
		genderBox.addItem("Female");
		genderBox.addItem("Other");
	}
	
	//add birthday field with labels
	private void addBirthdayComboBoxes() {
		JLabel label = new JLabel("                           BIRTHDAY"); //header of combo boxes
		add(label, WEST);
		
		addDayComboBox();
		addMonthComboBox();
		addYearComboBox();
	}
	
	private void addDayComboBox() {
		JLabel label = new JLabel("DAY"); //header of  combo box
		add(label, WEST);
		
		birthdayBox = new JComboBox();
		birthdayBox.setEditable(false);
		add(birthdayBox, WEST);
		
		birthdayBox.addItem("Empty"); //first item is empty
		
		for(int i = 1; i <= 31; i++) {
			birthdayBox.addItem(i);
		}
	}
	
	private void addMonthComboBox() {
		JLabel label = new JLabel("MONTH");  //header of  combo box
		add(label, WEST);
		
		birthMonthBox = new JComboBox();
		birthMonthBox.setEditable(false);
		add(birthMonthBox, WEST);
		
		birthMonthBox.addItem("Empty"); //first item is empty
		birthMonthBox.addItem("January");
		birthMonthBox.addItem("February");
		birthMonthBox.addItem("March");
		birthMonthBox.addItem("April");
		birthMonthBox.addItem("May");
		birthMonthBox.addItem("June");		
		birthMonthBox.addItem("July");
		birthMonthBox.addItem("August");
		birthMonthBox.addItem("September");
		birthMonthBox.addItem("October");
		birthMonthBox.addItem("November");
		birthMonthBox.addItem("December");
	}
	
	private void addYearComboBox() {
		JLabel label = new JLabel("YEAR"); //header of  combo box
		add(label, WEST);
		
		birthYearBox = new JComboBox();
		birthYearBox.setEditable(false);
		add(birthYearBox, WEST);
		
		birthYearBox.addItem("Empty");//first item is empty
		
		for(int i = 2021; i >= 1905; i--) {
			birthYearBox.addItem(i);
		}
	}
	
	//add check box on west, for checking
	private void addCheckBox() {
		JLabel label = new JLabel("CHECKING"); //header of check box
		add(label, WEST);
		
		robotCheckBox = new JCheckBox("I'M NOT ROBOT");
		add(robotCheckBox, WEST);
	}
	
	//add sing up button on west
	private void addSignUpButton() {
		signUpButton = new JButton("Sign Up");
		add(signUpButton, WEST);
	}
		
	
	
	//north panel
	
	//add North layout
	private void addNorthComponents() {
		addEmptySpaceOnNorth(40); //add empty between components spaces
		
		
		addSearchProfileField(); //add search profile text field on north
		addSearchProfileButton(); //add search profile button on north
		addEmptySpaceOnNorth(5); //empty JLabel between components spaces on north
		addReturnButton();
		addLogOutButton(); //add log out profile button
		addEmptySpaceOnNorth(30); //empty JLabel between components spaces on north
		
		addLoginField(); //add login field on north
		addPasswordTextField(); //add password field on north
		addLogInButton(); //add login button 
	}
	
	//add empty spaces between components
	private void addEmptySpaceOnNorth(int spaces) {
		String empty = ""; //create empty String for label
		
		for(int i = 0; i < spaces; i++) { 
			empty += EMPTY_LABEL_TEXT;
		}
		
		JLabel emptyLabel = new JLabel(empty);
		add(emptyLabel, NORTH);
	}
	
	//add search profile field
	private void addSearchProfileField() {
		JLabel label = new JLabel("SEARCH  PROFILE"); //header
		add(label, NORTH);
		
		searchProfileField = new JTextField(2 * TEXT_FIELD_SIZE);
		searchProfileField.addActionListener(this);
		add(searchProfileField, NORTH);
	}
	
	//add search profile button
	private void addSearchProfileButton() {
		searchProfileButton = new JButton("Search"); 
		add(searchProfileButton, NORTH);
	}
	
	private void addReturnButton() {
		returnMyPage = new JButton("Return My Page");
		add(returnMyPage, NORTH);
	}
	
	//add login text field
	private void  addLoginField() {
		JLabel label = new JLabel("LOGIN"); //header
		add(label, NORTH);
		
		enterLoginField = new JTextField(TEXT_FIELD_SIZE);
		add(enterLoginField, NORTH);
	}
	
	//add enter password field
	private void addPasswordTextField() {
		JLabel label = new JLabel("PASSWORD"); //header
		add(label, NORTH);
		
		enterPasswordField = new JTextField(TEXT_FIELD_SIZE);
		add(enterPasswordField, NORTH);
	}
	
	//add login button
	private void addLogInButton() {
		enterButton = new JButton("Enter");
		add(enterButton, NORTH);
	}
	
	//add log out button
	private void addLogOutButton() {
		logOutButton = new JButton("Log Out");
		add(logOutButton, NORTH);
	}

	
	
	//south panel
	
	//add south panel
	private void addSouthComponents() {
		addEmptySpaceOnSouth(70); //add empty space for more symmetry
		
		addStatusTextField();
		addImageTextField();

		addEmptySpaceOnSouth(20); //add empty space for more symmetry
		addSendMessageTextField(); //add message field
		addFriendNameTextField();
		addSendMessageButton();
	}
	
	//add empty spaces between components
	private void addEmptySpaceOnSouth(int spaces) {
		String empty = ""; //create empty label
		
		for(int i = 0; i < spaces; i++) { //empty is white space i-times
			empty += EMPTY_LABEL_TEXT;
		}
		
		JLabel emptyLabel = new JLabel(empty);
		add(emptyLabel, SOUTH);
	}
	
	private void addStatusTextField() {
		JLabel label = new JLabel("Set Status");
		add(label, SOUTH);
		
		statusTextField = new JTextField(TEXT_FIELD_SIZE * 3/2);
		statusTextField.addActionListener(this);
		add(statusTextField, SOUTH);
	}
	
	private void addImageTextField() {
		JLabel label = new JLabel("Set Image");
		add(label, SOUTH);
		
		imageTextField = new JTextField(TEXT_FIELD_SIZE * 3/2);
		imageTextField.addActionListener(this);
		add(imageTextField, SOUTH);
	}
	
	//add send message text field
	private void addSendMessageTextField() {
		JLabel label = new JLabel("MESSAGE"); //header
		add(label, SOUTH);
		
		sendMessageField = new JTextField(2 * TEXT_FIELD_SIZE);
		sendMessageField.addActionListener(this);
		add(sendMessageField, SOUTH);
	}
	
	private void addFriendNameTextField() {
		JLabel label = new JLabel("TO NAME"); //header
		add(label, SOUTH);
		
		friendNameField = new JTextField(TEXT_FIELD_SIZE);
		friendNameField.addActionListener(this);
		add(friendNameField, SOUTH);
	}
	
	private void addSendMessageButton() {
		sendMessageButton = new JButton("SEND");
		add(sendMessageButton, SOUTH);
	}
	
	//actionPerformed method
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUpButton) {
			trySignUp();
		}else if(e.getSource() == enterButton) {
			tryEnterLoginAndPasswordInrelevantField(); //graphical method
		}else if(e.getSource() == searchProfileField || e.getSource() == searchProfileButton) {
			trySearchProfileInDataBaseWithName(searchProfileField.getText());
			searchProfileField.setText("");
		}else if(e.getSource() == logOutButton) {
			tryLogOutProfile();
		}else if(e.getSource() == returnMyPage) {
			tryReturnProfilePage();
		}else if(e.getSource() == statusTextField) {
			trySetStatus();
			statusTextField.setText("");
		}else if(e.getSource() == imageTextField) {
			trySetProfileImage();
			imageTextField.setText("");
		}else if(e.getSource() == sendMessageButton || e.getSource() == friendNameField || e.getSource() == sendMessageField) {
			trySendMessage();
		}
	}
		
	
	//methods for action performed
	
	//for sign up button
	private void trySignUp() {
		if(page.equals(REGISTRATION_PAGE)) { //if user want to use left layout then he/she must enter registration page
			if(conditionOfSignUp()) {
				if(!profileDataBase.containsProfileWithLogin(createLoginField.getText())) {//if this profile doesn't exist
					createNewProfile();
					setAgainOnWestField(); //set empty String all field again

					shawMessage.setLabel("Register successfully");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}else {
					shawMessage.setLabel("A profile with this login already exists");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}
			}else {
				shawMessage.setLabel("Fill in all the registration fields and then click on 'Sign Up'");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			shawMessage.setLabel("You aren't on registration page Click 'Create New Account' and go to registration page");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	//condition of sign up button
	private boolean conditionOfSignUp() {
		if(!createLoginField.getText().equals("") && !createPasswordField.equals("") && !createNameField.equals("")
				&& !createLastNameField.equals("") && !genderBox.getSelectedItem().equals("Empty")
				 && !birthdayBox.getSelectedItem().equals("Empty") && !birthMonthBox.getSelectedItem().equals("Empty")
				 && !birthYearBox.getSelectedItem().equals("Empty") && robotCheckBox.isSelected()) {
			
			return true;
		}else {
			return false;
		}
	}
	
	private void createNewProfile() {
		Profile newProfile = new Profile(createLoginField.getText());
		
		newProfile.setPassword(createPasswordField.getText());
		newProfile.setName(createNameField.getText());
		newProfile.setLastName(createLastNameField.getText());
		newProfile.setBirthday(birthdayBox.getSelectedItem().toString(), 
				birthMonthBox.getSelectedItem().toString(), birthYearBox.getSelectedItem().toString());
		newProfile.setGender(genderBox.getSelectedItem().toString());
		
		profileDataBase.addProfile(newProfile);
	}
	
	private void setAgainOnWestField() {
		//for text field
		createLoginField.setText("");
		createPasswordField.setText("");
		createNameField.setText("");
		createLastNameField.setText("");
		
		//for combo box
		genderBox.setSelectedIndex(0);
		birthdayBox.setSelectedIndex(0);
		birthMonthBox.setSelectedIndex(0);
		birthYearBox.setSelectedIndex(0);
		robotCheckBox.setSelected(false);
	}
	
	private void trySearchProfileInDataBaseWithName(String name) {
		if(profile != null) {
			if(conditionOfSearchProfileField()) {
				if(isProfileDataBaseWithThisName(name)) {
					if(profile != profileDataBase.getProfileWithName(name)) {
						searchedProfile = profileDataBase.getProfileWithName(searchProfileField.getText());
						page = SEARCHED_PROFILE_PAGE;
						searchProfileField.setText("");
						shawMessage.setLabel("Profile searched");
						add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
					}else {
						shawMessage.setLabel("You can not find your own profile when you are in the same profile");
						add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
					}
				}else {
					shawMessage.setLabel("Profile with this name doesn't exist");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}
			}else {
				shawMessage.setLabel("Please Enter Profile Name in profile search text field");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			shawMessage.setLabel("A profile can only be found when you are in your profile");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	private boolean conditionOfSearchProfileField() {
		if(!searchProfileField.getText().equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isProfileDataBaseWithThisName(String name) {
		return profileDataBase.containsProfileWithName(name);
	}
	
	private void tryEnterLoginAndPasswordInrelevantField() {
		if(page == HOME_PAGE) {
			if(conditionOfLoginAndPasswordTextField()) {
					enterInputedLoginAndPasswordTextField();
			}else {
				enterLoginField.setText("");
				enterPasswordField.setText("");
				shawMessage.setLabel("Please enter login and password in text field");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			enterLoginField.setText("");
			enterPasswordField.setText("");
			shawMessage.setLabel("You aren't Authorization Page");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	private boolean conditionOfLoginAndPasswordTextField() {
		if(enterLoginField.getText().equals("") || enterPasswordField.getText().equals("")) {
			return false;
		}else{
			return true;
		}
	}
	
	private void enterInputedLoginAndPasswordTextField() {
		//for login
		GLabel login = new GLabel(enterLoginField.getText());
		login.setFont(MESSAGE_FONT);
		login.setColor(Color.BLACK);
		add(login, getWidth()/2 + getWidth()/8 + 122, getHeight()/2 - 160 + login.getHeight()/2);
		
		//for password
		GLabel password = new GLabel(enterPasswordField.getText());
		password.setFont(MESSAGE_FONT);
		password.setColor(Color.BLACK);
		add(password, getWidth()/2 + getWidth()/8 + 115, getHeight()/2 - 90 + password.getHeight()/2);
	}
	
	private void tryLogOutProfile() {
		if(profile != null) {
			page = HOME_PAGE;
			profile = null;
			searchedProfile = null;
		}else {
			shawMessage.setLabel("You must enter to the profile before clicking log out");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}

	private void tryReturnProfilePage() {
		if(profile != null) {
			if(searchedProfile != null) {
				searchedProfile = null;
				page = PROFILE_PAGE;
				shawMessage.setLabel("Returning to the page");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				pause(PAUSE_FOR_CLICK);
			}else {
				shawMessage.setLabel("You are on your page");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			shawMessage.setLabel("You are not logged in profile");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	private void trySetStatus() {
		if(profile != null) {
			if(searchedProfile == null) {
				profile.setStatus(statusTextField.getText());
				shawMessage.setLabel("The status has changed");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				update = "The status has changed";
			}else {
				shawMessage.setLabel("You aren't on your page");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			shawMessage.setLabel("You aren't on your page");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	private void trySetProfileImage() {
		if(profile != null) {
			if(searchedProfile == null) {
				try {
					GImage profileImage = new GImage(imageTextField.getText());
					profile.setImage(profileImage);		
					shawMessage.setLabel("The Image has changed");
					update = "The Image has changed";
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}catch(Exception e) {
					shawMessage.setLabel("An image with this name does not exist");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}
			}else {
				shawMessage.setLabel("You aren't on your page");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			}
		}else {
			shawMessage.setLabel("You aren't on your page");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	private void trySendMessage() {
		if(profile != null) {
			if(sendMessageField.getText().equals("") || friendNameField.getText().equals("")) {
				if(sendMessageField.getText().equals("")) {
					shawMessage.setLabel("MESSAGE text field is empty");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}else {
					shawMessage.setLabel("TO NAME text field ise empty");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				}
			}else {
				if(profile.isFriend(friendNameField.getText())) {
					profile.sendMessageToFriend(sendMessageField.getText(), friendNameField.getText());
					profileDataBase.getProfileWithName(friendNameField.getText()).receiveMessage(sendMessageField.getText(), 
							profile.getName());
					shawMessage.setLabel("Message is sent");
					update = "Message is sent";
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
					messagingProfile = friendNameField.getText();
					sendMessageField.setText("");
				}else {
					shawMessage.setLabel(friendNameField.getText() + " isn't your friend");
					add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
					friendNameField.setText("");
				}
			}
		}else {
			shawMessage.setLabel("You aren't on your profile page");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			sendMessageField.setText("");
			friendNameField.setText("");
		}
	}
	
	
	
	//graphic code
		//before user enter profile
	//draw home interface
	private void drawhomePageInterface() {
		while(true) { 
			removeAll();
			page = HOME_PAGE;
			profile = null;
			searchedProfile = null;
			drawPageInterface();
			

			//wait click of user on login or create new acc button 
			while(loginRectButton.getColor() != LOGIN_CLICK_EFECT_COLOR  && createNewAccRectButton.getColor() != CREATE_CLICK_EFECT_COLOR) {
				
			}
						
			
			if(createNewAccRectButton.getColor() == CREATE_CLICK_EFECT_COLOR) { //if user click create
				page = REGISTRATION_PAGE;
				profile = null;
				searchedProfile = null;
				
				pause(PAUSE_FOR_CLICK); //pause for click
				createNewAccRectButton.setColor(CREATE_FIRST_COLOR);
				drawCreateNewAccountOption();
			}else if(tryEnterAccount(enterLoginField.getText(), enterPasswordField.getText())){
				page = PROFILE_PAGE;
				profile = profileDataBase.getProfileWithLogin(enterLoginField.getText());
				searchedProfile = null;
			
				pause(PAUSE_FOR_CLICK);//pause for click
				
				enterLoginField.setText("");
				enterPasswordField.setText("");
				break;
			}else {
				enterLoginField.setText("");
				enterPasswordField.setText("");
				pause(3 * PAUSE_FOR_CLICK);//pause for click
			}
		}
		
		loginRectButton.setColor(LOGIN_FIRST_COLOR); //set login rect colour again blue;
		pause(2 * PAUSE_FOR_CLICK);//pause for click
		
	}
	
	//draw home interface
	private void drawPageInterface() {
		drawFacebookBluePanel();
		drawFacebookLabelAndText();
		
		drawWhiteRect();
	}
	
	//add blue panel on top
	private void drawFacebookBluePanel() {
		//blue background
		GRect rect = new GRect(0, 0, getWidth(), getHeight()/17);
		rect.setFilled(true);
		rect.setColor(new Color(24, 119, 242));
		add(rect);
		
		//facebook label
		GLabel fbLabel = new GLabel("facebook");
		fbLabel.setFont("SenSerif-Bold-30");
		fbLabel.setColor(Color.WHITE);
		add(fbLabel, 50, fbLabel.getAscent() + 2);
		
		//facebook logo
		GRoundRect fbLogo = new GRoundRect(10, rect.getHeight()/2 - 30/2, 30, 30, 15);
		fbLogo.setColor(Color.WHITE);
		fbLogo.setFilled(true);
		fbLogo.setFillColor(Color.WHITE);
		add(fbLogo);
		
		//F Label
		GLabel fLabel = new GLabel("f");
		fLabel.setFont("SenSerif-Bold-30");
		fLabel.setColor(new Color(24, 119, 242));
		add(fLabel, 22 - fLabel.getWidth()/2, rect.getHeight()/2 - 30/2 + fLabel.getAscent());
	}
	
	private void drawFacebookLabelAndText() {
		drawBottomMessegeLabel();
		
		//facebook label
		GLabel fbLabel = new GLabel("facebook");
		fbLabel.setFont("SenSerif-Bold-60");
		fbLabel.setColor(new Color(24, 119, 242));
		add(fbLabel, getWidth()/4 - fbLabel.getWidth()/2, getHeight()/4 + fbLabel.getAscent());
		
		//just for text 
		GLabel label = new GLabel("Connect with friends and the world");
		label.setColor(Color.BLACK);
		label.setFont(TEXT_ON_CENTER);
		add(label, getWidth()/4 - fbLabel.getWidth()/2, fbLabel.getY() + 30);
		
		//just for text 
		GLabel label1 = new GLabel("around you on Facebook");
		label1.setColor(Color.BLACK);
		label1.setFont(TEXT_ON_CENTER);
		add(label1, getWidth()/4 - fbLabel.getWidth()/2, label.getY() + label1.getAscent());
		
		//just for text 
		GLabel label2 = new GLabel("");
		label2.setColor(Color.BLACK);
		label2.setFont(TEXT_ON_CENTER);
		add(label2, getWidth()/4 - label2.getWidth()/2, label1.getY() + label2.getAscent() + 100);
	}
	
	private void drawBottomMessegeLabel() {
		//for bottom messages
		shawMessage = new GLabel("Home Page");
		shawMessage.setFont("SenSerif-Bold-25");
		shawMessage.setColor(new Color(24, 119, 242));
		add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
	}
	
	private void drawWhiteRect() {
		whitheRect();
		
		drawloginFieldOnwhiteRect();
		drawpasswordFieldOnwhiteRect();
		
		drawLogInButton();
		drawCreateButton();
	}
	
	private void whitheRect() {
		GRoundRect whiteRect = new GRoundRect(getWidth()/2 + getWidth()/8, getHeight()/2 - 200, 350, 400, 15);
		whiteRect.setFilled(true);
		whiteRect.setFillColor(Color.WHITE);
		add(whiteRect);
	}
	
	private void drawloginFieldOnwhiteRect() {
		GRoundRect loginRect = new GRoundRect(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 - 200 + 20, 300, 50, 15);
		loginRect.setColor(new Color(221, 223, 226));
		add(loginRect);
		
		//String in login field
		GLabel label = new GLabel("Enter Login:");
		label.setFont(INPUT_FIELD);
		label.setColor(Color.GRAY);
		add(label, loginRect.getX() + 10, loginRect.getY() + 25 + label.getAscent()/2);
	}

	private void drawpasswordFieldOnwhiteRect() {
		GRoundRect passwordRect = new GRoundRect(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 - 150 + 40, 300, 50, 15);
		passwordRect.setColor(new Color(221, 223, 226));
		add(passwordRect);
		
		//string in password field
		GLabel label = new GLabel("Password:");
		label.setFont(INPUT_FIELD);
		label.setColor(Color.GRAY);
		add(label, passwordRect.getX() + 10, passwordRect.getY() + 25 + label.getAscent()/2);
		
		//only horizontal line
		GLine line = new GLine(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 + 50, getWidth()/2 + getWidth()/8 + 325, getHeight()/2 + 50);
		line.setColor(new Color(221, 223, 226));
		add(line);
	}
	
	private void drawLogInButton() {
		loginRectButton = new GRoundRect(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 - 100 + 60, 300, 50, 15);
		loginLabelButton = new GLabel("Log In");
		
		loginRectButton.setFilled(true);
		loginRectButton.setColor(LOGIN_FIRST_COLOR);
		
		loginLabelButton.setColor(Color.WHITE);
		loginLabelButton.setFont(BUTTON_TEXT);
		
		add(loginRectButton);
		add(loginLabelButton, getWidth()/2 + getWidth()/8 + 25 + (300 - loginLabelButton.getWidth())/2, 
				getHeight()/2 - 100 + 60 + 50/2 + loginLabelButton.getAscent()/2 - 2);
		
	}

	private void drawCreateButton() {
		createNewAccRectButton = new GRoundRect(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 + 100, 300, 50, 15);
		createNewAccLabelButton = new GLabel("Create New Account");
		
		createNewAccRectButton.setFilled(true);
		createNewAccRectButton.setColor(CREATE_FIRST_COLOR);
		
		createNewAccLabelButton.setColor(Color.WHITE);
		createNewAccLabelButton.setFont(BUTTON_TEXT);
		
		add(createNewAccRectButton);
		add(createNewAccLabelButton, getWidth()/2 + getWidth()/8 + 25 + (300 - createNewAccLabelButton.getWidth())/2, 
				getHeight()/2 + 100 + 50/2 + createNewAccLabelButton.getAscent()/2 - 2);
	}
		
	private void drawCreateNewAccountOption() {
		removeAll();
		
		shawMessage.setLabel("Registration Page");
		add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		drawFacebookBluePanel();
		
		drawTextOnWindos();
		drawHomePageButton();
		
		while(homePageRectButton.getColor() != CREATE_CLICK_EFECT_COLOR) {
			
		}
		//pause for click
		pause(PAUSE_FOR_CLICK);
	}
	
	private void drawTextOnWindos() {
		//messages for user
		GLabel label = new GLabel("You are on the registration page");
		label.setFont("SenSerif-Bold-40");
		label.setColor(new Color(24, 119, 242));
		add(label, getWidth()/2 - label.getWidth()/2, getHeight()/2 - getHeight()/3);
		
		//next messages
		GLabel label1  = new GLabel("You can register your profile with the help of the left layout");
		label1.setFont(TEXT_ON_CENTER);
		label1.setColor(Color.BLACK);
		add(label1, getWidth()/2 - label1.getWidth()/2, getHeight()/2 - getHeight()/6);
		
		//next messages
		GLabel label2  = new GLabel("After registration you must return to the home page and log in with an already registered profile");
		label2.setFont(TEXT_ON_CENTER);
		label2.setColor(Color.BLACK);
		add(label2, getWidth()/2 - label2.getWidth()/2, getHeight()/2);
		
		//next messages
		GLabel label3  = new GLabel("Click the button to return to the home page");
		label3.setFont(TEXT_ON_CENTER);
		label3.setColor(Color.BLACK);
		add(label3, getWidth()/2 - label3.getWidth()/2, getHeight()/2 + getHeight()/7);
	}

	private void drawHomePageButton() {
		homePageRectButton = new GRoundRect(250, 50);
		homePageLabelButton = new GLabel("Return Home Page");
		
		homePageRectButton.setFilled(true);
		homePageRectButton.setColor(CREATE_FIRST_COLOR);
		
		homePageLabelButton.setColor(Color.WHITE);
		homePageLabelButton.setFont(BUTTON_TEXT);
		
		add(homePageRectButton, getWidth()/2 - homePageRectButton.getWidth()/2, getHeight()/2 + getHeight()/4);
		add(homePageLabelButton, getWidth()/2 - homePageLabelButton.getWidth()/2, 
				getHeight()/2 + getHeight()/4 + 50 - (50 -homePageLabelButton.getAscent())/2);
	}
	
	private boolean tryEnterAccount(String login, String password) {
		if(profileDataBase.containsProfileWithLogin(login)) {
			if(profileDataBase.getProfileWithLogin(login).isCorrectPassword(password)) {
				shawMessage.setLabel("Enter in profile successful");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				return true;
			}else {
				shawMessage.setLabel("Password is incorretc");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				return false;
			}
		}else {
			shawMessage.setLabel("Profile with this login doesn't exist");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
			return false;
		}
	}

	
	
	
		//enter profile
	
	//draw only about profile
	private void drawWholeProfile() {
		while(profile != null) {
			removeAll();
			page = PROFILE_PAGE;
			searchedProfile = null;
			
			//draw first time
			drawAboutProfile();
			drawNewsFeedPanel();
			drawChatPanel();
			
			while(profile != null && searchedProfile == null) { //this loop end when user click log out or exit profile page
				if(updateCondition()) {
					//update
					removeAll();
					drawAboutProfile();
					drawNewsFeedPanel();
					drawChatPanel();
					update = "";
				}
			}
			
			if(profile != null) {
				drawSearchedProfile();
			}else {
				shawMessage.setLabel("Log Out");
				add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
				pause(3 * PAUSE_FOR_CLICK);
			}
		}
		
		messagingProfile = "";
	}	
	
	private void drawAboutProfile() {
		drawProfileBackground();
		drawFacebookBluePanel(); //add blue panel again
		drawProfileImage(profile.getImage());
		
		drawProfileInfo();
	}
	
	//profile background	
	private void drawProfileBackground() {
		GImage background = new GImage("profileBackground.jpg");
		background.setSize(getWidth()/3, getHeight() + 40);
		add(background, 0, 0);
		
		//cover
		GImage cover = new GImage("coverBackground.jpg");
		cover.setSize(getWidth()/3, TOP_MARGIN + 2 * IMAGE_HEIGHT/3.0 - getHeight()/17);
		add(cover, 0, getHeight()/17);
	}

	private void drawProfileImage(GImage image) {
		if(image != null) {
			image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(image, getWidth()/3 - getWidth()/8 - IMAGE_WIDTH, TOP_MARGIN);
		}else {
			addNoImage();
		}
	}
	
	private void addNoImage() {
		if(profile.getGender().equals("Male")) {
			GImage noImageMan = new GImage("noImageMan.jpg");
			noImageMan.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(noImageMan, getWidth()/3 - getWidth()/8 - IMAGE_WIDTH, TOP_MARGIN);
		}else if(profile.getGender().equals("Female")){
			GImage noImageWoman = new GImage("noImageWoman.jpg");
			noImageWoman.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(noImageWoman, getWidth()/3 - getWidth()/8 - IMAGE_WIDTH, TOP_MARGIN);
		}else {
			GImage noImageOther = new GImage("noImageOther.jpg");
			noImageOther.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(noImageOther, getWidth()/3 - getWidth()/8 - IMAGE_WIDTH, TOP_MARGIN);
		}
		
	}
	
	private void drawProfileInfo() {
		//add name 
		GLabel profileName = new GLabel("Profile Name: " + profile.getName());
		profileName.setFont("SenSerif-Bold-20");
		profileName.setColor(Color.BLACK);
		add(profileName, LEFT_MARGIN, TOP_MARGIN + IMAGE_HEIGHT + ABOUT_OFFSET/2);
		
		//add birthday 
		GLabel profileBirthday  = new GLabel("Profile Birthday: " + profile.getBirthday());
		profileBirthday .setFont("SenSerif-Bold-20");
		profileBirthday .setColor(Color.BLACK);
		add(profileBirthday , LEFT_MARGIN, profileName.getY() + ABOUT_OFFSET);
		
		//add gender 
		GLabel profileGender  = new GLabel("Profile Gender: " + profile.getGender());
		profileGender .setFont("SenSerif-Bold-20");
		profileGender .setColor(Color.BLACK);
		add(profileGender , LEFT_MARGIN, profileBirthday.getY() + ABOUT_OFFSET);
		
		//add status
		GLabel profileStatus  = new GLabel("Profile Status: " + profile.getStatus());
		profileStatus .setFont("SenSerif-Bold-20");
		profileStatus .setColor(Color.BLACK);
		add(profileStatus , LEFT_MARGIN, profileGender.getY() + ABOUT_OFFSET);
		
		//add friend list 
		GLabel labelFriend  = new GLabel("Profile Friends: ");
		labelFriend .setFont("SenSerif-Bold-20");
		labelFriend .setColor(Color.BLACK);
		add(labelFriend , LEFT_MARGIN, profileStatus.getY() + ABOUT_OFFSET);
		
		Iterator<String> it = profile.getFriends();
		int i = 1;
		
		while(it.hasNext()) {
			GLabel profileFriendList  = new GLabel(it.next());
			profileFriendList .setFont("SenSerif-Bold-20");
			profileFriendList .setColor(Color.BLACK);
			add(profileFriendList , LEFT_MARGIN + labelFriend.getWidth(), profileStatus.getY() + i * ABOUT_OFFSET);
			i++;
		}
	}
	
	private void drawNewsFeedPanel() {
		GImage panel = new GImage("newsFeedIcon.jpg");
		panel.setSize(getWidth()/3 + getWidth()/24, 70);
		add(panel, getWidth()/3, getHeight()/17);
		
		GLabel label = new GLabel("Your  News  Feed");
		label.setFont(BUTTON_TEXT);
		label.setColor(new Color(24, 119, 242));
		add(label, getWidth()/3 + getWidth()/6 + getWidth()/48 - label.getWidth()/2, getHeight()/17 + 66);
		
		GRect feedRect = new GRect(getWidth()/3 + getWidth()/24, getHeight() - label.getY());
		feedRect.setColor(Color.WHITE);
		feedRect.setFilled(true);
		feedRect.setFillColor(Color.WHITE);
		add(feedRect, getWidth()/3, label.getY());
	}
	
	private void drawChatPanel() {
		GImage chatBackground = new GImage("chatBackground.jpg");
		chatBackground.setSize(getWidth()/3 - getWidth()/24, getHeight() - getHeight()/17);
		add(chatBackground, 2.0 * getWidth()/3.0 + getWidth()/24, getHeight()/17);
		
//		drawMessages();
	}
	
	private boolean updateCondition() {
		if(update.equals("The status has changed") || update.equals("The Image has changed") ||
				update.equals("Message is sent")) {
			return true;
		}else {
			return false;
		}
	}
	
	private void drawMessages() {
		if(!messagingProfile.equals("")) {
			Iterator<String[]> it = profileDataBase.getProfileWithName(messagingProfile).getMessagesOfFriend(messagingProfile);
			int countMessage = 0; 
			
			while(it.hasNext()) {
				drawOneMessage(it.next(), countMessage);
				countMessage++;
			}
		}else{
			drawNoMessages();
		}
	}
	
	private void drawOneMessage(String[] message, double numOfMessage) {
		if(message[0].equals(profile.getName())) {
			drawMessageRect(getWidth() - 3 * (getWidth()/3 - getWidth()/24) / 4.0, 
					getHeight()/17 + numOfMessage * MESSAGE_REXT_Y, message[1], new Color(24, 119, 242));
		}else {
			drawMessageRect(getWidth() - getWidth()/3 - getWidth()/24, 
					getHeight()/17 + numOfMessage * MESSAGE_REXT_Y, message[1], new Color(24, 119, 242));
		}
	}
	
	private void drawMessageRect(double posX, double posY, String text, Color color) {
		GRoundRect tempRect = new GRoundRect(posX, posY, 3 * (getWidth()/3 - getWidth()/24) / 4.0, MESSAGE_REXT_Y, 30);
		tempRect.setColor(color);
		add(tempRect);
		
		GLabel tempLabel = new GLabel(text);
		tempLabel.setFont(MESSAGE_FONT);
		tempLabel.setColor(Color.WHITE);
		add(tempLabel, tempRect.getX() + 3, tempRect.getY() + tempRect.getHeight()/2 + tempLabel.getHeight()/2);
	}
	
	private void drawNoMessages() {
		GLabel label = new GLabel("NO Messages");
		label.setFont("SenSerif-Bold-30");
		label.setColor(Color.GREEN);
		add(label, getWidth() - (getWidth()/3 - getWidth()/24) + (getWidth()/3 - getWidth()/24 - label.getWidth())/2, 
				getHeight()/2 + label.getHeight()/2);
	}
	
	
	
	//searched profile
	private void drawSearchedProfile() {
		removeAll();
		drawProfileBackground();
		drawFacebookBluePanel();
		drawProfileImage(searchedProfile.getImage());
		drawSearchedProfileInfo();
		
		drawAddFriendButton();
		
		while(profile != null && searchedProfile != null) {
			if(addFriendRectButton.getColor() == CREATE_CLICK_EFECT_COLOR) {//add friend option
				tryAddFriend();
				pause(2 * PAUSE_FOR_CLICK);
				addFriendRectButton.setColor(CREATE_FIRST_COLOR);
			}
		}
	}
	
	private void drawSearchedProfileInfo() {
		//add name 
		GLabel profileName = new GLabel("Profile Name: " + searchedProfile.getName());
		profileName.setFont("SenSerif-Bold-20");
		profileName.setColor(Color.BLACK);
		add(profileName, LEFT_MARGIN, TOP_MARGIN + IMAGE_HEIGHT + ABOUT_OFFSET/2);
		
		//add birthday 
		GLabel profileBirthday  = new GLabel("Profile Birthday: " + searchedProfile.getBirthday());
		profileBirthday .setFont("SenSerif-Bold-20");
		profileBirthday .setColor(Color.BLACK);
		add(profileBirthday , LEFT_MARGIN, profileName.getY() + ABOUT_OFFSET);
		
		//add gender 
		GLabel profileGender  = new GLabel("Profile Gender: " + searchedProfile.getGender());
		profileGender .setFont("SenSerif-Bold-20");
		profileGender .setColor(Color.BLACK);
		add(profileGender , LEFT_MARGIN, profileBirthday.getY() + ABOUT_OFFSET);
		
		//add status
		GLabel profileStatus  = new GLabel("Profile Status: " + searchedProfile.getStatus());
		profileStatus .setFont("SenSerif-Bold-20");
		profileStatus .setColor(Color.BLACK);
		add(profileStatus , LEFT_MARGIN, profileGender.getY() + ABOUT_OFFSET);
		
		//add friend list 
		GLabel labelFriend  = new GLabel("Profile Friends: ");
		labelFriend .setFont("SenSerif-Bold-20");
		labelFriend .setColor(Color.BLACK);
		add(labelFriend , LEFT_MARGIN, profileStatus.getY() + ABOUT_OFFSET);
		
		Iterator<String> it = searchedProfile.getFriends();
		int i = 1;
		
		while(it.hasNext()) {
			GLabel profileFriendList  = new GLabel(it.next());
			profileFriendList .setFont("SenSerif-Bold-20");
			profileFriendList .setColor(Color.BLACK);
			add(profileFriendList , LEFT_MARGIN + labelFriend.getWidth(), profileStatus.getY() + i * ABOUT_OFFSET);
			i++;
		}
	}
	
	private void drawAddFriendButton() {
		addFriendRectButton = new GRoundRect(getWidth()/2 + getWidth()/8 + 25, getHeight()/2 - 100 + 60, 300, 50, 15);
		addFriendLabelButton = new GLabel("Add Friend");
		
		addFriendRectButton.setFilled(true);
		addFriendRectButton.setColor(CREATE_FIRST_COLOR);
		
		addFriendLabelButton.setColor(Color.WHITE);
		addFriendLabelButton.setFont(BUTTON_TEXT);
		
		add(addFriendRectButton);
		add(addFriendLabelButton, getWidth()/2 + getWidth()/8 + 25 + (300 - addFriendLabelButton.getWidth())/2, 
				getHeight()/2 - 100 + 60 + 50/2 + addFriendLabelButton.getAscent()/2 - 2);
		
	}
	
	private void tryAddFriend() {
		if(profile.isFriend(searchedProfile.getName())) {
			shawMessage.setLabel("This profile is already your friend");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}else {
			profile.addFriend(searchedProfile.getName());
			searchedProfile.addFriend(profile.getName());
			shawMessage.setLabel("A friend has been added");
			add(shawMessage, getWidth()/2 - shawMessage.getWidth()/2, getHeight() - 8);
		}
	}
	
	
	
	//mouse events
	@Override
	public void mouseMoved(MouseEvent e) {
		//if mouse is on login or create new button
		if(getElementAt(e.getX(), e.getY()) == loginRectButton || getElementAt(e.getX(), e.getY()) == loginLabelButton) {	//checking on login button
			loginRectButton.setColor(LOGIN_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == createNewAccRectButton || getElementAt(e.getX(), e.getY()) == createNewAccLabelButton) {//checking on create new account button
			createNewAccRectButton.setColor(CREATE_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == homePageRectButton || getElementAt(e.getX(), e.getY()) == homePageLabelButton) {//checking on create new account button
			homePageRectButton.setColor(CREATE_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == addFriendRectButton || getElementAt(e.getX(), e.getY()) == addFriendLabelButton) {
			addFriendRectButton.setColor(CREATE_EFECT_COLOR);
		}
		
		//next else if is created for becoming button first color again
		else if(loginRectButton.getColor() == LOGIN_EFECT_COLOR) {
			loginRectButton.setColor(LOGIN_FIRST_COLOR);
		}else if(createNewAccRectButton.getColor() == CREATE_EFECT_COLOR) {
			createNewAccRectButton.setColor(CREATE_FIRST_COLOR);
		}else if(homePageRectButton.getColor() == CREATE_EFECT_COLOR) {
			homePageRectButton.setColor(CREATE_FIRST_COLOR);
		}else if(addFriendRectButton.getColor() == CREATE_EFECT_COLOR) {
			addFriendRectButton.setColor(CREATE_FIRST_COLOR);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		if(getElementAt(e.getX(), e.getY()) == loginRectButton || getElementAt(e.getX(), e.getY()) == loginLabelButton) {	//checking on login button
			loginRectButton.setColor(LOGIN_CLICK_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == createNewAccRectButton || getElementAt(e.getX(), e.getY()) == createNewAccLabelButton) {//checking on create new account button
			createNewAccRectButton.setColor(CREATE_CLICK_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == homePageRectButton || getElementAt(e.getX(), e.getY()) == homePageLabelButton) {//checking on create new account button
			homePageRectButton.setColor(CREATE_CLICK_EFECT_COLOR);
		}else if(getElementAt(e.getX(), e.getY()) == addFriendRectButton || getElementAt(e.getX(), e.getY()) == addFriendLabelButton) {//checking on create new account button
			addFriendRectButton.setColor(CREATE_CLICK_EFECT_COLOR);
		}
	}
	

	//West panel components declaration
	private JTextField createLoginField; //login  text field
	private JTextField createPasswordField; //password  text field
	private JTextField createNameField; //name  text field
	private JTextField createLastNameField; //last name  text field
	private JComboBox genderBox; //gender box
	private JComboBox birthdayBox; //birthday combo box
	private JComboBox birthMonthBox; // birthMonth combo box
	private JComboBox birthYearBox; //birthYear combo box
	private JCheckBox robotCheckBox; //check box
	private JButton signUpButton; //sign up button
	
	
	//North panel components declaration
	private JTextField searchProfileField; //search profile text field
	private JButton searchProfileButton; //search button
	private JButton returnMyPage; //for return user page;
	private JTextField enterLoginField; //login text field
	private JTextField enterPasswordField; //password text field
	private JButton enterButton; //enter button
	private JButton logOutButton; // log out button
	
	
	//South panel components declaration
	private JTextField sendMessageField; //Send message text field
	private JButton sendMessageButton; //send button 
	private JTextField statusTextField; //for changing status
	private JTextField imageTextField; //for changing image
	private JTextField friendNameField; //for send messages
	
	
	//other class constructor declaration
	private Profile profile; //current profile
	private Profile searchedProfile;
	private ProfileDataBase profileDataBase; //profile data base
	private String page;
	private String messagingProfile;
	private String update;
	
	
	//login button
	private GRoundRect loginRectButton; //button rect
	private GLabel loginLabelButton; //button label
	
	
	//create new account button
	private GRoundRect createNewAccRectButton; //button rect
	private GLabel createNewAccLabelButton; //button label

	
	//return home page button
	private GRoundRect homePageRectButton; //button rect
	private GLabel homePageLabelButton; //button label
	
	private GRoundRect addFriendRectButton; //button rect
	private GLabel addFriendLabelButton; //button label
	
	private GLabel shawMessage; //for showing messages on bottom
	
	
}
