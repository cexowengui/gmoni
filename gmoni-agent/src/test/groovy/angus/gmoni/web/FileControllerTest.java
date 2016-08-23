package angus.gmoni.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;//important
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



import static org.junit.Assert.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@WebMvcTest(FileController.class)
public class FileControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private FileController fileController;

	@Test
	public void testGetFile() {
		fail("Not yet implemented");
	}

}


