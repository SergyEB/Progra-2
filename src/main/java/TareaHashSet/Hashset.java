package TareaHashSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author sergi
 */
public class Hashset {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> studentNames = new HashSet<>();

        readFile(studentNames);

        //printHashSet(studentNames);
        ArrayList<String> listNames = hashSetToArrayList(studentNames);

        //printArrayList(listNames);
        Collections.sort(listNames);

        //System.out.println("-------------------------------");
        //printArrayList(listNames);
        LinkedList<String> linkedName = arrayListToLinkedList(listNames);

        printMenu(linkedName);

    }

    public static void replaceName(BufferedReader br, LinkedList<String> linkedName, String name) throws IOException {
        int index = linkedName.indexOf(name);

        System.out.println("Ingrese el nuevo nombre:");
        String newName = br.readLine();
        linkedName.set(index, newName);
        System.out.println("El nombre fue actualizado correctamente.");
        printMenu(linkedName);
    }

    public static void removeStudent(LinkedList<String> linkedName, String name) throws IOException {
        linkedName.remove(name);
        System.out.println("El estudiante " + name + " fue eliminado de la lista.");
        printMenu(linkedName);
    }

    public static void searchStudent(BufferedReader br, LinkedList<String> linkedName) throws NumberFormatException, IOException {
        System.out.println("Ingrese el nombre completo del estudiante:");
        String name = br.readLine();

        if (linkedName.contains(name)) {
            System.out.println("El estudiante " + name + "' está presente en la lista.");
            printMenu2(br, linkedName, name);

        } else {
            System.out.println("El estudiante no está en la lista.");
            System.out.println("Volviendo al menú...");
            printMenu(linkedName);
        }
    }

    public static void printMenu2(BufferedReader br, LinkedList<String> linkedName, String name) throws IOException, NumberFormatException {
        System.out.println("¿Qué acción desea realizar?");
        System.out.println("1: Editar");
        System.out.println("2: Remover");
        System.out.println("3: Volver al menú");
        String line = br.readLine();
        int op = Integer.parseInt(line);
        switch (op) {
            case 1:
                replaceName(br, linkedName, name);

                break;
            case 2:
                removeStudent(linkedName, name);

                break;
            case 3:

                printMenu(linkedName);
                break;
            default:
                System.out.println("Opción no válida");
                printMenu(linkedName);
        }
    }

    public static void printMenu(LinkedList<String> linkedName) throws IOException {
        System.out.println("-------------------- Menu --------------------");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Buscar estudiante");
        System.out.println("3. Ver lista de estudiantes");
        System.out.println("4. Salir");
        System.out.println("----------------------------------------------");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int op = Integer.parseInt(line);

        switch (op) {
            case 1:
                addName(linkedName);
                break;
            case 2:
                searchStudent(br, linkedName);
                break;
            case 3:
                printLinkedList(linkedName);
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
                printMenu(linkedName);

        }
    }

    public static void printLinkedList(LinkedList<String> linkedName) throws IOException {

        for (String n : linkedName) {
            System.out.println(n);
        }
        printMenu(linkedName);
    }

    public static void addName(LinkedList<String> linkedName) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("¿Desea agregar al inicio o al final de la lista?");
        System.out.println("1: Inicio \n2: Final");
        String line = br.readLine();
        int op = Integer.parseInt(line);

        System.out.println("Ingrese el nombre completo: ");

        String name = br.readLine();

        if (op == 1) {
            linkedName.addFirst(name);
        } else {
            linkedName.addLast(name);
        }

        printMenu(linkedName);

    }

    public static void printArrayList(ArrayList<String> listNames) {
        for (String n : listNames) {
            System.out.println(n);
        }
    }

    public static ArrayList<String> hashSetToArrayList(HashSet<String> studentNames) {

        ArrayList<String> listNames = new ArrayList<>(studentNames);
        return listNames;
    }

    public static void printHashSet(HashSet<String> studentNames) {
        for (String n : studentNames) {
            System.out.println(n);
        }
    }

    public static void readFile(HashSet<String> studentNames) {
        String file = "Programacion2.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {

            String name;
            while ((name = br.readLine()) != null) {

                String[] attributes = name.split(", ");

                if (attributes.length > 5) {
                    studentNames.add(attributes[4]);

                } else {
                    System.out.println("No tiene suficientes atributos." + name + "zzz");
                }

            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static LinkedList<String> arrayListToLinkedList(ArrayList<String> listNames) {
        LinkedList<String> linkedName = new LinkedList(listNames);
        return linkedName;
    }

}
