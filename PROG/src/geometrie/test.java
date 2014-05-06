package geometrie;

public class test {

	public static void main(String[] args) {
		Punkt p1 = new Punkt(1,2);
		Punkt p2 = new Punkt(1,2);
		Punkt p3 = new Punkt (4,5);
		Punkt p4 = new Punkt (10,15);
		
//		System.out.println(p1.equals(p2));

		Figur2D[] test =new Figur2D[4];
		Kreis k1 = new Kreis(p1,3);
		Kreis k2 = new Kreis(p3);
		
		Rechteck r1 = new Rechteck(p3,10,10);
		Rechteck r2 = new Rechteck(p3,10,10);
		
		
		test[0]= k1;
		test[1]= r1;
		test[2]= k2;
		test[3]= r2;
		
		Quader q1 = new Quader(r1,10);
		Quader q2 = new Quader(r2,10);
		Zylinder z1 = new Zylinder(k1,10);
		Zylinder z2 = new Zylinder(k2,20);
		
		
		System.out.println(q1.equals(z1));
		System.out.println(z2.oberflaeche());
		System.out.println(z1.volumen());
		
		
		
//		for (int i=0;i<test.length;i++)
//			System.out.println(test[i].flaeche());
		
		
		
	}
}
