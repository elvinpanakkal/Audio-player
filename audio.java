import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
public class audio {
    public static void main(String[]args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        Scanner scanner = new Scanner(System.in);
        File file = new File("La-Lecon-Particuliere-Bof-La-Lecon-Particuliere.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response = "";

        while(!response.equals("Q")){
            System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your choice : ");
            response = scanner.next();
            response = response.toUpperCase();
        
            switch(response){
                case ("P") : clip.start();
                break;
                case ("S") : clip.stop();
                break;
                case ("R") : clip.setMicrosecondPosition(0);
                break;
                case ("Q") : clip.close(); 
                default : System.out.println("exited with code 019");
            }
        }
        System.out.println("Thank you for using the audio player !peace! ");
        scanner.close();
    }
}
