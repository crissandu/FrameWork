import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenFileTest {


    public static void main(String[] args) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File("C:\\Users\\CRISTIAN SANDU\\Desktop\\imsi.txt");
        desktop.open(file);
    }


}
