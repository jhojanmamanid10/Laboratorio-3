import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        addressBook.loadContacts();

        Scanner scanner = new Scanner(System.in);

        Integer option;

        do {

            System.out.println("\n***** CONTACT ADDRESS BOOK *****");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Ver contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Borrar contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {

                System.out.println("Ingrese una opción válida.");
                scanner.next();

                System.out.print("Seleccione una opción: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.print("Ingrese nombre: ");
                    String name = scanner.nextLine();

                    System.out.print("Ingrese email: ");
                    String email = scanner.nextLine();

                    System.out.print("Ingrese edad: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("La edad debe ser un número.");
                        scanner.next();
                        System.out.print("Ingrese edad: ");
                    }

                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese número de celular: ");
                    String phone = scanner.nextLine();

                    Contact contact =
                            new Contact(name, email, age, phone);

                    addressBook.addContact(contact);

                   
                    addressBook.storeContacts();

                    break;

                case 2:

                    addressBook.viewContacts();

                    break;

                case 3:

                    System.out.print(
                            "Ingrese el email del contacto a buscar: ");

                    email = scanner.nextLine();

                    addressBook.searchContact(email);

                    break;

                case 4:

                    System.out.print(
                            "Ingrese el email del contacto a eliminar: ");

                    email = scanner.nextLine();

                    if (addressBook.existsContact(email)) {

                        System.out.println(
                                "Contacto encontrado:");

                        System.out.println(
                                addressBook.getContact(email));

                        System.out.print(
                                "¿Está seguro de eliminarlo? (s/n): ");

                        String confirmation =
                                scanner.nextLine();

                        if (confirmation.equalsIgnoreCase("s")) {

                            addressBook.deleteContact(email);

                            
                            addressBook.storeContacts();

                        } else {

                            System.out.println(
                                    "Eliminación cancelada.");
                        }

                    } else {

                        System.out.println(
                                "No existe un contacto con ese email.");
                    }

                    break;

                case 5:

                    System.out.println("Saliendo de la aplicación...");

                    break;

                default:

                    System.out.println(
                            "Opción inválida. Intente nuevamente.");
            }

        } while (option != 5);

        scanner.close();
    }
}