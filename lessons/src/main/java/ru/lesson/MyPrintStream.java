package ru.lesson;

import java.io.*;
import java.util.Locale;

public class MyPrintStream extends PrintStream {
    private static final PrintStream stream = System.out;

    public MyPrintStream() {
        super(new ByteArrayOutputStream());
    }

    public MyPrintStream(OutputStream out) {
        super(out);
    }

    public MyPrintStream(OutputStream out, boolean autoFlush) {
        super(out, autoFlush);
    }

    public MyPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
        super(out, autoFlush, encoding);
    }

    public MyPrintStream(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public MyPrintStream(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(fileName, csn);
    }

    public MyPrintStream(File file) throws FileNotFoundException {
        super(file);
    }

    public MyPrintStream(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
        super(file, csn);
    }

    @Override
    public void print(boolean b) {
        stream.print(b);
    }

    @Override
    public void print(char c) {
        String s = "" + c;

        stream.print(c);
    }

    @Override
    public void print(int i) {
        stream.print(i);
    }

    @Override
    public void print(long l) {
        super.print(l);
    }

    @Override
    public void print(float f) {
        super.print(f);
    }

    @Override
    public void print(double d) {
        super.print(d);
    }

    @Override
    public void print(char[] s) {
        super.print(s);
    }

    @Override
    public void print(String s) {
        super.print(s);
    }

    @Override
    public void print(Object obj) {
        super.print(obj);
    }

    @Override
    public void println() {
        super.println();
    }

    @Override
    public void println(boolean x) {
        super.println(x);
    }

    @Override
    public void println(char x) {
        super.println(x);
    }

    @Override
    public void println(int x) {
        super.println(x);
    }

    @Override
    public void println(long x) {
        super.println(x);
    }

    @Override
    public void println(float x) {
        super.println(x);
    }

    @Override
    public void println(double x) {
        super.println(x);
    }

    @Override
    public void println(char[] x) {
        super.println(x);
    }

    @Override
    public void println(String x) {
        super.println(x);
    }

    @Override
    public void println(Object x) {
        super.println(x);
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        return super.printf(format, args);
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return super.printf(l, format, args);
    }
}
