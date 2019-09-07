package br.com.primefaces.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AutoCompleteBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> clients;
	private String client;
	
	@PostConstruct
	public void init() {
		getAll();
	}
	
	private List<String> getAll(){
		clients= new LinkedList<>(Arrays.asList("Antonio","André","Ana","Andressa"));
		return clients;
	}
	
	public List<String> methodComplete(String client) {
		List<String> list= new LinkedList<>();
		for (String s : clients) {
			if(s.toUpperCase().contains(client.toUpperCase())) {
				list.add(s);
			}
		}
		return list;
	}

	public List<String> getClients() {
		return clients;
	}

	public void setClients(List<String> clients) {
		this.clients = clients;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}
