public class InsertionSort {
    public void sort(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int key = arreglo[i];
            int j = i - 1;
            // Cambiado a '<' para que ordene de forma descendente como en la diapositiva
            while (j >= 0 && arreglo[j] < key) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = key;
            
            if (key == 6 || key == 2 || key == 3) {
                System.out.println("El aux= " + key + " se inserta en pos " + (j + 1));
            }
        }
    }
}
