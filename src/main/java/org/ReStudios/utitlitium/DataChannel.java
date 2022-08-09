package org.ReStudios.utitlitium;

import java.io.*;


@SuppressWarnings("unused")
public class DataChannel implements Closeable, Flushable {
    OutputStream os;
    InputStream is;

    public DataChannel(OutputStream os, InputStream is) {
        this.os = os;
        this.is = is;
    }

    public DataChannel(OutputStream os) {
        this.os = os;
    }

    public DataChannel(InputStream is) {
        this.is = is;
    }

    public OutputStream getOutputStream() {
        return os;
    }

    public InputStream getInputStream() {
        return is;
    }

    /**
     * Writes content to output stream
     * @param str to write
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if output stream isn't initialized on data channel
     */
    public void write(String str) throws IOException { byte[] bytes = str.getBytes(); write(bytes, 0, bytes.length); }

    /**
     * Writes integer to output stream
     * @param b to write
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if output stream isn't initialized on data channel
     */
    public void write(int b) throws IOException { os.write(b); }

    /**
     * Writes bytes to output stream
     * @param b to write
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if output stream isn't initialized on data channel
     */

    public void write(byte[] b) throws IOException { os.write(b); }

    /**
     * Writes bytes to specific stream's position
     * @param b to write
     * @param off the start offset
     * @param len the number of bytes to write
     * @throws IOException if an I/O error occurs
     * @throws NullPointerException if output stream isn't initialized on data channel
     */
    public void write(byte[] b, int off, int len) throws IOException { os.write(b, off, len); }

    /**
     * Flushes output stream to accept data income
     * @throws IOException if an I/O error occurs
     */
    public void flush() throws IOException { os.flush(); }

    /**
     * Reads next byte of stream
     * @return next byte of stream, or -1 if stream reached end
     * @throws IOException if an I/O error occurs
     */
    public byte read() throws IOException { return (byte) getInputStream().read(); }

    /**
     * Reads data and stores it right into the byte array
     * @param b to store data
     * @return number of bytes read, or -1 if no bytes were read
     * @throws IOException if an I/O error occurs
     */
    public int read(byte[] b) throws IOException { return getInputStream().read(b); }

    /**
     * Reads data and stores it right into the byte array
     * @param b to store data
     * @param off start offset in array b
     * @param len length of max bytes read
     * @return number of bytes read, or -1 if no bytes were read
     * @throws IOException if an I/O error occurs
     */
    public int read(byte[] b, int off, int len) throws IOException { return getInputStream().read(b, off, len); }

    /**
     * Reads all bytes from stream
     * @return stream content
     * @throws IOException if an I/O error occurs
     */
    public byte[] readAllBytes() throws IOException { return getInputStream().readAllBytes(); }

    public byte[] readNBytes(int len) throws IOException { return getInputStream().readNBytes(len); }

    public long skip(long n) throws IOException { return getInputStream().skip(n); }

    public void skipNBytes(long n) throws IOException { getInputStream().skipNBytes(n); }

    public int availableInput() throws IOException { return getInputStream().available(); }

    public void closeInput() throws IOException { getInputStream().close(); }
    public void closeOutput() throws IOException { getOutputStream().close(); }
    public void close() throws IOException {
        closeInput();
        closeOutput();
    }

}