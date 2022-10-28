import acm.program.ConsoleProgram;

public class Test extends ConsoleProgram{
	public void run() {
		Profile newProfile = new Profile("Zaza");
		newProfile.setName("zazaqwe");
		
		ProfileDataBase base = new ProfileDataBase();
		base.addProfile(newProfile);
		
		println(base.getProfileWithLogin("Zaza").getName());
	}
}
