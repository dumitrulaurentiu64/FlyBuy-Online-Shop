package pssc.flybuy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pssc.flybuy.controller.ProductController;
import pssc.flybuy.repositories.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProductController.class, WebApplicationContext.class})
@WebAppConfiguration
public class ContollersTests {

    private MockMvc mock;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp() {
        mock = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/all"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.content().string("products"));
    }
}
