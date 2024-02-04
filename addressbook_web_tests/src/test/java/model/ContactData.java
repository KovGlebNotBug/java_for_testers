package model;

public record ContactData(
        String id,
        String firstName,
        String lastName,
        String address,
        String phoneHome,
        String phoneMobile,
        String phoneWork,
        String email,
        String email2) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "");

    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastName, this.address, this.phoneHome, this.phoneMobile, this.phoneWork, this.email, this.email2);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastName, this.address, this.phoneHome, this.phoneMobile, this.phoneWork, this.email, this.email2);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, lastName, this.address, this.phoneHome, this.phoneMobile, this.phoneWork, this.email, this.email2);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.lastName, address, this.phoneHome, this.phoneMobile, this.phoneWork, this.email, this.email2);
    }

    public ContactData withPhoneHome(String phoneHome) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, phoneHome, this.phoneMobile, this.phoneWork, this.email, this.email2);
    }

    public ContactData withPhoneMobile(String phoneMobile) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phoneHome, phoneMobile, this.phoneWork, email, this.email2);
    }

    public ContactData withPhoneWork(String phoneWork) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phoneHome, this.phoneMobile, phoneWork, email, this.email2);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phoneHome, this.phoneMobile, this.phoneWork, email, this.email2);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.phoneHome, this.phoneMobile, this.phoneWork, this.email, email2);
    }
}