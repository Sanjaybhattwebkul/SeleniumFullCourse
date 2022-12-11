import demopack.CentralTraffic;
public class ImplementInterface implements CentralTraffic,ContinentalTraffic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CentralTraffic a= new AustralianTrafic();
		a.redStop();
		a.FlashYellow();
		a.greenGo();

		AustralianTrafic at=new AustralianTrafic();
		ContinentalTraffic ct=new AustralianTrafic();
		at.walkonsymbol();
		ct.Trainsymbol();
	}

}
