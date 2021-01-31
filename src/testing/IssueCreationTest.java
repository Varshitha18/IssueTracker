package testing;

import static org.junit.Assert.*;
import org.junit.Test;

import issue.IssueFunctions;

public class IssueCreationTest {
	IssueFunctions fi = new IssueFunctions();
	
	@Test
	public void checkCreation() {
		assertEquals(1000, fi.createIssue(5, "Issue class not working", "Issue class not generating field properly", "v@gmail.com"));
	}
	
}
