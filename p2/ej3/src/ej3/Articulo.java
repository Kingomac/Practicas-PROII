package ej3;

import java.text.DecimalFormat;

/**
 *
 * @author Mario
 *
 * Los artículos de una tienda tienen una marca, una referencia, una talla y un
 * coste básico. Dichos productos se pueden vender de dos maneras: al por menor,
 * añadiendo el 21% de IVA para obtener el precio con IVA, o al por mayor,
 * añadiendo un 8% de ganancia para obtener el precio al por mayor (en este caso
 * no se incluye IVA). Los artículos se expresan como "referencia - marca
 * (talla): coste EUROS". Será necesario un método calculaPrecioFinal(tipoVenta)
 * al que se le pueda pasar el tipo de venta específico (se pueden definir como
 * constantes los tipos de venta). Existirán métodos que devuelvan esta
 * información (por ejemplo, calculaPrecioPorMayor() y calculaPrecioPorMenor())
 * como un valor numérico, mientras que el método toString() estándar mostrará
 * la información al por menor.
 *
 */
public class Articulo {

    private static final double MULTIPLICADOR_IVA = 1.21;
    private static final double MULTIPLICADOR_GANANCIA = 1.08;

    public static enum TipoVenta {
        POR_MAYOR, POR_MENOR
    }

    private final String referencia;
    private final String marca;
    private final String talla;
    private final double costeBasico;

    public Articulo(String referencia, String marca, String talla, double costeBasico) {
        this.referencia = referencia;
        this.marca = marca;
        this.talla = talla;
        this.costeBasico = costeBasico;
    }

    /**
     *
     * @return Referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     *
     * @return Talla
     */
    public String getTalla() {
        return talla;
    }

    /**
     *
     * @return Marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @return Precio de venta al por mayor
     */
    public double calculaPrecioPorMayor() {
        return costeBasico * MULTIPLICADOR_GANANCIA;
    }

    /**
     * @return Precio de venta al por menor
     */
    public double calculaPrecioPorMenor() {
        return costeBasico * MULTIPLICADOR_IVA;
    }

    /**
     * Calcula el precio según el tipo de venta
     *
     * @param tipo Tipo de venta (por menor o por mayor)
     * @return Precio en EUROS del artículo
     */
    public double calculaPrecioFinal(TipoVenta tipo) {
        if (tipo.equals(TipoVenta.POR_MAYOR)) {
            return calculaPrecioPorMayor();
        } else {
            return calculaPrecioPorMenor();
        }
    }

    /**
     * Devuelve un artículo con su coste al por menor
     *
     * @return Articulo en formato "referencia - marca (talla): coste EUROS"
     */
    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        toret.append(getReferencia());
        toret.append(" - ");
        toret.append(getMarca());
        toret.append(" (");
        toret.append(getTalla());
        toret.append("): ");
        DecimalFormat df = new DecimalFormat("###.##");
        toret.append(df.format(calculaPrecioPorMenor()));
        toret.append(" EUROS");
        return toret.toString();
    }

}
