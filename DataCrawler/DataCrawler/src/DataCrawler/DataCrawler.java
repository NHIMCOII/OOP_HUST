package DataCrawler;
import java.io.IOException;

public class DataCrawler {
	
	public static void main(String[] args) throws IOException {
		final HistoricalCharater_Links hcs = new HistoricalCharater_Links();
		final King_Links kings = new King_Links();
		final President_Links presidents = new President_Links();
		
		// 5' to get all links 5*291 links
		hcs.setLinks(
				"https://nguoikesu.com/nhan-vat?start=0",
				"https://nguoikesu.com"
		);
		hcs.printList(hcs.getLinks());
		
//		kings.setLinks(
//				"https://vi.wikipedia.org/wiki/Vua_Việt_Nam",
//				"https://vi.wikipedia.org"
//		);
//		kings.printList(kings.getLinks());
		
//		presidents.setLinks(
//				"https://vi.wikipedia.org/wiki/Danh_sách_Chủ_tịch_nước_Việt_Nam",
//				"https://vi.wikipedia.org"
//		);
//		presidents.printList(presidents.getLinks());

	}
}
