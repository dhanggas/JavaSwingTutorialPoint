
import java.io.File;


public class CekGambar {

    public static void main(String[] args) {
        File imageCheck = new File("src/gambar/apple_31.png");

        if (imageCheck.exists()) {
            System.out.println("Image di temukan");

        } else {
            System.out.println("Image not found!");
        }
    }

}
