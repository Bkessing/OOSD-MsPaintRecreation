package model.interfaces;

public interface IShapeSubject {
	void registerObserver(IShapeObserver observer);
	void notifyObserver();

}
