package br.com.primefaces.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class CalendarBean{
	
	private Date date;
	private String dateFormat;
	
	public void formatDate() {
		dateFormat= new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	public void displayDateInGrowl(SelectEvent event) {
		Date date2 = (Date) event.getObject();
		String format = new SimpleDateFormat("dd/MM/yyyy").format(date2);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, format,	format));
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
