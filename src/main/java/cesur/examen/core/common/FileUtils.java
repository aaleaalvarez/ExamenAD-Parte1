package cesur.examen.core.common;

import cesur.examen.core.worker.Worker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Alejandro Álvarez Mérida
 * Fecha: 11-12-2023
 *
 * No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 * En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 * o para seguir la traza de ejecución.
 */


public class FileUtils {
    private static final Logger log = Logger.getLogger(FileUtils.class.getName());
    public static void toCSV(String fileName, List<Worker> workers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Worker worker : workers) {
                writer.write(
                        worker.getId() + "," +
                                worker.getName() + "," +
                                worker.getDni() + "," +
                                worker.getFrom() + "\n"
                );
            }

            log.info("Archivo CSV generado correctamente: " + fileName);

        } catch (IOException e) {
            log.severe("Error al escribir en el archivo CSV: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
