import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contacts> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contacts contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public Contacts findContact(String name) {
        for (Contacts contact : contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public void listContacts() {
        for (Contacts contact : contacts) {
            System.out.println(contact);
        }
    }
    public List<Contacts> getContacts() {
        return contacts;
    }
}