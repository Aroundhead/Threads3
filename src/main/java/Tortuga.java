public class Tortuga extends Corredor {

    private static final int AVANCE_RAPIDO = 3;
    private static final int RESBALON = ( - 6 );
    private static final int AVANCE_LENTO = 1;

    public Tortuga(int longitud) {
        super(longitud);
    }

    @Override
    public void moverse() {

        int porcentajeAleatorio = porcentajeAleatorio();
        int posicionCalculada = 0;

        if (estaEntre(porcentajeAleatorio, 0, 50))
            posicionCalculada = posicion() + AVANCE_RAPIDO;

        else if (estaEntre(porcentajeAleatorio, 51, 70))
            posicionCalculada = posicion() + RESBALON;

        else if (estaEntre(porcentajeAleatorio, 71, 100))
            posicionCalculada = posicion() + AVANCE_LENTO;


        if (estaAntesDeLaLineaDeSalida(posicionCalculada))
            setPosicion(lineaDeSalida());

        else if (estaDespuesDeLaLineaDeMeta(posicionCalculada))
            setPosicion(lineaDeMeta());

        else
            setPosicion(posicionCalculada);

    }

    @Override
    public String nombre() {
        return "T";
    }
}
