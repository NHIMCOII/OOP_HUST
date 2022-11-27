package hust.soict.itep.test.disc;

import hust.soict.itep.aims.disc.Dvd;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dvd jungleDVD = new Dvd("Jungle");
		Dvd cinderellaDVD = new Dvd("Cinderella");
		Wrapper wo1 = new Wrapper(jungleDVD);
		Wrapper wo2 = new Wrapper(cinderellaDVD);
		
		swap(wo1,wo2);
		System.out.println("jungle dvd title: " + wo1.a.getTitle());
		System.out.println("cinderella dvd title: " + wo2.a.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Wrapper o1, Wrapper o2) {
		Dvd tmp = o1.a;
		o1.a = o2.a;
		o2.a = tmp;
	}
	
	public static void changeTitle(Dvd dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new Dvd(oldTitle);
	}
}

class Wrapper {
	   Dvd a;
	   public Wrapper(Dvd a){ this.a = a;}
}
