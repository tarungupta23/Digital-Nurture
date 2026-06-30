
public class MyService {
	private final ExternalApi externalapi;
	
	public MyService(ExternalApi externalapi) {
		this.externalapi=externalapi;
	}
	public String fetchData() {
		return externalapi.getData();
	}
	
}
