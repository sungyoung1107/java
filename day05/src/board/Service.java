package board;

// 화면이다. 기능(Dao)은 따로 불러준다.
public class Service {
	
	Dao dao;
	
	public Service() {
		dao= new Dao(); //dao 생성
	}
	
	// 게시글 등록
	public void register(String str) {
		// Security or log
		dao.insert(str);
	}
	
	// 게시글 삭제
	public void remove(int num) {
		dao.delete(num);
	}
	
	// 게시글 수정
	public void modify(int num, String str) {
		dao.update(num, str);
	}
	
	// 게시글 선택
	public void select(int num) {
		dao.select(num);
	}
	
	// 해당 글을 가져와라
	public String get(int num) {
		return dao.select(num);
	}

}
