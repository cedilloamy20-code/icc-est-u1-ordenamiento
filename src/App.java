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

        Comparators comparators = new Comparators();
    } 

    private static void runComparatorsObj() {
        List<Integer> numeros = new ArrayList<>(List.of(5, 6, 4, 1, 2, 3));
        
        //orden de menor a mayor
        numeros.sort(Comparator.naturalOrder());
        numeros.sort(null);
        System.out.println(numeros);
        //ordenar de mayor a menor
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);
    }

    private static void runComparatorsObj2() {
        Estudiante e1 = new Estudiante ("Juan", 10);

        Estudiante[] estudiantes ={e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 6.8),
        };
        Comparator<Estudiante> compNota = Comparator.comparingDouble(e -> e.getNota());
        Arrays.sort(estudiantes, compNota);
        System.out.println("Ordenado por nota de menor a mayor");
        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(estudiantes[i]);
        }
        List<Estudiante> estudiantesLista = new ArrayList<>(List.of(e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 6.8)));
            estudiantesLista.sort(compNota);
            System.out.println("Ordenado por nota de menor a mayor");
            for (Estudiante e : estudiantesLista) {
                System.out.println(e);
            }
    }
    
    private static void runComparators() {
        //Arreglo de enteros
       Integer[] original = { 5, 6, 4, 1, 2, 3};
       //Array.sort -> Ordena arreglos por su orden natural, de menor a mayor
       Arrays.sort(original);
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + " - ");
        }
       System.out.println("---------");
    
       Arrays.sort(original, Comparator.reverseOrder());
        for (int i = 0; i < original.length; i++) {
            System.out.println(original[i] + " - ");
       }

    }
      
    private static void runEjemplosObjetos() {
        //Arreglo de enteros
        Estudiante e1 = new Estudiante("Juan", 10);
        
        Estudiante[] estudiantes = {e1,
            new Estudiante("Maria", 7),
            new Estudiante("Diego", 3.5),
            new Estudiante("Pedro", 6.8),    
        };
        
        Bubble bubble = new Bubble();
        bubble.sortEstudiantes(estudiantes);
        printArreglo(estudiantes); 
    }
    public static void printArreglo(Estudiante[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Estudiante e = arr[i];
        System.out.println(e.getName() + " - " + e.getNota());
        }
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
    public static void printArreglo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println();
        }
    }