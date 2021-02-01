package net.omidn.jbrainfuck;

import java.io.IOException;
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
	
	public BrainFuckSession() {
		this(300, System.in, System.out);
	}
	/**
	 * Increments the char at cell which <code>pointer</code> points to.<br>
	 * This does what character + (plus) does in BrainFuck.
	 */
	public void doIncrement() {
		charList.set(pointer, (char) (charList.get(pointer) + 1));
	}

	/**
	 * Decrements the char at cell which <code>pointer</code> points to.<br>
	 * This does what character - (minus) does in BrainFuck.
	 */
	public void doDecrement() {
		charList.set(pointer, (char) (charList.get(pointer) - 1));
	}
	
	/**
	 * Shifts the pointer to the right by 1.<br>
	 * This does what character > does in BrainFuck.
	 */
	public void rightShift() {
		pointer++;
		if (pointer > charList.size()) {
			charList.add((char) 0);
		}
	}
	/**
	 * Shifts the pointer to the left by 1.<br>
	 * This does what character < does in BrainFuck.
	 * 
	 * @throws RuntimeException if the pointer becomes zero.
	 */
	public void leftShift() {
		pointer--;
		if (pointer < 0) {
			throw new RuntimeException("Syntax error: The pointer can't be negetive!");
		}
	}
	/**
	 * Reads a char from stdin InputStream and stores it in current cell that the pointer points to.<br>
	 * This does what character , (cama) does in BrainFuck.
	 * It igonres all the new line characters.
	 */
	public void read() {
		try {
			char nextChar = (char) stdin.read();
			while(nextChar=='\n' || nextChar=='\r') {
				nextChar = (char) stdin.read();
			}
			charList.set(pointer, (char) nextChar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes the current char to <code>stdout</code> OutputStream.
	 * This does what character . (dot) does in BrainFuck.
	 */
	public void write() {
		try {
			stdout.write(charList.get(pointer));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
