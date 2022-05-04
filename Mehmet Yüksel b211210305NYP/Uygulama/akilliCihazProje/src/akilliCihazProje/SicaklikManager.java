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
	
	// Sýcaklýk Deðeri 0'ýn altýnda oldugunda notifyMember yöntemi çaðýrýlýyor.
	// Sonra da MemberObserver sýnýfý içerisinde bulunan write yöntemi çaðýrýlýyor.
	public void Sicaklik()
	{
		NotifyMember();
	}
}
