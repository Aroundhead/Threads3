import static java.lang.Thread.sleep;

public class Carrera implements Runnable {

    private final Corredor corredor;
    private final int retrasoEnMilisegundos;
    private static final char ESPACIO = ' ';
    private int segundos;

    public Carrera(Corredor corredor, int retraso) {
        this.corredor = corredor;
        this.retrasoEnMilisegundos = retraso;
    }

    @Override
    public void run() {
        try {
            correrCarrera();
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void correrCarrera() throws InterruptedException {
        while ( ! carreraTerminada() ) {
            corredor.moverse();
            sleep(retrasoEnMilisegundos);
            mostrarCorredor();
            segundos += 1;
        }
    }

    private void mostrarCorredor() {
        System.out.println(reporteDeCorredor());
    }

    private String reporteDeCorredor() {
        var stringBuilder = new StringBuilder();
        for (int i = corredor.lineaDeSalida(); i < corredor.posicion(); i++) {
            stringBuilder.append(ESPACIO);
        }
        stringBuilder.append(corredor.nombre());
        return stringBuilder.toString();
    }

    private boolean carreraTerminada() {
        return corredor.cruzoLaMeta();
    }
}
