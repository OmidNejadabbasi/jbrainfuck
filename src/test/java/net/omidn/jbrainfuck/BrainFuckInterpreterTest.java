package net.omidn.jbrainfuck;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class BrainFuckInterpreterTest {

	@Test
	public void testRemoveComments() throws Exception {
		String bfCode = getResourceAsString("helloworld.bf");
		String helloworld = "[]++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
		assertEquals(helloworld, BrainFuckInterpreter.removeComments(bfCode));
		
		
	}

	private String getResourceAsString(String resName) throws IOException, URISyntaxException {
		File file = new File(getClass().getClassLoader().getResource("helloworld.bf").toURI());
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
		String str = new String(bf.readAllBytes());
		return str;
	}
	
}
