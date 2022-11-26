package org.kultpower;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = KultpowerApplication.class)
@ActiveProfiles("kp2")
@Disabled
public class InitDatabase {

	@Test
	public void initDatabase() {
		//nichts
	}


}
