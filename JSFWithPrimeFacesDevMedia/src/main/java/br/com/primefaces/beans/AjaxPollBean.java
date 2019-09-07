package br.com.primefaces.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.TabChangeEvent;

@ManagedBean
@ViewScoped
public class AjaxPollBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private byte count;
	private byte count2;
	private String dateStringFormat;
	
	public void increment() {
		count++;
	}
	public void increment2() {
		count2++;
	}
	
	public void formatDate() {
		Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		DateFormat dateFormat= DateFormat.getInstance();
		dateStringFormat = dateFormat.format(calendar.getTime());
	}

	public byte getCount() {
		return count;
	}

	public void setCount(byte count) {
		this.count = count;
	}

	public String getDateStringFormat() {
		return dateStringFormat;
	}

	public void setDateStringFormat(String dateStringFormat) {
		this.dateStringFormat = dateStringFormat;
	}

	public byte getCount2() {
		return count2;
	}

	public void setCount2(byte count2) {
		this.count2 = count2;
	}

}
