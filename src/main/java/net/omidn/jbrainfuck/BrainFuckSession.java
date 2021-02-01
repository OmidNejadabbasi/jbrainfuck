package net.omidn.jbrainfuck;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class BrainFuckSession {
	private List<Character> charList;
	private int pointer;
	private InputStream stdin;
	private OutputStream stdout;
	
	public BrainFuckSession(int intitialCapacity, InputStream stdin, OutputStream stdout) {

		this.pointer = 0;
		charList = new ArrayList<Character>(intitialCapacity);
		this.stdin = stdin;
		this.stdout = stdout;

	}
	
	
	
}
