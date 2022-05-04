package akilliCihazProje;

import java.util.ArrayList;
import java.util.List;

public class SicaklikManager 
{
	List<Observer> _observers=new ArrayList<Observer>();
	
	public void AddMember(Observer o)
	{
		_observers.add(o);
	}
	
	public void DeleteMember(Observer o)
	{
		_observers.remove(o);
	}
	
	private void NotifyMember()
	{
		for (Observer observer : _observers) {
			observer.Write();
		}
	}
	
	// S�cakl�k De�eri 0'�n alt�nda oldugunda notifyMember y�ntemi �a��r�l�yor.
	// Sonra da MemberObserver s�n�f� i�erisinde bulunan write y�ntemi �a��r�l�yor.
	public void Sicaklik()
	{
		NotifyMember();
	}
}
