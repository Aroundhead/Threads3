import java.util.Random;

public abstract class Corredor {

    private final int meta;
    private final Random random;
    private int posicion;

    public Corredor(int meta) {
        this.posicion = lineaDeSalida();
        this.meta = meta;
        this.random = new Random();
    }

    public abstract void moverse();

    public abstract String nombre();

    public boolean cruzoLaMeta() {
        return posicion >= meta;
    }

    protected int porcentajeAleatorio() {
        return aleatorioEntre(0, 101);
    }

    protected int posicion() {
        return posicion;
    }

    protected boolean estaEntre(int numero, int bajo, int alto) {
        return (bajo <= numero) && (numero <= alto);
    }

    protected int lineaDeSalida() {
        return 1;
    }

    protected void setPosicion(int nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    protected int lineaDeMeta() {
        return meta;
    }

    protected boolean estaAntesDeLaLineaDeSalida(int posicion) {
        return posicion < lineaDeSalida();
    }

    protected boolean estaDespuesDeLaLineaDeMeta(int posicion) {
        return posicion > lineaDeMeta();
    }

    private int aleatorioEntre(int bajo, int alto) {
        return random.nextInt( alto - bajo) + bajo;
    }

}
