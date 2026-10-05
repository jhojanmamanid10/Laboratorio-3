import java.io.*;
import java.util.HashMap;

public class AddressBook {

    private HashMap<String, Contact> contacts;

    public AddressBook() {
        this.contacts = new HashMap<>();
    }

    
    public void addContact(Contact contact) {

        if (contacts.containsKey(contact.getEmail())) {

            System.out.println("Ya existe un contacto con este email.");

        } else {

            contacts.put(contact.getEmail(), contact);

            System.out.println("Contacto agregado correctamente.");
        }
    }

    
    public void viewContacts() {

        if (contacts.isEmpty()) {

            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.println("\n--- LISTA DE CONTACTOS ---");

        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }

    
    public void searchContact(String email) {

        if (contacts.containsKey(email)) {

            System.out.println("\nContacto encontrado:");
            System.out.println(contacts.get(email));

        } else {

            System.out.println("Contacto no encontrado.");
        }
    }

   
    public boolean existsContact(String email) {
        return contacts.containsKey(email);
    }

   
    public Contact getContact(String email) {
        return contacts.get(email);
    }


    public void deleteContact(String email) {

        if (contacts.containsKey(email)) {

            contacts.remove(email);

            System.out.println("Contacto eliminado correctamente.");

        } else {

            System.out.println("No existe un contacto con ese email.");
        }
    }

    
    public void storeContacts() {

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream("contacts.dat"))) {

            output.writeObject(contacts);

            System.out.println("Contactos guardados correctamente.");

        } catch (IOException e) {

            System.out.println("Error al guardar los contactos.");
        }
    }

    
    @SuppressWarnings("unchecked")
    public void loadContacts() {

        File file = new File("contacts.dat");

        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            contacts = (HashMap<String, Contact>) input.readObject();

            System.out.println("Contactos cargados correctamente.");

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error al cargar los contactos.");
        }
    }
}