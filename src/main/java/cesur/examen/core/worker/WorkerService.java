package cesur.examen.core.worker;

import java.util.logging.Logger;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Alejandro Álvarez Mérida
 * Fecha: 11-12-2023
 *
 *  No se permite escribir en consola desde las clases DAO, Service y Utils usando System.out.
 *  En su lugar, usa log.info(), log.warning() y log.severe() para mostrar información interna
 *  o para seguir la traza de ejecución.
 */
/**
 *  Services classes offers methods to our main application, and can
 *  use multiple methods from DAOs and Entities.
 *  It's a layer between Data Access Layer and Aplication Layer (where
 *  Main app and controllers lives)
 *  It helps to encapsulate multiple opperations with DAOs that can be
 *  reused in application layer.
 */
public class WorkerService {

    private static final Logger log = Logger.getLogger(WorkerService.class.getName());
    private static final WorkerDAO workerDAO = new WorkerDAO();

    public static Worker renovateWorker(String dni) {
        if (dni == null || dni.isEmpty()) {
            log.warning("DNI is null or empty");
            return null;
        }

        Worker worker = workerDAO.getWorkerByDNI(dni);
        if (worker == null) {
            log.info("No worker found with DNI " + dni);
            return null;
        }
        worker.setFrom(new java.util.Date());
        Worker updatedWorker = workerDAO.update(worker);
        if (updatedWorker == null) {
            log.severe("Failed to update worker with DNI " + dni);
            return null;
        }

        log.info("Worker with DNI: " + dni + " has been successfully updated");
        return updatedWorker;
    }
}
