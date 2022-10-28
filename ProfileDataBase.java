import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProfileDataBase{
	public ProfileDataBase() {
		profilesLoginMap = new HashMap<String, Profile>();
		profilesNameMap = new HashMap<String, Profile>();
	}
	
	public void addProfile(Profile profile) {
		profilesLoginMap.put(profile.getLogin(), profile);
		profilesNameMap.put(profile.getName(), profile);
	}

	public void delteProfile(Profile profile) {
		profilesLoginMap.remove(profile.getLogin());
		profilesNameMap.remove(profile.getName());
	}

	public Profile getProfileWithLogin(String login) {
		return profilesLoginMap.get(login);
	}

	public Profile getProfileWithName(String name) {
		return profilesNameMap.get(name);
	}

	public boolean containsProfileWithLogin(String login) {
		if(profilesLoginMap.containsKey(login)) {
			return true;
		}else {
			return false;
		}
	}

	public boolean containsProfileWithName(String name) {
		if(profilesNameMap.containsKey(name)) {
			return true;
		}else {
			return false;
		}
	}
	
	private Map<String, Profile> profilesLoginMap; //for searching with login
	private Map<String, Profile> profilesNameMap;	//for searching for name;
}
