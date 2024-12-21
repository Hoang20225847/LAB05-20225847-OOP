package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    
//    public static void swap(Object o1, Object o2) {
//    	Object tmp = o1;
//    	o1 = o2;
//    	o2 = tmp;
//    }
    // Sua lai ham swap
    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
    	DigitalVideoDisc tmp = new DigitalVideoDisc(d1.getTitle(), d1.getCategory(),  d1.getCost(), d1.getLength(), d1.getDirector());
    	
    	d1.setTitle(d2.getTitle());
    	d1.setCategory(d2.getCategory());
    	d1.setDirector(d2.getDirector());
    	d1.setLength(d2.getLength());
    	d1.setCost(d2.getCost());
    	
    	d2.setTitle(tmp.getTitle());
    	d2.setCategory(tmp.getCategory());
    	d2.setDirector(tmp.getDirector());
    	d2.setLength(tmp.getLength());
    	d2.setCost(tmp.getCost());
    	
    	
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
    	String oldTitle = dvd.getTitle();
    	dvd.setTitle(title);
    	dvd = new DigitalVideoDisc(oldTitle);
    }
}