package data;

public class CreateEntityAll {
	
	public CreateEntityAll() {};
	
	public void  CreateEntityA(int per ,int org ,int local ,int coun ,int tim , int eve) {
		System.out.println("Đang tạo node...");
		CreatePerson person = new CreatePerson();
		person.CreateNodePerson(per);
		
		CreateOrganization Org = new CreateOrganization();
		Org.CreateNodeOrganization(org);
		
		CreateLocation location = new CreateLocation();
		location.CreateNodeLocation(local);
		
		CreateEvent event = new CreateEvent();
	       event.CreateNodeEvent(eve);
		
		CreateCountry country = new CreateCountry();
		country.CreateNodeCountry(coun);
		
		CreateTime time = new CreateTime();
		time.CreateNodeTime(tim);
		System.out.println("Tao thanh cong !");
	}
}
