import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        runEjemplosPrimitivos();
        runEjemplosObjetos();
        runComparators();
        runComparatorsObj();
        runComparatorsObj2();
    } 

    private static void runComparatorsObj2(){
        Estudiante e1 = new Estudiante("Juan", 10);
        
        Estudiante[] estudiantes = {e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 6.8),    
        };

        Comparator<Estudiante> compNota = Comparator.comparingDouble(e -> e.getNota());
        Arrays.sort(estudiantes, compNota);
        System.out.println("Ordenado por nota de menor a mayor");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print(estudiantes[i] + " - ");
        }
        List<Estudiante> estudiantesList = new ArrayList<>(Arrays.asList(estudiantes));

    }

    private static void runComparatorsObj() {
        List<Integer> numeros =
         new ArrayList<>(List.of(5, 6, 4, 1, 2, 3));
        
        //orden de menor a mayor
        numeros.sort(Comparator.naturalOrder());
        numeros.sort(null);
        System.out.println(numeros);
        //ordenar de mayor a menor
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);
    }

    private static void runComparators() {
       Integer[] original = { 5, 6, 4, 1, 2, 3};
       //Array.sort -> Ordena arreglos por su orden natural, de menor a mayor
       Arrays.sort(original);
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + " - ");
       }
       System.out.println("---------");
    
       Arrays.sort(original, Comparator.reverseOrder());
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + " - ");
       }
    }

    private static void runEjemplosObjetos() {

        Estudiante e1 = new Estudiante("Juan", 10);
        
        Estudiante[] estudiantes = {e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 6.8),    
        };
        
        Bubble bubble = new Bubble();
        
        System.out.println("original");
        printArreglo(estudiantes); //
        
        bubble.sortEstudiantes(estudiantes);
        
        System.out.println("ordenado");
        printArreglo(estudiantes); //
    
    }

    public static void runEjemplosPrimitivos() {
        int [] original = { 5, 6, 4, 1, 2, 3};
        int [] b = original.clone();
        int [] c = original.clone();
        int [] d = original.clone();

        // --- BUBBLE SORT ---
        Bubble bubble = new Bubble();
        printArreglo(b);
        bubble.sort(b);
        printArreglo(b);

        // --- SELECTION SORT ---
        System.out.println("Selection Sort:");
        Selection selection = new Selection();
        printArreglo(c);
        selection.sort(c);
        printArreglo(c);

        // --- INSERTION SORT ---
        System.out.println("--- Selection Insertion ---");
        InsertionSort insertion = new InsertionSort();
        System.out.println("Original");
        printArreglo(d);
        
        insertion.sort(d);
        
        System.out.println("Ordenado Des");
        printArreglo(d);
          
    }
    //Metodo que imprime un arreglo de enteros
    public static void printArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println();
        }
    //NUEVO MÉTODO: Sobrecarga para imprimir arreglos de Estudiantes (Estudiante[])
    public static void printArreglo(Estudiante[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]);
        if (i < arr.length - 1) {
            System.out.print(", ");
        }
    }
    System.out.println("]");
}
}