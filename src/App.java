import java.util.Arrays;
import java.util.Comparator;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        runEjemplosPrimitivos();
        runEjemplosObjetos();
        runComparators();
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
        for (int i = 0; i < arr.length; i++) {
            Estudiante e = arr[i];
            System.out.println(e.getName() + " - " + e.getNota());
        }
        System.out.println();
    }

}