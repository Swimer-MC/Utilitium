package org.ReStudios.utitlitium;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Functions whose functionality works, but the desired result MAYBE not be the desired one
 */
@SuppressWarnings("unused")
public class WarnFunctions {

    /**
     * Get Text-to-speech audio data using Google Translator
     * @param text Text needed to speech
     * @param language Language in google argument format (en, ru, de etc.)
     * @return Bytes of audio file
     */
    public static Byte[] getTTSAudioFile(String text, String language){
        ArrayList<Byte> bytes = new ArrayList<>();
        try {
            URL u = new URL("http://translate.google.com/translate_tts?tl="+language+"&q="+ URLEncoder.encode(text, StandardCharsets.UTF_8) +"&client=tw-ob");
            URLConnection con = u.openConnection();
            con.setDoInput(true);
            con.connect();
            DataChannel dc = new DataChannel(new OutputStream(){
                            @Override
                            @SuppressWarnings("all")
                            public void write(int b) throws IOException {
                                bytes.add((byte) b);
                            }
                        }, con.getInputStream());
            dc.transfer();
            dc.closeInput();
            dc.closeOutput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bytes.toArray(new Byte[0]);
    }



}
