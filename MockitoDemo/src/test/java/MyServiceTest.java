import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MyServiceTest {

	@Test
	public void testExternalApi() {
		ExternalApi mockapi=Mockito.mock(ExternalApi.class);
		
		when(mockapi.getData()).thenReturn("Mock Data");
		MyService service=new MyService(mockapi);
		String result=service.fetchData();
		assertEquals("Mock Data", result);
	}
}
