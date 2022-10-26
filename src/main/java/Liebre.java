 public class Liebre extends Corredor {

    private static final int DUERME = 0;
    private static final int GRAN_SALTO = 9;
    private static final int RESBALON_GRANDE = (- 12);
    private static final int PEQUENIO_SALTO = 1;
    private static final int RESBALON_PEQUENIO = ( - 2 );

    public Liebre(int longitud) {
        super(longitud);
    }

    @Override
    public void moverse() {

        int porcentajeAleatorio = porcentajeAleatorio();
        int posicionCalculada = 0;

        if (estaEntre(porcentajeAleatorio, 0, 20))
            posicionCalculada = posicion() + DUERME;

        else if (estaEntre(porcentajeAleatorio, 21, 40))
            posicionCalculada = posicion() + GRAN_SALTO;

        else if (estaEntre(porcentajeAleatorio, 41, 50))
            posicionCalculada = posicion() + RESBALON_GRANDE;

        else if (estaEntre(porcentajeAleatorio, 51, 80))
            posicionCalculada = posicion() + PEQUENIO_SALTO;

        else if (estaEntre(porcentajeAleatorio, 81, 100))
            posicionCalculada = posicion() + RESBALON_PEQUENIO;

        if (estaAntesDeLaLineaDeSalida(posicionCalculada))
            setPosicion(lineaDeSalida());

        else if (estaDespuesDeLaLineaDeMeta(posicionCalculada))
            setPosicion(lineaDeMeta());

        else
            setPosicion(posicionCalculada);

    }

    @Override
    public String nombre() {
        return "L";
    }

}
