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
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Articulo[] articulos = {new Articulo("GS66 Stealth 10SE-051ES", "MSI",
            "15.3\"", 1404.13), new Articulo("MacBook Pro Apple M1", "Apple",
            "13.3\"", 1147.93), new Articulo("GX550LXS-HC029T", "Asus ROG", "15.6\"", 2812.06)
        };
        DecimalFormat df = new DecimalFormat("###.##");
        for (Articulo a : articulos) {
            System.out.println(a + " / " + df.format(a.calculaPrecioPorMayor()) + " EUROS");
        }
    }

}
