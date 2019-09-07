package br.com.primefaces.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.primefaces.model.Contact;

@ManagedBean
@ViewScoped
public class DataTableBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Contact contact;
	private List<Contact> contacts;
	
	public void save() throws InterruptedException {
		
		Thread.sleep(2000);
		
		if(!idExists()) {
			return;
		}
		
		if(contacts.contains(contact)) {
			displayMessage("Já existe essa pessoa na lista.");
			return;
		}
		getContacts().add(contact);
		contact= new Contact();
	}
	
	public boolean idExists() {
		for (Contact contact : contacts) {
			if(this.contact.getId().equals(contact.getId())) {
				displayMessage("ID já existe na Lista.");
				return false;
			}
		}
		return true;
	}
	
	private void displayMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, ""));
	}
	
	public void init() {
		contact= new Contact();
		setContacts(new ArrayList<>());
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
