package net.omidn.jbrainfuck;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class BrainFuckInterpreter {
	private String bfCode;
	
	public BrainFuckInterpreter(String bfCode) {
		this.bfCode = bfCode;
	}
	
	public BrainFuckInterpreter(File bfFile) throws IOException {
		StringBuilder sb = new StringBuilder();

		List<String> allLines = Files.readAllLines(bfFile.toPath());

		for (String s : allLines) {
			sb.append(s);
		}
		this.bfCode = sb.toString();
	}
	
}
