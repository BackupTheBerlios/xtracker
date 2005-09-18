package com.jmonkey.xtracker.test.fake;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.jsp.JspWriter;

public class FakeJspWriter extends JspWriter {
	private final StringWriter testWriter = new StringWriter();
	private final PrintWriter testPrintWriter = new PrintWriter(testWriter);

	public FakeJspWriter() {
		super(0, false);
	}
	
	public FakeJspWriter(int arg0, boolean arg1) {
		super(arg0, arg1);
	}

	public PrintWriter getTestPrintWriter() {
		return testPrintWriter;
	}

	public StringWriter getTestWriter() {
		return testWriter;
	}

	@Override
	public void newLine() throws IOException {
		testPrintWriter.println();
	}

	@Override
	public void print(boolean arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(char arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(int arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(long arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(float arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(double arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(char[] arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(String arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void print(Object arg0) throws IOException {
		testPrintWriter.print(arg0);
	}

	@Override
	public void println() throws IOException {
		testPrintWriter.println();
	}

	@Override
	public void println(boolean arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(char arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(int arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(long arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(float arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(double arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(char[] arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(String arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void println(Object arg0) throws IOException {
		testPrintWriter.println(arg0);
	}

	@Override
	public void clear() throws IOException {
	}

	@Override
	public void clearBuffer() throws IOException {
	}

	@Override
	public void flush() throws IOException {
		testPrintWriter.flush();
	}

	@Override
	public void close() throws IOException {
		testPrintWriter.close();
	}

	@Override
	public int getRemaining() {
		return 0;
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		testPrintWriter.write(cbuf, off, len);
	}

}
