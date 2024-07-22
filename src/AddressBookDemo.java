// AddressBookDemo.java
public class AddressBookDemo{
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        Contacts contact1 = new Contacts("Alice", "123456789", "alice@example.com");
        addressBook.addContact(contact1);

        Contacts contact2 = new Contacts("Bob", "987654321", "bob@example.com");
        addressBook.addContact(contact2);

        System.out.println("Contact List:");
        addressBook.listContacts();

        System.out.println("\nFinding Contact 'Alice':");
        Contacts foundContact = addressBook.findContact("Alice");
        System.out.println(foundContact != null ? foundContact : "Contact not found.");

        addressBook.removeContact("Alice");
        System.out.println("\nContact List after removing 'Alice':");
        addressBook.listContacts();
    }
}
