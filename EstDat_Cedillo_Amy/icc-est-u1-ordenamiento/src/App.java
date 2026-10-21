public class App {
    public static void main(String[] args) throws Exception {
        int [] original = { 5, 6, 4, 1, 2, 3};
        int [] b = original.clone();
        int [] c = original.clone();
        int [] d = original.clone();

        // USAR EL METODO DEL ARCHIVO(clase) BUBBLE
        // INSTANCIAR el archivo BUBBLE
        // INTANCIA la clase BUBBLE
        Bubble bubble = new Bubble();
        // EJECUTAR CODIGO DEL ARCHIVO BUBBLE USO LA INSTANCIA bubble
        printArreglo(b);
        bubble.sort(b);
        printArreglo(b);

        //INSTANCIAS SELECCIÓN
        System.out.println("Selection Sort:");
        Selection selection = new Selection();
        printArreglo(c);
        selection.sort(c);
        printArreglo(c);

        //INSTANCIAS INSERCIÓN
        System.out.println("--- Selection Insertion ---:");
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