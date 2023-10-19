import java.beans.Transient;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.HomeController;

@WebMVCTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMVC mock;

    @Test
    public void testNotHomePage() throws Exception {
        mock.perform(get("/not_home"))
        .andExpect(status().isOk())
        .andExpect(view().name("not_home"))
        .andExpect(content().string(containsString("Not Home - Not Welcome")));
    }
    
}
