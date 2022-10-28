import java.util.ArrayList;
import java.util.Iterator;

import acm.graphics.GImage;

public class Profile{ 
	
	public Profile(String login) {
		this.login = login;
		
		initVariables();
	}
	
	private void initVariables() {
		password = "";
		name = "";
		birthday = new String[3];
		gender = "";
		image = null;
		status = "";
		friends = new ArrayList<String>();
	}
	
	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLastName(String lastName) {
		this.name += " " + lastName;
	}

	public void setBirthday(String day, String month, String year) {
		birthday[0] = day;
		birthday[1] = month;
		birthday[2] = year;
	}

	public String getBirthday() {
		String birth = "";
		for(int i = 0; i < 3; i++) {
			birth += birthday[i] + ".";
		}
		
		return birth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setImage(GImage image) {
		this.image = image;
	}

	public GImage getImage() {
		return image;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void addFriend(String name) {
		friends.add(name);
	}
	
	public boolean isFriend(String friendName) {
		Iterator<String> it = friends.iterator();
		
		while(it.hasNext()) {
			if(it.next().equals(friendName)) {
				return true;
			}
		}
		
		return false;
	}

	public Iterator<String> getFriends() {
		return friends.iterator();
	}

	public boolean isCorrectPassword(String inputedPassword) {
		if(password.equals(inputedPassword)) {
			return true;
		}else {
			return false;
		}
	}
	
	public Iterator<String[]> getMessagesOfFriend(String friendName){
		return chat.get(friends.indexOf(friendName)).iterator();
	}
	
	public void sendMessageToFriend(String text, String friendName) {
		//first string is my name because i send message
		String[] str = new String[2];
		str[0] = "Me:";
		str[1] = text;
		
		ArrayList<String[]> list;
		
		if(chat.get(friends.indexOf(friendName)) != null) {
			list = chat.get(friends.indexOf(friendName));
			list.add(str);
		}else {
			list = new ArrayList<String[]>();
			list.add(str);
		}
				
		chat.add(list);
	}
	
	public void receiveMessage(String text, String friendName) {
		//first string is my friend name because my friend send me message
		String[] temp = new String[2];
		temp[0] = friendName;
		temp[1] = text;
		chat.get(friends.indexOf(friendName)).add(temp);
	}
	
	private String login;
	private String password;
	private String name;
	private String[] birthday;
	private String gender;
	private GImage image;
	private String status;
	private ArrayList<String> friends;
	private ArrayList<ArrayList<String[]>> chat;
}
