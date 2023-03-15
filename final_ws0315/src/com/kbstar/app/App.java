package com.kbstar.app;

import java.util.List;
import java.util.Scanner;

import com.kbstar.dto.AccountDTO;
import com.kbstar.dto.TransactionDTO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.BankService;
import com.kbstar.frame.CRUDService;
import com.kbstar.service.AccountServiceImpl;
import com.kbstar.service.BankServiceImpl;
import com.kbstar.service.TransactionServiceImpl;
import com.kbstar.service.UserServiceImpl;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String menu; // 메뉴를 담는 변수
		BankService<UserDTO, AccountDTO, TransactionDTO, String, String> bankService = new BankServiceImpl(); // 할당해줘야 함
		CRUDService<String, AccountDTO> accountService = new AccountServiceImpl();
		CRUDService<String, TransactionDTO> transactionService = new TransactionServiceImpl();
		CRUDService<String, UserDTO> userService = new UserServiceImpl();

		// INTRO //
		System.out.println("== 안녕하십니까 고객님, KB국민은행에 오신 것을 환영합니다! ==");

		// MENU : < 1.입출금/적금계좌, 2.대출계좌, 3.나가기 > //
		while (true) {
			System.out.println("== 거래하실 메뉴를 번호로 입력해주세요 == ");
			System.out.println("< 1.가입하기, 2.로그인하기, 3.나가기 >");
			menu = sc.next(); // 첫번째 메뉴를 입력받는다.

			try {
				if (Integer.parseInt(menu) == 3) {
					// 3. 나가기
					System.out.println("== 고객님 KB국민은행을 거래해주셔서 감사합니다 == ");
					break;
				} else if (Integer.parseInt(menu) == 1) {
					// 1. 가입하기
					System.out.println("== 안녕하세요. KB국민은행이 되는 첫걸음, 가입하기 화면입니다 ==");

					System.out.println("== ID를 입력 하세요 ==");
					String id = sc.next();
					System.out.println("== PW를 입력 하세요 ==");
					String pw = sc.next();
					System.out.println("== 이름 입력 하세요 ==");
					String name = sc.next();
					System.out.println("== 연락처를 입력 하세요 ==");
					String contact = sc.next();

					UserDTO userdto = new UserDTO(id, pw, name, contact);
					try {
						bankService.register(userdto);
						System.out.println("KB국민은행 고객이 되신 것을 진심으로 환영합니다");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				} else if (Integer.parseInt(menu) == 2) {
					// 2. 로그인하기
					System.out.println("== 환영합니다. KB국민은행 로그인 화면입니다. ==");

					System.out.println("== ID를 입력 하세요 ==");
					String id = sc.next();
					System.out.println("== PW를 입력 하세요 ==");
					String pw = sc.next();

					UserDTO userdto = null; // 고객정보
					AccountDTO accountdto = null; // 계좌정보

					// 로그인한 고객 정보
					try {
						userdto = bankService.login(id, pw); // 수정할 것!
						System.out.println("짝짝짝!!! 로그인에 성공하셨습니다 고객님!!!");

						while (true) {
							System.out.println("== 거래하실 메뉴를 번호로 입력해주세요 == ");
							System.out.println(
									"< 1.계좌 만들기, 2.내 계좌 보기, 3.이체하기, 4.계좌 해지하기, 5.내 정보 수정하기, 6.인터넷 뱅킹 해지하기, 7.나가기 >");
							String menu2 = sc.next(); // 첫번째 메뉴를 입력받는다.

							if (Integer.parseInt(menu2) == 7) {
								// 7. 나가기
								System.out.println("== 인트로 화면으로 이동합니다 == ");
								break;
							} else if (Integer.parseInt(menu2) == 1) {
								// 1. 계좌 만들기
								System.out.println("== 계좌를 만들겠습니다 ==");
								System.out.println("== 최초 금액을 입력해주세요 =");
								double money = Integer.parseInt(sc.next()) * 1.0;
								accountdto = new AccountDTO(userdto.getName(), money, userdto.getId());
								try {
									accountService.register(accountdto);
									System.out.println("== 계좌 신규가 완료되었습니다 =");
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							} else if (Integer.parseInt(menu2) == 2) {
								// 2. 내 계좌 보기
								List<AccountDTO> list = null;

								try {
									list = bankService.getAllAccount(userdto.getId());
									for (AccountDTO data : list) {
										System.out.printf("예금주 이름은 %s, 계좌번호는 %s, 잔액은 %.0f원 입니다. \n",
												data.getAccHolder(), data.getAccNum(), data.getBalance());
									}
								} catch (Exception e) {
									e.printStackTrace();
									System.out.println(e.getMessage());
								}

							} else if (Integer.parseInt(menu2) == 3) {
								// 3. 이체하기
								System.out.println("== 출금하실 내 계좌를 입력해주세요 ==");
								String myacc = sc.next();
								System.out.println("== 상대방 계좌를 입력해주세요 ==");
								String racc = sc.next();
								System.out.println("== 보낼 금액을 입력해주세요 =");
								double money = Integer.parseInt(sc.next()) * 1.0;
								try {
									bankService.transaction(myacc, money, "O", racc);
									System.out.println("계좌이체가 성공적으로 완료되었습니다.");
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							} else if (Integer.parseInt(menu2) == 4) {
								// 4. 계좌 해지하기
								System.out.println("== 해지하실 내 계좌를 입력해주세요 ==");
								String myacc = sc.next();
								try {
									accountService.remove(myacc);
									System.out.println("계좌 해지가 완료되었습니다.");
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							} else if (Integer.parseInt(menu2) == 5) {
								// 5. 내 정보 수정하기
								System.out.println("== 수정할 PW를 입력 하세요 ==");
								String pw2 = sc.next();
								System.out.println("== 수정할 이름 입력 하세요 ==");
								String name2 = sc.next();
								System.out.println("== 수정할 연락처를 입력 하세요 ==");
								String contact2 = sc.next();

								UserDTO userdto2 = new UserDTO(userdto.getId(), pw2, name2, contact2);
								try {
									userService.modify(userdto2);
									System.out.println("KB국민은행 고객정보 수정이 정상적으로 완료되었습니다.^^");
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}

							} else if (Integer.parseInt(menu2) == 6) {
								// 6. 인터넷 뱅킹 해지하기
								try {
									System.out
											.println("== 인터넷 뱅킹 해지시에도 고객님의 계좌는 해지 되지 않습니다." + "탈퇴하시겠습니까? (Y, N 입력) ==");
									String menu3 = sc.next();

									if (menu3.equals("Y") || menu3.equals("y")) {
										userService.remove(userdto.getId());
										List<AccountDTO> list = null;
										try {
											list = bankService.getAllAccount(userdto.getId());
											for (AccountDTO data : list) {
												data.setUserId(null); // 인터넷 뱅킹 탈퇴로 userId는 null로 바꾼다.
											}
										} catch (Exception e) {
											System.out.println(e.getMessage());
										}
										System.out.println("사용자 탈퇴가 완료되었습니다.");
										break;

									} else if (menu3.equals("N") || menu3.equals("n")) {
										// 없음
									} else {
										System.out.println("잘못 입력하셨습니다.");
									}

								} catch (Exception e) {
									System.out.println(e.getMessage());
								}

							} else {
								System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
							}
						}

					} catch (NumberFormatException e) {
						System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
					} catch (Exception e1) {
						System.out.println(e1.getMessage());
						break; // 로그인 창으로 올라가기
					}

				} else {
					System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
				}
			} catch (NumberFormatException e) {
				System.out.println("[다시 거래해주세요] 고객님 메뉴 번호를 다시 확인하시고 거래하시기 바랍니다. ");
			}
		}

		sc.close();
	}
}
