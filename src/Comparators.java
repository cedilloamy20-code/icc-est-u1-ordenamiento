import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import models.Estudiante;

public class Comparators {

    private List<Estudiante> estList;
    private Estudiante[] estArray;
    
    public Comparators() {
         Estudiante e1 = new Estudiante("Juan", 10);
        estArray = new Estudiante[]{e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 7),
            new Estudiante("Pedro", 6.8),    
        };
        estList = new ArrayList<>(List.of(estArray));
        // LLAMADAS A LOS EJEMPLOS
        ejemplo1();
        ejemplo2();
        ejemplo3();
        ejemplo4();
        ejemplo5();
        ejemplo6();
        ejemplo7();
        ejemplo8();
        ejemplo9();
        ejemplo10();
    }

    private void print(List<Estudiante> lista) {
        //for est in List
        for(Estudiante est : lista){
            System.out.println(est);
        }
    }

    /**
     * Comparator -> por VALOR
     * Lambda extractora directa: nota ascedente
     */

    public void ejemplo1(){
        //copiar el arreglo global
        System.out.println("Ejemplo 1");
        List<Estudiante> lista = new ArrayList<>(estList);
        // Comparator -> Obj != (Envolvente de primitivo ni String)
        Comparator<Estudiante> comparador = Comparator.comparingDouble(x -> x.getNota());
        lista.sort(comparador);
        //IMPRIMIR
        print(lista);
    }

    /**
     * Ordenar ascendentemente
     * Comparator -> por VALOR
     * Referencia
     */

    public void ejemplo2(){
        System.out.println("Ejemplo 2");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparador = Comparator.comparingDouble(Estudiante::getNota);
        lista.sort(comparador);
        print(lista);
    }

    public void ejemplo3(){
        System.out.println("Ejemplo 3");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparador = Comparator.comparingDouble(Estudiante::getNota).reversed();
        lista.sort(comparador);
        print(lista);
    }

        public void ejemplo4(){
        System.out.println("Ejemplo 4");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getName);
        lista.sort(comparador);
        print(lista);
    }

        public void ejemplo5(){
        System.out.println("Ejemplo 5");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparador = (e1, e2) -> Double.compare(e1.getNota(), e2.getNota());
        lista.sort(comparador);
        print(lista);
    }

     /**
     *  Ordenar por nombre ascendentemente
     * Comparator -> compara dos items
     * lambda
     */
    public void ejemplo6() {
        System.out.println("Ejemplo 6");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
        lista.sort(comparator);
        //imprimir
        print(lista);
    }
    /**
     *  Ordenar por nota descendente
     * Comparator -> compara dos items
     * lamba
     */
    public void ejemplo7() {
        System.out.println("Ejemplo 7");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = (e1, e2) -> Double.compare(e2.getNota(), e1.getNota());
        lista.sort(comparator);
        //imprimir
        print(lista);
    }

    /**
     *  Ordenar por nota asendente y nombre Descendente
     * Comparator -> compara dos items
     * lambda
     */
    public void ejemplo8() {
        System.out.println("Ejemplo 8");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = (e1, e2) -> {
            int notaComparacion = Double.compare(e1.getNota(), e2.getNota());
            if (notaComparacion != 0) {
                return notaComparacion;
            }
            return e2.getName().compareTo(e1.getName());
        };
        lista.sort(comparator);
        //imprimir
        print(lista);
    }
    /**
     *  Ordenar por nota asendente y nombre Ascendente
     * Comparator -> compara dos items
     * referencias 2 comparaciones
     */
    public void ejemplo9() {
        System.out.println("Ejemplo 9");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
            .comparingDouble(Estudiante::getNota)
            .thenComparing(Estudiante::getName);
        lista.sort(comparator);
        //imprimir
        print(lista);
    }
    /**
     *  Ordenar por nota descendente y nombre Ascendente
     * Comparator -> por valor
     * 1 comparator lambda
     * 2 comparator referencia
     */
    public void ejemplo10(){
        System.out.println("Ejemplo 10");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
                .comparingDouble((Estudiante e) -> e.getNota()).reversed()
                .thenComparing(Estudiante::getName);
        lista.sort(comparator);
        //imprimir
        print(lista);
    }
    /**
    * Ordenar por nota ajustada ASCENDENTE y NOMBRE DESCENDENTE.
    * Sumar 2 puntos si la nota es menor que 7.
    * La nota máxima permitida es 10.
    * Comparator -> por valor calculado.
    * 1 comparator lambda con bloque de instrucciones.
    * 2 comparator referencia con orden inverso.
    */
    public void ejemplo11() {
        System.out.println("Ejemplo 11");
        List<Estudiante> lista = new ArrayList<>(estList);
        Comparator<Estudiante> comparator = Comparator
                .comparingDouble((Estudiante e) -> {
                    double notaAjustada = e.getNota();
                    if (notaAjustada < 7) {
                        notaAjustada += 2;
                    }
                    return Math.min(notaAjustada, 10);
                })
                .thenComparing(Comparator.comparing(Estudiante::getName).reversed());
        lista.sort(comparator);
        //imprimir
        print(lista);
    }
}


