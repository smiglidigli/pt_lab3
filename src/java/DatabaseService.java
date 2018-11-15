
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class DatabaseService implements Serializable {

    private DatabaseEntry editedContact;

    public DatabaseEntry getEditedContact() {
        return editedContact;
    }

    public void setEditedContact(DatabaseEntry editedContact) {
        this.editedContact = editedContact;
    }

    public DatabaseService() {

    }

    private final List<DatabaseEntry> contacts = new ArrayList<>();
    private  List<DatabaseEntry> contactsFiltered = new ArrayList<>();

    //sort by name
    public void sortByName() {

        Collections.sort(contacts, new Comparator<DatabaseEntry>() {

            @Override
            public int compare(DatabaseEntry o1, DatabaseEntry o2) {
                return o1.getImie().compareTo(o2.getImie());
            }
        });
    }

    //sort by name
    public void sortBySurname() {

        Collections.sort(contacts, new Comparator<DatabaseEntry>() {

            @Override
            public int compare(DatabaseEntry o1, DatabaseEntry o2) {
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            }
        });
    }

    public List<DatabaseEntry> getContacts() {
        if (contacts.isEmpty()) {
            contacts.add(new DatabaseEntry(1, "Stefan", "Batory", "Wiedeń", "12091683", "rodzina"));
            contacts.add(new DatabaseEntry(2, "John", "Kennedy", "Dallas", "22101683", "rodzina"));
            contacts.add(new DatabaseEntry(3, "Iosif", "Dżugaszwili", "Moskwa", "05031953", "inni"));
            contacts.add(new DatabaseEntry(4, "Jan", "Zbik", "Warszawa", "9971967", "znajomi"));
            contacts.add(new DatabaseEntry(5, "Sułtan", "Kosmitów", "Planeta Wojny", "0000000", "inni"));
            contacts.add(new DatabaseEntry(6, "Adam", "Mickiewicz", "Soplicowo", "24121798", "rodzina"));
        }
        return contacts;
    }
    
    public List<DatabaseEntry> getContactsFiltered() {
        contactsFiltered = new ArrayList<>(contacts);
        return contactsFiltered;
    }
    

    public void addContact(String imie,
            String nazwisko,
            String miasto,
            String numerTelefonu,
            String grupa) {
        int id = 0;
        for (DatabaseEntry contact : this.contacts) {
            if (contact.id > id) {
                id = contact.id;
            }
        }
        DatabaseEntry contact = new DatabaseEntry(++id, imie, nazwisko, miasto, numerTelefonu, grupa);
        contacts.add(contact);
    }

    public void removeContact(int id) {
        DatabaseEntry contactToRemove = contacts.stream().filter(x -> x.getId() == id).findAny().orElse(null);
        contacts.remove(contactToRemove);
        //how to do it e.g. the linq way?
//        for (DatabaseEntry contact : this.contacts) {
//            if (contact.id == id) {
//                contacts.remove(contact);
//                break;
//            }
//        }
    }

    public String goToEditContact(DatabaseEntry dbe) {
        editedContact = dbe;
        return "edycja";
    }

    public String goToAddContact() {
        editedContact = new DatabaseEntry();
        contacts.add(editedContact);
        return "edycja";
    }

    public void setFilter(String input)
    {
        for (DatabaseEntry cont : contacts){
            if(cont.imie.contains(input) || input.equals("")){
                contactsFiltered.add(cont);
            }
        }
    }
    
//    public String save(DatabaseEntry dbe) {
//        DatabaseEntry existingContact = contacts.stream().filter(x -> x.getId() == dbe.id).findAny().orElse(null);
//        if (existingContact == null) {
//            contacts.add(dbe);
//        } else {
//            existingContact = dbe;
//        }
//        return "index";
//    }
}
