import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
public static void main(String[] args) throws IOException {
    Configuration configuration = new Configuration();
    configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
    configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
    configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

    LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);


    recognizer.startRecognition(true);


    while(true){
        String result = recognizer.getResult().getHypothesis();
    if(result.startsWith("Hello")){
        String[] a = result.split(" ",1);
        System.out.println(a[1]);

        break;
    }}



    recognizer.stopRecognition();

}

}
