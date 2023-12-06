
package gesfei.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author diana
 */
public class Utilidades {
    public static void mostrarAlertaSimple(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alertaSImple = new Alert(tipo);
        alertaSImple.setTitle(titulo);
        alertaSImple.setContentText(mensaje);
        alertaSImple.setHeaderText(null);
        alertaSImple.showAndWait();
    }
    
    public static byte[] convertirArchivoABytes(File archivo) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            byte[] buffer = new byte[(int) archivo.length()];
            fis.read(buffer);
            return buffer;
        }
    }
    
    public static byte[] convertirImagenABytes(Image image) throws IOException {
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bufferedImage, "png", outputStream);
        return outputStream.toByteArray();
    }
}
}
