import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

class MyServiceTest1 {

	@Test
	public void testVerifyInteractionWithArguments() {
		ExternalApi1 mockApi= Mockito.mock(ExternalApi1.class);
		MyService1 service= new MyService1(mockApi);
		service.fetchData();
		verify(mockApi).getData("admin", 10);
	}
}
